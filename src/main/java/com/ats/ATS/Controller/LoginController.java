package com.ats.ATS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ATS.Repository.UserRepository;
import com.ats.ATS.Response.*;
import com.ats.ATS.Security.JwtHelper;
import com.ats.ATS.Service.ApplicantService;
import com.ats.ATS.Service.DepartmentService;
import com.ats.ATS.Service.StatusService;
import com.ats.ATS.Service.UserService;
import com.ats.ATS.model.ApplicantData;
import com.ats.ATS.model.Department;
import com.ats.ATS.model.JwtResponse;
import com.ats.ATS.model.Roles;
import com.ats.ATS.model.Status;
import com.ats.ATS.model.User;

import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/career")
public class LoginController {
              
              Logger logger = LoggerFactory.getLogger(LoginController.class);
              
                 @Value("${applicant.documents.location}")
                             String visitorDoc;
                 @Value("${upload.path}")
                 private String uploadDir;
                 
                  @Autowired
                  ApplicantService applicantservice;
                  
                  @Autowired
                  UserService userService;
                  
                  @Autowired
                  private StatusService statusService; 
                             
                             
                  @PostMapping("/careers")
                  public String career(@ModelAttribute ApplicantData applicantdata,@RequestParam String jobid, @RequestParam("name") String name,@RequestParam("change") String change,@RequestParam("es") String es,@RequestParam("ps") String ps,@RequestParam("gender") String gender,@RequestParam("source") String source,@RequestParam("experience") String experience,@RequestParam("np") String np,@RequestParam("dob") String dob,@RequestParam("department") String department,@RequestParam("mno") String mobile, @RequestParam("email") String email, @RequestParam("resume") MultipartFile resume)
                          {
                	  Status status=statusService.fetchstatus("CAP");
				    	int statusid=status.getId();
				    	String sta="CAP";
				    	String desc=status.getDescription();
                            Boolean isapproved=false;
                            applicantdata.setStatus(sta);
                            applicantdata.setStatusdesc(desc);
                            applicantdata.setStatusid(statusid);
                            applicantdata.setIs_approved(isapproved);
                            applicantdata.setAredocsapproved(false);
                            applicantdata.setDocsubmitted(false);
                            applicantdata.setIscandidaterejected(false);
                            applicantdata.setExpectedsalary(es);
                            applicantdata.setPresentsalary(ps);
                            applicantdata.setChangereason(change);
                            applicantdata.setIsofferreleased(false);
                	  					   applicantdata.setSource(source);
                                           applicantdata.setJobid(jobid);
                                           applicantdata.setName(name);
                                           applicantdata.setGender(gender);
                                           applicantdata.setEmailId(email);
                                           applicantdata.setExperience(experience);
                                           applicantdata.setNoticePeriod(np);
                                           applicantdata.setDob(dob);
                                           applicantdata.setIsoffersentbyhrops(false);
                                           applicantdata.setDepartment(department);
                                           applicantdata.setMobNo(mobile);
                                          applicantdata.setIs_selected(false);
                                          applicantdata.setOfferreleaseforapproval(false);
                                          applicantdata.setOfferapprovedbymanager(false);
                                          applicantdata.setOfferrejectedbymanager(false);
                                          applicantdata.setOfferapprovedbychro(false);
                                          applicantdata.setOfferrejectedbychro(false);
                                          DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH-mm-ss");  
                                          LocalDateTime now = LocalDateTime.now(); 
                                          String time=dtf.format(now);
                                           String resumename=time+"_"+resume.getOriginalFilename();
                                          
                                           applicantdata.setResumename(resumename);
                                           System.out.println("resumename"+resumename);
                                           
                                            String filePath = visitorDoc; 
                                            //System.out.println("file"+filePath);
                                            
                                                                
												/*
												 * File directoryPath = new File(filePath); if (!directoryPath.exists())
												 * { directoryPath.mkdir(); } File resumefile=new
												 * File(directoryPath,resumename);
												 */
                                                                
                                                                 try {
                                                                	 applicantservice.saveapplicant(applicantdata);
                                                                       Path path=Paths.get(filePath);    
                                                                       if (resume != null && !resume.isEmpty()) {
                                                                           saveFile(resume, time,path);
                                                                       }
																		/* resume.transferTo(resumefile); */return "Ok";
                                                                 }
                                                                 catch(Exception e) {
                                                                	 return "Error";
                                                                              
                                                                 }
                                          
                             
                            
                 
                  }
                 
                  
                  @GetMapping("getcareerdata")
          	    public List<ApplicantData> getUser(@RequestParam String jobid){
          	    	return applicantservice.getAllCandidates(jobid);
          	    			
                  }
                  
                  
                  @GetMapping("getcareerdatabyid")
            	    public List<ApplicantData> getdatabymail(@RequestParam String id){
            	    	return applicantservice.getcandidatebymail(id);
            	    			
                    }
                  
