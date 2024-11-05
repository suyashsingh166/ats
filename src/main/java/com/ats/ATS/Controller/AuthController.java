package com.ats.ATS.Controller;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import java.util.Optional;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import com.ats.ATS.Repository.UserRepository;

import com.ats.ATS.Response.GeneralMessage;
import com.ats.ATS.Response.ServiceResponse;
import com.ats.ATS.Security.JwtHelper;
import com.ats.ATS.Service.ApplicantService;
import com.ats.ATS.Service.DepartmentService;
import com.ats.ATS.Service.JobCreationService;
import com.ats.ATS.Service.JobRequestSevice;
import com.ats.ATS.Service.MasterService;
import com.ats.ATS.Service.UserService;
import com.ats.ATS.model.ApplicantData;
import com.ats.ATS.model.Department;

import com.ats.ATS.model.JobCreation;
import com.ats.ATS.model.JobRequest;

import com.ats.ATS.model.JwtRequest;
import com.ats.ATS.model.JwtResponse;

import com.ats.ATS.model.Roles;
import com.ats.ATS.model.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/auth")
public class AuthController {

	@Autowired
    private UserDetailsService userDetailsService;
	
	@Autowired

	private JobCreationService jobCreationService;
	
	@Autowired
    private UserRepository userRepository;

	@Autowired

	UserService userService;


    @Autowired
    private AuthenticationManager manager;
   
    
    
    @Autowired
    ApplicantService applicantservice;

    @Autowired
    private JwtHelper helper;

    private Logger logger = LoggerFactory.getLogger(AuthController.class);
    
    
    @Autowired
    DepartmentService departmentService;
    
    @Autowired
    JobRequestSevice jobRequestSevice;
 @Autowired 
 MasterService masterService;

