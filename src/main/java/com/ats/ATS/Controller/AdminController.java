package com.ats.ATS.Controller;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ATS.DTO.ApplicantDTO;
import com.ats.ATS.Repository.UserRepository;
import com.ats.ATS.Response.GeneralMessage;
import com.ats.ATS.Response.ServiceResponse;
import com.ats.ATS.Service.ActionService;
import com.ats.ATS.Service.ApplicantService;
import com.ats.ATS.Service.DepartmentService;
import com.ats.ATS.Service.JobCreationService;
import com.ats.ATS.Service.StatusService;

import com.ats.ATS.Service.MasterService;
import com.ats.ATS.Service.PriviligeService;

import com.ats.ATS.Service.UserService;
import com.ats.ATS.model.*;

@RestController
@CrossOrigin(origins = "*",allowedHeaders = "*")
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private MasterService masterservice;
	
	@Autowired
	private PriviligeService priviligeService;
	
	@Autowired
	private ActionService actionService;
	
	@Autowired
    private UserRepository userRepository;
	

	@Autowired
    private StatusService statusService;

 
    @Autowired
    private UserService userService;
    
    @Autowired
   private JobCreationService jobcreation;
    
    @Autowired
    ApplicantService applicantservice;
     private Logger logger = LoggerFactory.getLogger(AdminController.class);
     
     @Autowired
     ApplicantService applicantService;
    
    @Autowired
    DepartmentService departmentService;
	
	 @PostMapping("/create-user")
	    public ServiceResponse<?> createUser(@RequestBody User user) {
	    	Optional<User> newuser=userRepository.findByEmail(user.getEmail());
	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	        Date date = new Date();  
	        System.out.println(formatter.format(date)); 
	    	User nuser=newuser.orElse(null);
	    	if(nuser ==null) {
	    		user.setCreationDate(date);
	    		User users=userService.createUser(user);
	    		logger.info("User created");
	    	return new ServiceResponse<>(new GeneralMessage<>("User Created", true, 201), HttpStatus.CREATED);
	    	}
	    	else
	    	return new ServiceResponse<>(new GeneralMessage<>("User Already exists!!", 1, 409),
					HttpStatus.CONFLICT);
	    	
	    	
	    }
	    
	    @GetMapping("getAllUsers")
	    public List<User> getUser(){
	    	System.err.println("controller");
	    	try {
	    	return userService.getUsers();
	    	}catch(Exception e) {
	    		System.out.println(e.getLocalizedMessage());
	    	}
	    	return userService.getUsers();
	    }
	    
	    @PutMapping("/updateuser")
	    public ServiceResponse<?> updateuser(@RequestParam String id,@RequestParam String designation,@RequestParam String department) {
	    	userService.updateuser(id,designation,department);
	    	return new ServiceResponse<>(new GeneralMessage<>("User Created", true, 201), HttpStatus.CREATED);
	    	
	    }
	    
	    @GetMapping("/department")
	    public List<Department> department(){
	    	
	    	return departmentService.find();
	    }
	    
	    @GetMapping("getAllRoles")
	    public List<Roles> getRoles(){
	    	return departmentService.findRole();
	    }
	    
	   
	    
	    @GetMapping("getCandidatebyMail")
	    public ServiceResponse<?> getCandidateByMail(@RequestParam String mail){
	    	ApplicantData data= applicantservice.getCandidateByMail(mail);
	    	
	    	if(data !=null) {
	    		return new ServiceResponse<>(new GeneralMessage<>("User Created", data, 200), HttpStatus.OK);
	    	}
	    	else
	    		return new ServiceResponse<>(new GeneralMessage<>("User Not Found", 1, 409),
	    				HttpStatus.CONFLICT);
	    }

		@PostMapping("/createRole")
		public ServiceResponse<?> createRole(@RequestBody Roles role) {
			Date d2 = new Date();
			role.setCreated_date(d2);
			String roleName = departmentService.checkrole(role.getRoles());
			if(roleName == null)
			{
			departmentService.saverolemaster(role);
			return new ServiceResponse<>(new GeneralMessage<>("Role Created", true, 201), HttpStatus.CREATED);
		}else {
			return new ServiceResponse<>(new GeneralMessage<>("Role Already exists!!", false, 409),
					HttpStatus.CONFLICT);
		}
		}
		
		@PostMapping("/createDepartment")
		public ServiceResponse<?> createDepartment(@RequestBody Department dept) {
			Date d2 = new Date();
			dept.setCreated_date(d2);
			System.out.println("dept.getDepartment()==="+dept.getDepartment()); 
			String deptName = departmentService.checkdept(dept.getDepartment());
			System.out.println("deptName==="+deptName); 
			if(deptName == null)
			{
				departmentService.savedeptmaster(dept);
			return new ServiceResponse<>(new GeneralMessage<>("Department Created", true, 201), HttpStatus.CREATED);
		}else {
			return new ServiceResponse<>(new GeneralMessage<>("Department Already exists!!", false, 409),
					HttpStatus.CONFLICT);
		}
		}
		
		@DeleteMapping("/deleterole")
		public ServiceResponse<?> deleterole(@RequestParam("id") int id) {
			departmentService.deleteroleById(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
		
		@DeleteMapping("/deletedept")
		public ServiceResponse<?> deletedept(@RequestParam("id") int id) {
			departmentService.deletedeptById(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
		
		@PostMapping("/createStatus")
		public ServiceResponse<?> createStatus(@RequestBody Status status) {
			Date d2 = new Date();
			status.setCreated_date(d2);
				statusService.saveStatus(status);
			return new ServiceResponse<>(new GeneralMessage<>("Department Created", true, 201), HttpStatus.CREATED);
		
		}
		
		@DeleteMapping("/deletestatus")
		public ServiceResponse<?> deletestatus(@RequestParam("id") int id) {
			statusService.deletestatusById(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
		
		@GetMapping("getAllStatus")
	    public List<Status> getAllStatus(){
	    	return statusService.getAllStatus();
	    }
		
		

		

		@PostMapping("/createAction")
		public ServiceResponse<?> createAction(@RequestBody ActionModel action) {
			Date d2 = new Date();
			action.setCreated_date(d2);
			String actionname = actionService.action_name(action.getAction_name());
			if(actionname == null)
			{
				actionService.saveAction(action);
			return new ServiceResponse<>(new GeneralMessage<>("Action Created", true, 201), HttpStatus.CREATED);
		}else {
			return new ServiceResponse<>(new GeneralMessage<>("Action Already exists!!", false, 409),
					HttpStatus.CONFLICT);
		}
		}
		
		   
	    @GetMapping("getAllAction")
	    public List<ActionModel> getAllAction(){
	    	return actionService.getAllAction();
	    }
		
	    @DeleteMapping("deleteAction")
		public ServiceResponse<?> deleteAction(@RequestParam("id") int id) {
	    	actionService.deleteActionById(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
	    
	    @PostMapping("createPrivlige")
		public ServiceResponse<?> createPrivlige(@RequestBody PriviligeModel privilige) {
			Date d2 = new Date();
			privilige.setCreated_date(d2);
			Integer privligeId = priviligeService.roleIdCheck(privilige.getRole_Id());
			if (privligeId == null)
			{
				priviligeService.savePrivilge(privilige);
			return new ServiceResponse<>(new GeneralMessage<>("Action Created Successfully", true, 201), HttpStatus.CREATED);
		}else {
		
			Date createDate = priviligeService.getcreateDate(privligeId);
			privilige.setAction_permissions(privilige.getAction_permissions());
			privilige.setRole_Id(privilige.getRole_Id());
			privilige.setCreated_date(createDate);
			priviligeService.updatePrivilge(privligeId,privilige);
			return new ServiceResponse<>(new GeneralMessage<>("Action Data Updated Successfully!!", true, 200),
					HttpStatus.OK);
		}
		}
	    
	    @GetMapping("getAllPrivlige")
	    public List<PriviligeModel> getAllPrivlige(){
	    	return priviligeService.getAllPrivlige();
	    }
		
	    @DeleteMapping("deletePrivlige")
		public ServiceResponse<?> deletePrivlige(@RequestParam("id") int id) {
	    	priviligeService.deletePrivlige(id);
			return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
					HttpStatus.OK);
		
		}
	    
	    

		@PostMapping("/createDesignation")
		public ServiceResponse<?> createDesignation(@RequestBody DesignationMaster desig) {
			Date d2 = new Date();
			desig.setCreated_date(d2);
			String designation = masterservice.designationname(desig.getDesignation());
			if(designation == null)
			{
				masterservice.saveDesignation(desig);
			return new ServiceResponse<>(new GeneralMessage<>("Designation Created", true, 201), HttpStatus.CREATED);
		}else {
			return new ServiceResponse<>(new GeneralMessage<>("Designation Already exists!!", false, 409),
					HttpStatus.CONFLICT);
		}
		}
		
		
		  @GetMapping("getAllDesignation")
		    public List<DesignationMaster> getAllDesignation(){
		    	return masterservice.getAllDesignation();
		    }
			
		    @DeleteMapping("deleteDesignation")
			public ServiceResponse<?> deleteDesignation(@RequestParam("id") int id) {
		    	masterservice.deleteDesignation(id);
				return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
						HttpStatus.OK);
			
			}
		    
		    
		    @PostMapping("/createLocation")
			public ServiceResponse<?> createDesignation(@RequestBody LocationMaster locat) {
				Date d2 = new Date();
				locat.setCreated_date(d2);
				String location = masterservice.locationnname(locat.getLocation());
				if(location == null)
				{
					masterservice.saveLocation(locat);
				return new ServiceResponse<>(new GeneralMessage<>("Location Created", true, 201), HttpStatus.CREATED);
			}else {
				return new ServiceResponse<>(new GeneralMessage<>("Location Already exists!!", false, 409),
						HttpStatus.CONFLICT);
			}
			}
			
			
			  @GetMapping("getAllLocation")
			    public List<LocationMaster> getAllLocation(){
			    	return masterservice.getAllLocation();
			    }
				
			    @DeleteMapping("deleteLocation")
				public ServiceResponse<?> deleteLocation(@RequestParam("id") int id) {
			    	masterservice.deleteLocation(id);
					return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
							HttpStatus.OK);
				
				}
			    
			    @PostMapping("/createQualification")
				public ServiceResponse<?> createQualification(@RequestBody QualificationMaster quali) {
					Date d2 = new Date();
					quali.setCreated_date(d2);
					String qualification = masterservice.qualification(quali.getQualification());
					if(qualification == null)
					{
						masterservice.saveQualification(quali);
					return new ServiceResponse<>(new GeneralMessage<>("Qualification Created", true, 201), HttpStatus.CREATED);
				}else {
					return new ServiceResponse<>(new GeneralMessage<>("Qualification Already exists!!", false, 409),
							HttpStatus.CONFLICT);
				}
				}
				
				
				  @GetMapping("getAllQualification")
				    public List<QualificationMaster> getAllQualification(){
				    	return masterservice.getAllQualification();
				    }
					
				    @DeleteMapping("deleteQualification")
					public ServiceResponse<?> deleteQualification(@RequestParam("id") int id) {
				    	masterservice.deleteQualification(id);
						return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
								HttpStatus.OK);
					
					}
				    
				    @PostMapping("/createRounds")
					public ServiceResponse<?> createQualification(@RequestBody RoundsMaster round) {
						Date d2 = new Date();
						round.setCreated_date(d2);
						Integer noOfRound= masterservice.noOfRounds(round.getNo_of_rounds());
						if(noOfRound == null)
						{
							masterservice.saveRounds(round);
						return new ServiceResponse<>(new GeneralMessage<>("Qualification Created", true, 201), HttpStatus.CREATED);
					}else {
						return new ServiceResponse<>(new GeneralMessage<>("Qualification Already exists!!", false, 409),
								HttpStatus.CONFLICT);
					}
					}
					
					
					  @GetMapping("getAllRounds")
					    public List<RoundsMaster> getAllRounds(){
					    	return masterservice.getAllRounds();
					    }
						
					    @DeleteMapping("deleteRounds")
						public ServiceResponse<?> deleteRounds(@RequestParam("id") int id) {
					    	masterservice.deleteRounds(id);
							return new ServiceResponse<>(new GeneralMessage<>("Data Deleted Successfully!", true, 200),
									HttpStatus.OK);
						
						}
					    
					    @PutMapping("editRounds")
						public ServiceResponse<?> updateRound(@RequestBody RoundsMaster round, @RequestParam Integer id) {
							Date createDate = masterservice.getcreateDate(id);
							round.setCreated_date(createDate);
					    	Integer noOfRound= masterservice.noOfRounds(round.getNo_of_rounds());
							if(noOfRound == null)
							{
						    	masterservice.updateRound(id,round);
							return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
						}else {
							return new ServiceResponse<>(new GeneralMessage<>("NO. of Rounds Already exists!!", false, 409),
									HttpStatus.CONFLICT);
						}
}
					    @PutMapping("editQualification")
						public ServiceResponse<?> editQualification(@RequestBody QualificationMaster quali, @RequestParam Integer id) {
							Date createDate = masterservice.getcreateDateQuali(id);
							quali.setCreated_date(createDate);
							String qualification = masterservice.qualification(quali.getQualification());
							if(qualification == null)
							{
						    	masterservice.updateQualification(id,quali);
							return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
						}else {
							return new ServiceResponse<>(new GeneralMessage<>("Qualification Already exists!!", false, 409),
									HttpStatus.CONFLICT);
						}
					    }
					    @PutMapping("editLocation")
					    public ServiceResponse<?> editLocation(@RequestBody LocationMaster locat, @RequestParam Integer id) {
							Date createDate = masterservice.getcreateDateLoc(id);
							locat.setCreated_date(createDate);
							String location = masterservice.locationnname(locat.getLocation());
							if(location == null)
							{
						    	masterservice.updateLocation(id,locat);
							return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
						}else {
							return new ServiceResponse<>(new GeneralMessage<>("Location Already exists!!", false, 409),
									HttpStatus.CONFLICT);
						}
					    }
					    
					    
					    @PutMapping("editDesignation")
					    public ServiceResponse<?> editDesignation(@RequestBody DesignationMaster desig, @RequestParam Integer id) {
							Date createDate = masterservice.getcreateDateDesignation(id);
							desig.setCreated_date(createDate);
							String designation = masterservice.designationname(desig.getDesignation());
							if(designation == null)
							{
						    	masterservice.updateDesignation(id,desig);
							return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
						}else {
							return new ServiceResponse<>(new GeneralMessage<>("Designation Already exists!!", false, 409),
									HttpStatus.CONFLICT);
						}
					    }
					    
					    
					    @PutMapping("editRoles")
					    public ServiceResponse<?> editRoles(@RequestBody Roles role, @RequestParam Integer id) {
					    	Date createDate = departmentService.getcreateRole(id);
					    	role.setCreated_date(createDate);
							String roleName = departmentService.checkrole(role.getRoles());
							if(roleName == null)
							{
								departmentService.updateRole(id,role);
						    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
							}else {
								return new ServiceResponse<>(new GeneralMessage<>("Roles Already exists!!", false, 409),
										HttpStatus.CONFLICT);
							}

					    }
					    
						@PutMapping("/editAction")
						public ServiceResponse<?> updateAction(@RequestBody ActionModel action, @RequestParam Integer id) {
							Date createDate = actionService.getcreateaction(id);
							action.setCreated_date(createDate);
							String actionname = actionService.action_name(action.getAction_name());
							if(actionname == null)
							{
								actionService.updateAction(id,action);
						    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
							}else {
								return new ServiceResponse<>(new GeneralMessage<>("Action Already exists!!", false, 409),
										HttpStatus.CONFLICT);
							}

					    }
						
						
						 @GetMapping("getActioName")
						    public ServiceResponse<?>  getActioName(){
						    	ArrayList<ActionDto> list = actionService.getActioName();
						    	
						    	if(list.size()>= 1)
								{
							    	return new ServiceResponse<>(new GeneralMessage<>("Data", list, 200), HttpStatus.OK);
								}else {
									return new ServiceResponse<>(new GeneralMessage<>("No Data Found", list, 404),
											HttpStatus.NOT_FOUND);
								}
						    }
						 
						 
						 @GetMapping("getActionPermission")
						    public ServiceResponse<?>  getActioPermission(@RequestParam int role_Id){
						    	String list = priviligeService.getActioPermission(role_Id);
						    	
						    	if(list!= null)
								{
							    	return new ServiceResponse<>(new GeneralMessage<>("Data", list, 200), HttpStatus.OK);
								}else {
									return new ServiceResponse<>(new GeneralMessage<>("No Data Found", "No Data Found", 200),
											HttpStatus.OK);
								}
						    }
						 
						    @PutMapping("declinedByCHRO")
						    public ServiceResponse<?> declinedByCHRO( @RequestParam String chro_remarks, @RequestParam int id) {
						    	Status status=statusService.fetchstatus("CD");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="CD";
						    	String desc=status.getDescription();
								Boolean isacceptedbychro=false;
						    	jobcreation.declinedByCHRO(sid,sta,desc,isacceptedbychro,chro_remarks, id);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
						    
						    @PutMapping("declinedByHOD")
						    public ServiceResponse<?> declinedByHOD( @RequestParam String hod_remarks, @RequestParam int id) {
						    	Status status=statusService.fetchstatus("HD");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="HD";
						    	String desc=status.getDescription();
								Boolean isacceptedbyhod=false;
						    	jobcreation.declinedByHOD(sid,sta,desc,isacceptedbyhod,hod_remarks, id);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
						    
						    @PutMapping("acceptedByCHRO")
						    public ServiceResponse<?> acceptedByCHRO( @RequestParam String chro_remarks, @RequestParam int id,@RequestParam String hiringmanager) {
						    	Status status=statusService.fetchstatus("RM");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="RM";
						    	String desc=status.getDescription();
								Boolean isacceptedbychro=true;
						    	jobcreation.acceptedByCHRO(sid,sta,desc,isacceptedbychro,chro_remarks, id,hiringmanager);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
						    
						    @PutMapping("acceptedByHOD")
						    public ServiceResponse<?> acceptedByHOD( @RequestParam String hod_remarks, @RequestParam int id) {
						    	Status status=statusService.fetchstatus("CP");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="CP";
						    	String desc=status.getDescription();
								Boolean isacceptedbyhod=true;
						    	jobcreation.acceptedByHOD(sid,sta,desc,isacceptedbyhod,hod_remarks, id);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
						    
						    @GetMapping("/JobCreationRecuriter")
						    public ArrayList<JobCreation> JobListRecuriter(@RequestParam String email){
						    	
						    	return jobcreation.JobListRecuriter(email);
						    	
						    
						    }
						    
						    @GetMapping("/requesterid")
						    public String requesterid(@RequestParam Integer id){
						    	
						    	return jobcreation.getrequesterid(id);
						    	
						    
						    }
						    
						    
						    @GetMapping("/departmentName")
						    public ServiceResponse<?>  getallDept(){
						    	
						    	ArrayList<String> obj = departmentService.getallDept();
						    	if(obj.size()>= 1)
								{
							    	return new ServiceResponse<>(new GeneralMessage<>("Data", obj, 200), HttpStatus.OK);
								}else {
									return new ServiceResponse<>(new GeneralMessage<>("No Data Found", obj, 404),
											HttpStatus.NOT_FOUND);
								}
						    
						    }
						    
						    @PutMapping("acceptedApplicant")
						    public ServiceResponse<?> acceptedApplicant( @RequestParam String remarks, @RequestParam String id,@RequestParam String panel) {
						    	Status status=statusService.fetchstatus("SD");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="SD";
						    	String desc=status.getDescription();
						    	Boolean isinterviewonescheduled=false;
								applicantService.acceptedApplicant(remarks, id,statusid,sta,desc,panel,isinterviewonescheduled);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
					
						    
						    @PutMapping("rejectedApplicant")
						    public ServiceResponse<?> rejectedApplicant( @RequestParam String remarks, @RequestParam String id) {
						    	Status status=statusService.fetchstatus("CR");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="CR";
						    	String desc=status.getDescription();
								applicantService.rejectedApplicant(remarks, id,statusid,sta,desc);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
						    
						    @PutMapping("assignrecruitor")
						    public ServiceResponse<?> assignrecruitor(  @RequestParam int id,@RequestParam String targetdate,@RequestParam String hiringmanager) throws ParseException {
						    	Status status=statusService.fetchstatus("RA");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="RA";
						    	String desc=status.getDescription();
						    	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
						    	Date date = dateFormat.parse(targetdate);
						    	System.out.println("dates@@@"+date);
								Boolean isassignedtorecruitor=true;
						    	jobcreation.assignrecruitor(sid,sta,desc,isassignedtorecruitor, id,hiringmanager,date);
							    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
								
						    }
						    
						    @GetMapping("/JobCreationRecurit")
						    public ArrayList<JobCreation> JobListRecurit(@RequestParam String email){
						    	System.out.println("list"+jobcreation.JobListRecurit(email));
						    	return jobcreation.JobListRecurit(email);
						    	
						    
						    }
						    @PutMapping("candidateresult")
						    public ServiceResponse<?> candidateresult( @RequestParam String cid, @RequestParam String result) {
						    	String tru="true";
						    	String fal="false";
						    	try {
						    		System.out.println("true");
						    	if(result.equals(tru)) {
						    	Status status=statusService.fetchstatus("CCI");
						    	int statusid=status.getId();
						    	String sid=String.valueOf(statusid);
						    	String sta="CCI";
						    	String desc=status.getDescription();
								Boolean cleared=true;
								applicantService.updateresult(sid,sta,desc,cid,cleared);
						    			}
						    	if(result.equals(fal)){
						    		System.out.println("false");
						    		Status status=statusService.fetchstatus("CR");
							    	int statusid=status.getId();
							    	String sid=String.valueOf(statusid);
							    	String sta="CR";
							    	String desc=status.getDescription();
							    	Boolean cleared=false;
									applicantService.updateresult(sid,sta,desc,cid,cleared);
							    			}
						    	return new ServiceResponse<>(new GeneralMessage<>("Data Updated Successfully", true, 201), HttpStatus.CREATED);
						    	}
						    	catch(Exception e) {
						    		System.out.println(e.getLocalizedMessage());
						    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
						    	}
						    	}
						    @GetMapping("/list")
				              public List<String> listFiles(@RequestParam String candidateId) {
				                  String path= applicantservice.getAllCandidatesbyid(candidateId)+"\\";
				                  System.out.println("pat"+path);
				                  Path candidateDir = Paths.get(path); 
				                  List<String> fileNames = new ArrayList<>();

				                  try {
				                      Files.list(candidateDir).forEach(file -> fileNames.add(file.getFileName().toString()));
				                  } catch (Exception e) {
				                      e.printStackTrace();
				                  }

				                  return fileNames;
				              }
						    @GetMapping("/docpath")
						    public String docpath(@RequestParam String candidateId){
						    	 String path= applicantservice.getAllCandidatesbyid(candidateId)+"\\";
						    	return path;
						    	
						    
						    }
						    
						    @PutMapping("saveencryptedid")
						    public ServiceResponse<?> saveencryptedid( @RequestParam String id) {
						    
						    	try {
						    		String secret="atsbysuyash";
						    		 Status status=statusService.fetchstatus("MSFD");
								    	int statusid=status.getId();
								    	String sid=String.valueOf(statusid);
								    	String sta="MSFD";
								    	String desc=status.getDescription();
						    		String cid=Encry.encrypt(id, secret);
						    		applicantService.updatecandidateencryptedid(sid,sta,desc,cid,id);
							    			
						    	return new ServiceResponse<>(new GeneralMessage<>("Updated Successfully", true, 201), HttpStatus.CREATED);
						    	}
						    	catch(Exception e) {
						    		System.out.println(e.getLocalizedMessage());
						    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
						    	}
						    	}
						    
						    @PutMapping("docsrejected")
						    public ServiceResponse<?> docsrejected( @RequestParam String id) {
						    
						    	try {
						    		 Status status=statusService.fetchstatus("DR");
								    	int statusid=status.getId();
								    	String sid=String.valueOf(statusid);
								    	String sta="DR";
								    	String desc=status.getDescription();
						    		applicantService.updatecandidate(sid,sta,desc,id);
							    			
						    	return new ServiceResponse<>(new GeneralMessage<>("Docs rejected!!", true, 201), HttpStatus.CREATED);
						    	}
						    	catch(Exception e) {
						    		System.out.println(e.getLocalizedMessage());
						    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
						    	}
						    	}
						    
						    @PutMapping("docsapproved")
						    public ServiceResponse<?> docsapproved( @RequestParam String id) {
						    
						    	try {
						    		 Status status=statusService.fetchstatus("DO");
								    	int statusid=status.getId();
								    	String sid=String.valueOf(statusid);
								    	String sta="DO";
								    	String desc=status.getDescription();
						    		applicantService.updatecandidatedocs(sid,sta,desc,id);
						    		String path= applicantservice.getAllCandidatesbyid(id);
						    		File file=new File(path);
						    		deleteDirectory(file); 
									  file.delete();
							    			
						    	return new ServiceResponse<>(new GeneralMessage<>("Docs rejected!!", true, 201), HttpStatus.CREATED);
						    	}
						    	catch(Exception e) {
						    		System.out.println(e.getLocalizedMessage());
						    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
						    	}
						    	}
						    public static void deleteDirectory(File file)  
						    {  
						        
						        for (File subfile : file.listFiles()) {  
						            // if the subfile is a folder, recursively call the deleteDirectory()method  
						            if (subfile.isDirectory()) {    // isDirectory() method is used to check whether subfile is a folder or not  
						                deleteDirectory(subfile);  
						            }  
						            // use delete() method for deleting file and empty folder  
						            subfile.delete();  
						        }  
						    }
						    
						    
						    @PutMapping("offerstatusbymanager")
						    public ServiceResponse<?> offerstatusbymanager( @RequestParam String cid,@RequestParam String result) {
						    System.out.println(cid+"@@"+result);
						    	try {
						    		if(result.equals("1")) {
						    		 Status status=statusService.fetchstatus("OAPC");
								    	int statusid=status.getId();
								    	String sid=String.valueOf(statusid);
								    	String sta="OAPC";
								    	String desc=status.getDescription();
								    	Boolean check=true;
						    		applicantService.updatecandidateofferstatus(sid,sta,desc,cid,check);
						    		
						    		}
						    		if(result.equals("0")) {
						    			 Status status=statusService.fetchstatus("ODM");
									    	int statusid=status.getId();
									    	String sid=String.valueOf(statusid);
									    	String sta="ODM";
									    	String desc=status.getDescription();
									    	Boolean check=true;
							    		applicantService.offerrejectedbymanager(sid,sta,desc,cid,check);
							    		String path= applicantservice.getAllCandidatesbyid(cid);
							    		String keyword="cyfutureLOI";
							    		deleteFilesContainingKeyword(path,keyword);
						    		}
						    		return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
						    	}
						    	catch(Exception e) {
						    		System.out.println(e.getLocalizedMessage());
						    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
						    	}
						    	}
						    
						    public static void deleteFilesContainingKeyword(String path, String keyword) {
						        // Create a File object for the directory
						        File directory = new File(path);

						        // Check if the directory exists and is a directory
						        if (directory.exists() && directory.isDirectory()) {
						            // Get all files in the directory
						            File[] files = directory.listFiles();

						            // Check if the directory is empty
						            if (files != null) {
						                // Iterate over each file
						                for (File file : files) {
						                    // Check if the file name contains the keyword
						                    if (file.isFile() && file.getName().contains(keyword)) {
						                        // Delete the file
						                        if (file.delete()) {
						                            System.out.println("Deleted file: " + file.getName());
						                        } else {
						                            System.out.println("Failed to delete file: " + file.getName());
						                        }
						                    }
						                }
						            } else {
						                System.out.println("The directory is empty or an I/O error occurred.");
						            }
						        } else {
						            System.out.println("The specified path is not a directory or does not exist.");
						        }
						    }
						    
						    @PutMapping("offersent")
						    public ServiceResponse<?> offersent( @RequestParam String id) {
						    
						    	try {
						    		
						    		 Status status=statusService.fetchstatus("OSHR");
								    	int statusid=status.getId();
								    	String sid=String.valueOf(statusid);
								    	String sta="OSHR";
								    	String desc=status.getDescription();
								    	Boolean check=true;
								    	String body="Offer Letter";
								    	String subject="Regarding Offer Letter";
								    	List<ApplicantData> data=applicantservice.getcandidatebymail(id);
								    	 String email="";
								    	String path="";
								    	String name="";
								    	for(ApplicantData res:data) {
								    		email=res.getEmailId();
								    		path=res.getDocpath()+File.separator+res.getOfferlettername();
								    		name=res.getOfferlettername();
								    		
								    	}
								    	final String mail=email;
								    	final String docpath=path;
								    	final String names=name;
						    		applicantService.offersent(sid,sta,desc,id,check);
						    		CompletableFuture.runAsync(() -> {
					                       try {
					                    	   Email.sendoffer(mail, body, subject, docpath, names);
					                               // Your email sending code here
					                       } catch (Exception e) {
					                               e.printStackTrace();
					                       }});

						    		
						    		
						    		return new ServiceResponse<>(new GeneralMessage<>("ok", true, 201), HttpStatus.CREATED);
						    	}
						    	catch(Exception e) {
						    		System.out.println(e.getLocalizedMessage());
						    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
						    	}
						    	}
						    	
						    	@PutMapping("offerstatusbychro")
							    public ServiceResponse<?> offerstatusbychro( @RequestParam String cid,@RequestParam String result) {
							    
							    	try {
							    		if(result.equals("1")) {
							    		 Status status=statusService.fetchstatus("OACH");
									    	int statusid=status.getId();
									    	String sid=String.valueOf(statusid);
									    	String sta="OACH";
									    	String desc=status.getDescription();
									    	Boolean check=true;
							    		applicantService.offeracceptedbychro(sid,sta,desc,cid,check);
							    		String body="Please find the attached LOI.";
								    	String subject="Regarding Letter Of Intent";
								    	List<ApplicantData> data=applicantservice.getcandidatebymail(cid);
								    	 String email="";
								    	String path="";
								    	String name="";
								    	for(ApplicantData res:data) {
								    		email=res.getEmailId();
								    		path=res.getDocpath()+File.separator+res.getLOI();
								    		name=res.getLOI();
								    		
								    	}
								    	final String mail=email;
								    	final String docpath=path;
								    	final String names=name;
						    		CompletableFuture.runAsync(() -> {
					                       try {
					                    	   Email.sendoffer(mail, body, subject, docpath, names);
					                               // Your email sending code here
					                       } catch (Exception e) {
					                               e.printStackTrace();
					                       }});

							    		
							    		}
							    		if(result.equals("0")) {
							    			 Status status=statusService.fetchstatus("ODC");
										    	int statusid=status.getId();
										    	String sid=String.valueOf(statusid);
										    	String sta="ODC";
										    	String desc=status.getDescription();
										    	Boolean check=true;
								    		applicantService.offerrejectedbychro(sid,sta,desc,cid,check);
								    			
							    		}
							    		return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
							    	}
							    	catch(Exception e) {
							    		System.out.println(e.getLocalizedMessage());
							    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
							    	}
							    	}
						    	
						    	@PutMapping("loistatusbycandidate")
							    public ServiceResponse<?> loistatusbycandidate( @RequestParam String cid,@RequestParam String result,@RequestParam String reason) {
							    
							    	try {
							    		if(result.equals("1")) {
							    		 Status status=statusService.fetchstatus("LACC");
									    	int statusid=status.getId();
									    	String sid=String.valueOf(statusid);
									    	String sta="LACC";
									    	String desc=status.getDescription();
									    	Boolean check=true;
							    		applicantService.loiacceptedbycandidate(sid,sta,desc,cid,check,reason);
							    								    		
							    		}
							    		if(result.equals("0")) {
							    			 Status status=statusService.fetchstatus("LDC");
										    	int statusid=status.getId();
										    	String sid=String.valueOf(statusid);
										    	String sta="ODC";
										    	String desc=status.getDescription();
										    	Boolean check=true;
								    		applicantService.loirejectedbycandidate(sid,sta,desc,cid,check,reason);
								    			
							    		}
							    		return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
							    	}
							    	catch(Exception e) {
							    		System.out.println(e.getLocalizedMessage());
							    		return new ServiceResponse<>(new GeneralMessage<>("Error", false, 401), HttpStatus.BAD_REQUEST);
							    	}
							    	}
						    
						    @GetMapping("getofferdata")
			          	    public List<ApplicantData> getofferdata(){
			          	    	return applicantservice.getAllOffers();
			          	    			
			                  }
						    
						    @GetMapping("getholdcandidatesdata")
			          	    public List<ApplicantDTO> getholdcandidatesdata(@RequestParam String id){
			          	    	List<ApplicantDTO> candidate=new ArrayList<>();
			          	    	 List<Object[]> list=applicantservice.getholdcandidatesdata(id);
			          	    	StringBuilder sb=new StringBuilder();
			          	    	for(Object[] data:list) {
			          	    		ApplicantDTO dto=new ApplicantDTO();
			          	    		dto.setCandidateid((String)data[0]);
			          	    		dto.setInterviewid((int)data[1]);
			          	    		dto.setJobid((String)data[2]);
			          	    		dto.setStatus((String)data[3]);
			          	    		dto.setDesc((String)data[4]);;
			          	    		candidate.add(dto);
			          	    		System.out.println(dto);
			          	    	}
			          	    	System.out.println(sb.toString());
			          	    	return candidate;
			          	    			
			                  }
						    
						    @GetMapping("getoffertoreleasedata")
			          	    public List<ApplicantData> getoffertoreleasedata(){
						    	System.out.println("@@"+applicantservice.getAllOfferstobereleased());
			          	    	return applicantservice.getAllOfferstobereleased();
			          	    			
			                  }
					
}