                  @GetMapping("getselectedcandidate")
            	    public List<ApplicantData> getselectedcandidate(@RequestParam String jobid){
                	  System.out.println("jobid"+jobid+"w11"+applicantservice.getAllselectedCandidates(jobid));
            	    	return applicantservice.getAllselectedCandidates(jobid);
            	    			
                    }
                  
                  @GetMapping("test") 
          	    public List<User> test(){
          	    	return userService.getUsers();
          	    			
                  }
                  
                  @PostMapping("/submit")
          	    public ResponseEntity<String> handleFileUpload(MultipartHttpServletRequest request,
										          	    	   @RequestParam("cid") String cid,
										          	    	  @RequestParam("encryptedid") String encryptedid,
										          	    	   @RequestParam("name") String name,
          	                                                   @RequestParam("10thMarksheet") MultipartFile marksheet10,
          	                                                   @RequestParam("12thMarksheet") MultipartFile marksheet12,
          	                                                   @RequestParam("graduationMarksheet") MultipartFile graduationMarksheet,
          	                                                   @RequestParam("aadharCard") MultipartFile aadharCard,
          	                                                   @RequestParam("panCard") MultipartFile panCard,
          	                                                   @RequestParam("bankDocuments") MultipartFile bankDocuments,
          	                                                   @RequestParam("cancelledCheque") MultipartFile cancelledCheque,
          	                                                   @RequestParam(value = "salarySlip", required = false) MultipartFile salarySlip,
          	                                                   @RequestParam(value = "resignationMail", required = false) MultipartFile resignationMail,
          	                                                   @RequestParam(value = "offerLetter", required = false) List<MultipartFile> offerLetters,
          	                                                   @RequestParam(value = "promotionalLetter", required = false) MultipartFile promotionalLetter) {

          	        try {
          	        	System.out.println("cid"+cid);
          	        	String candidateDirName = cid + "_" + name;
          	          Path candidateDir = Paths.get(uploadDir, candidateDirName);
          	        Files.createDirectories(candidateDir);
          	   
                      saveFile(marksheet10, "10thMarksheet",candidateDir);
                      saveFile(marksheet12, "12thMarksheet",candidateDir);
                      saveFile(graduationMarksheet, "graduationMarksheet",candidateDir);
                      saveFile(aadharCard, "aadharCard",candidateDir);
                      saveFile(panCard, "panCard",candidateDir);
                      saveFile(bankDocuments, "bankDocuments",candidateDir);
                      saveFile(cancelledCheque, "cancelledCheque",candidateDir);

                      if (salarySlip != null && !salarySlip.isEmpty()) {
                          saveFile(salarySlip, "salarySlip",candidateDir);
                      }
                      if (resignationMail != null && !resignationMail.isEmpty()) {
                          saveFile(resignationMail, "resignationMail",candidateDir);
                      }
                      if (offerLetters != null && !offerLetters.isEmpty()) {
                          for (MultipartFile offerLetter : offerLetters) {
                              saveFile(offerLetter, "offerLetter",candidateDir);
                          }
                      }
                      if (promotionalLetter != null && !promotionalLetter.isEmpty()) {
                          saveFile(promotionalLetter, "promotionalLetter",candidateDir);
                      }
                      Status status=statusService.fetchstatus("DUOP");
				    	int statusid=status.getId();
				    	String sid=String.valueOf(statusid);
				    	String sta="DUOP";
				    	String desc=status.getDescription();
                      applicantservice.savedocpath(sid,sta,desc,cid,candidateDir);
                      return ResponseEntity.status(HttpStatus.OK).body("Files uploaded successfully!");

                  } catch (IOException e) {
                      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files");
                  }
              }