    @PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody User user) {
    	
    	Optional<User> newuser=userRepository.findByEmail(user.getEmail());
      	User nuser=newuser.orElse(null);
      	if(nuser ==null) {
      		String role="ROLE_USER";
      		user.setRole(role);
      		user.setPassword("1234");
      		Date in = new Date();
      	   user.setCreationDate(in);
      		User users=userService.createUser(user);
      		this.doAuthenticate(user.getEmail(), "1234");
      		UserDetails userDetails = userDetailsService.loadUserByUsername(users.getEmail());
            String token = this.helper.generateToken(userDetails);
            
            int depid;
            try {
             depid=departmentService.finddepartmentid(users.getDepartment());
            }
            catch(Exception e) {
            	depid=0;	
            }
            System.out.println("dep"+depid);
            int desid=masterService.finddesignationid(users.getDesignation());
            JwtResponse first=new JwtResponse();
            first.setJwtToken(token);
            first.setUsername(user.getEmail());
            first.setRole(users.getRole());
            first.setDesignation(user.getDesignation());
          first.setDepartment(user.getDepartment());
           first.setId(users.getId());
           first.setName(users.getName());
           first.setDepartment_id(depid);
           first.setDesignation_id(desid);

           return new ResponseEntity<>(first, HttpStatus.OK);
      	}
      	else {
      		 
      		 this.doAuthenticate(user.getEmail(), "1234");
             

             UserDetails userDetails = userDetailsService.loadUserByUsername(user.getEmail());
             
             String username=userDetails.getUsername();
             String token = this.helper.generateToken(userDetails);
           // logger.debug(token);
             User users=userService.findbyUsername(username);
             int depid;
             try {
              depid=departmentService.finddepartmentid(users.getDepartment());
             }
             catch(Exception e) {
             	depid=0;	
             }
             System.out.println("dep"+depid);
             int desid=masterService.finddesignationid(users.getDesignation());
             JwtResponse first=new JwtResponse();
            first.setJwtToken(token);
            first.setUsername(username);
            first.setRole(users.getRole());
            first.setDesignation(users.getDesignation());
          first.setDepartment(users.getDepartment());
           first.setId(users.getId());
           first.setName(users.getName());
           first.setDepartment_id(depid);
           first.setDesignation_id(desid);

           return new ResponseEntity<>(first, HttpStatus.OK);
      	}
    }
 



	private void doAuthenticate(String email, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(email, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
    


    @PostMapping("/create-user")
    public ServiceResponse<?> createUser(@RequestBody User user) {
    	Optional<User> newuser=userRepository.findByEmail(user.getEmail());
    	User nuser=newuser.orElse(null);
    	if(nuser ==null) {
    		User users=userService.createUser(user);
    	return new ServiceResponse<>(new GeneralMessage<>("Roles Created", true, 201), HttpStatus.CREATED);
    	}
    	else
    	return new ServiceResponse<>(new GeneralMessage<>("User Already exists!!", 1, 409),
				HttpStatus.CONFLICT);
    	
    	
    }
    
    @GetMapping("getAllUsers")
    public List<User> getUser(){
    	return userService.getUsers();
    }
    
    @GetMapping("/department")
    public ServiceResponse<?> department(){
    	List<Department> departments = departmentService.find();
    	System.out.println("list"+departments.toString());
    	return new ServiceResponse<>(new GeneralMessage<>("OK",departments, 200), HttpStatus.OK);
    }
    
    @GetMapping("getAllRoles")
    public List<Roles> getRoles(){
    	return departmentService.findRole();
    }
    
  

	
	@PostMapping("/jobCreation")
	public ServiceResponse<?> jobCreation(@RequestBody JobCreation job) {
		Date d2 = new Date();
		if(job.getRound1()==null) {
			job.setRound1("");
		}
		if(job.getRound2()==null) {
			job.setRound2("");
		}
		if(job.getRound3()==null) {
			job.setRound3("");
		}
		if(job.getRound4()==null) {
			job.setRound4("");
		}
		if(job.getRound5()==null) {
			job.setRound5("");
		}
		job.setCreated_date(d2);
		Boolean isassignedtorecruitor=false;
		Boolean isacceptedbyhod=false;
		Boolean isacceptedbychro=false;
		job.setIsacceptedbychro(isacceptedbychro);
		job.setIsacceptedbyhod(isacceptedbyhod);
		job.setIsassignedtorecruitor(isassignedtorecruitor);
		jobCreationService.saveJobCreation(job);
		return new ServiceResponse<>(new GeneralMessage<>("Job Created Successfully", true, 201), HttpStatus.CREATED);
	
	}
	
	@PutMapping("/updatejobCreation")
	public ServiceResponse<?> updatejobCreation(@RequestBody JobCreation job,@RequestParam int id) {
		JobCreation jobs=jobCreationService.getAlljobCreationbyid(id);
		job.setId(id);
		job.setBand(jobs.getBand());
		job.setChro_remarks(jobs.getChro_remarks());
		job.setChroaccepted_date(jobs.getChroaccepted_date());
		job.setCreated_date(jobs.getCreated_date());
		job.setDepartment(jobs.getDepartment());
		job.setDepartment_id(jobs.getDepartment_id());
		job.setDepartment_name(jobs.getDepartment_name());
		job.setDesignation(jobs.getDesignation());
		job.setDesignation_id(jobs.getDesignation_id());
		job.setEducational_qualifications(jobs.getEducational_qualifications());
		job.setHiringmanager(jobs.getHiringmanager());
		job.setHod_remarks(jobs.getHod_remarks());
		job.setIsacceptedbychro(jobs.getIsacceptedbychro());
		job.setIsacceptedbyhod(jobs.getIsacceptedbyhod());
		job.setIsassignedtorecruitor(jobs.getIsassignedtorecruitor());
		job.setIt_nonit_assets(jobs.getIt_nonit_assets());
		job.setLocation(jobs.getLocation());
		job.setNo_of_position(jobs.getNo_of_position());
		job.setProject_name(jobs.getProject_name());
		job.setPriority(jobs.getPriority());
		job.setRecruiter(jobs.getRecruiter());
		job.setRequest_position_name(jobs.getRequest_position_name());
		job.setRequestedby(jobs.getRequestedby());
		job.setRequesterId(jobs.getRequesterId());
		job.setRequestername(jobs.getRequestername());
		job.setRmaccepted_date(jobs.getRmaccepted_date());
		job.setRound(jobs.getRound());
		job.setRound1(jobs.getRound1());
		job.setRound2(jobs.getRound2());
		job.setRound3(jobs.getRound3());
		job.setRound4(jobs.getRound4());
		job.setRound5(jobs.getRound5());
		job.setStatus(jobs.getStatus());
		job.setStatus_id(jobs.getStatus_id());
		job.setStatusdesc(jobs.getStatusdesc());
		job.setTarget_date(jobs.getTarget_date());
		job.setWorking_days(jobs.getWorking_days());
		
		jobCreationService.updateJobCreation(job);
		return new ServiceResponse<>(new GeneralMessage<>("Job Updated Successfully", job, 201), HttpStatus.CREATED);
	
	}
	
	 @GetMapping("/getAlljobCreationbyid")
	    public JobCreation getAlljobCreationbyid(@RequestParam("id")Integer id){
	    	return jobCreationService.getAlljobCreationbyid(id);
	    }
	 
	 @GetMapping("/getAlljobCreation")
	    public List<JobCreation> getAlljobCreation(){
	    	return jobCreationService.getAlljobCreation();
	    }
	 
	 @GetMapping("/getApprovalPendingbyCHRO")
	    public List<JobCreation> getApprovalPendingbyCHRO(){
		 String status="CP";
	    	return jobCreationService.getApprovalPendingbyCHRO(status);
	    }
	 
	 @GetMapping("/getJobCreationBySupervisor")
	    public List<JobCreation> getJobCreationBySupervisor( @RequestParam String username){
		 
	    	return jobCreationService.getJobCreationBySupervisor(username);
	    }
	 
	 @GetMapping("/getJobCreationByDepartment")
	    public List<JobCreation> getJobCreationByDepartment(){
	    	return jobCreationService.getJobCreationByDepartment();
	    }

	 
	 @DeleteMapping("/deletejobCreation")
		public ServiceResponse<?> deletejobCreation(@RequestParam("id") int id) {
		 jobCreationService.deletejobCreationById(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
	 
	 @DeleteMapping("/deleteUser")
		public ServiceResponse<?> deleteUser(@RequestParam("id") int id) {
		 userService.deleteUser(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
	 
	 
	 @GetMapping("/getAlljobRequest")
	    public List<JobRequest> getAlljobRequest(){
	    	return jobRequestSevice.getAlljobRequest();
	    }
 
	 
	 @DeleteMapping("/deletejobRequest")
		public ServiceResponse<?> deletejobRequest(@RequestParam("id") int id) {
		 jobRequestSevice.deletejobRequest(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
		
	 @PostMapping("/jobRequest")
		public ServiceResponse<?> jobRequest(@RequestBody JobRequest job) {
			Date d2 = new Date();
			job.setCreated_date(d2);
			jobRequestSevice.saveJobRequest(job);
			return new ServiceResponse<>(new GeneralMessage<>("Job Request Created Successfully", true, 201), HttpStatus.CREATED);
		
		}
}