              private void saveFile(MultipartFile file, String fileName,Path candidateDir) throws IOException {
                 
            	  try{if (file != null && !file.isEmpty()) {
                      byte[] bytes = file.getBytes();
                      Path path = Paths.get(candidateDir + File.separator + fileName+ "_" + file.getOriginalFilename());
                      Files.write(path, bytes);
                  }
            	  }
            	  catch(Exception e) {
            		  System.out.println(e.getLocalizedMessage());
            	  }
                  
                  }
              
              @PostMapping("/loi")
        	    public ResponseEntity<String> loi(MultipartHttpServletRequest request,
										          	    	   @RequestParam("cid") String cid,
										          	    	 @RequestParam("re") String re,
										          	    	 @RequestParam("name") String name,
        	                                                   @RequestParam("offerletter") MultipartFile offerletter)
        	                                                  {
            	  try {
        	        	System.out.println("cid"+cid);
        	        	String candidateDirName = cid + "_" + name;
        	          Path candidateDir = Paths.get(uploadDir, candidateDirName);
        	        Files.createDirectories(candidateDir);
        	        Date currentDate = new Date(); 
        	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
        	        String currentDateTime = dateFormat.format(currentDate);
                    String resumename="cyfutureLOI"+currentDateTime;
                   // System.out.println("resumename"+resumename);
                    if (offerletter != null && !offerletter.isEmpty()) {
                        saveFile(offerletter, resumename,candidateDir);
                    }
                    String filena=resumename+"_"+offerletter.getOriginalFilename();
                
                    Status status=statusService.fetchstatus("OPRM");
				    	int statusid=status.getId(); 
				    	String sid=String.valueOf(statusid);
				    	String sta="OPRM";
				    	String desc=status.getDescription();
				    	if(re.equals("0")) {
                    applicantservice.offerreleasedforapproval(sid,sta,desc,cid,filena);
				    	}
				    	if(re.equals("1")) {
				    		 applicantservice.offerrereleasedforapproval(sid,sta,desc,cid,filena);
				    	}
                    return ResponseEntity.status(HttpStatus.OK).body("Files uploaded successfully!");

                } catch (IOException e) {
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files");
                } 
              }
              
              @PostMapping("/offerletter")
      	    public ResponseEntity<String> offerletter(MultipartHttpServletRequest request,
										          	    	   @RequestParam("cid") String cid,
										          	    	 @RequestParam("name") String name,
      	                                                   @RequestParam("offerletter") MultipartFile offerletter)
      	                                                  {
          	  try {
      	        	System.out.println("cid"+cid);
      	        	String candidateDirName = cid + "_" + name;
      	          Path candidateDir = Paths.get(uploadDir, candidateDirName);
      	        Files.createDirectories(candidateDir);
      	        Date currentDate = new Date(); 
      	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss"); 
      	        String currentDateTime = dateFormat.format(currentDate);
                  String resumename="cyfutureofferletter"+currentDateTime;
                  if (offerletter != null && !offerletter.isEmpty()) {
                      saveFile(offerletter, resumename,candidateDir);
                  }
                  String filena=resumename+"_"+offerletter.getOriginalFilename();
              
                  Status status=statusService.fetchstatus("OSTC");
				    	int statusid=status.getId(); 
				    	String sid=String.valueOf(statusid);
				    	String sta="OSTC";
				    	String desc=status.getDescription();
                  applicantservice.offersendtocandidate(sid,sta,desc,cid,filena);
				    	
                  String body="Offer Letter";
			    	String subject="Regarding Offer Letter";
			    	List<ApplicantData> data=applicantservice.getcandidatebymail(cid);
			    	 String email="";
			    	String path="";
			    	String names="";
			    	for(ApplicantData res:data) {
			    		email=res.getEmailId();
			    		path=res.getDocpath()+File.separator+res.getOfferlettername();
			    		names=res.getOfferlettername();
			    		
			    	}
			    	final String mail=email;
			    	final String docpath=path;
			    	final String namess=names;
	    		CompletableFuture.runAsync(() -> {
                     try {
                  	   Email.sendoffer(mail, body, subject, docpath, namess);
                             // Your email sending code here
                     } catch (Exception e) {
                             e.printStackTrace();
                     }});

	    		
	    		
                  return ResponseEntity.status(HttpStatus.OK).body("Files uploaded successfully!");

              } catch (IOException e) {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload files");
              } 
            }
            
}
                            


