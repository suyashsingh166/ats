package com.ats.ATS.Controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ats.ATS.Response.GeneralMessage;
import com.ats.ATS.Response.ServiceResponse;
import com.ats.ATS.Service.ApplicantService;
import com.ats.ATS.Service.InterviewService;
import com.ats.ATS.Service.StatusService;
import com.ats.ATS.model.Interview;
import com.ats.ATS.model.Status;
import com.ats.ATS.model.User;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/interview")
public class InterviewController {
	
	@Autowired
	InterviewService interviewService;
	
	@Autowired
    private StatusService statusService;
	
	@Autowired
    ApplicantService applicantService;
	
	 @PostMapping("/interviewone")
		public ServiceResponse<?> interviewone(@RequestBody Interview interview) {
		 String cid=interview.getCandidateid();
		 Interview check=interviewService.checkcandidate(cid);
		 Boolean intervewone=true;
		 if(check!=null) {
			 return new ServiceResponse<>(new GeneralMessage<>("Already Scheduled", false, 400),
						HttpStatus.BAD_REQUEST);
		 }
		 interview.setIscandidatescreened(true);
		 interview.setIsinterview1scheduled(true);
		 interview.setIsinterview2scheduled(false);
		 interview.setIsinterview1cleared(false);
		 interview.setIsinterview1over(false);
		 interview.setChroapproved(false);
		 interview.setChrorejected(false);
		 interview.setIschroroundscheduled(false);
		 interview.setChroroundcleared(false);
		 interview.setChroroundover(false);
		 interview.setStatus("");
			try {
				interviewService.saveinterviewonedata(interview);
				applicantService.updateinterviewone(intervewone,cid);
				return new ServiceResponse<>(new GeneralMessage<>("Interview Scheduled", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
    
    @PostMapping("/updateinterviewone")
	public ServiceResponse<?> updateinterviewone(@RequestBody Interview interview) {
	String time=interview.getInterview1time();
	String date=interview.getInterview1date();
	String url=interview.getInterview1url();
	String panelist=interview.getInterview1panelist();
	String cid=interview.getCandidateid();
			try {
				interviewService.updateinterviewonedata(time,date,url,panelist,cid);
		return new ServiceResponse<>(new GeneralMessage<>("Interview Rescheduled", true, 201), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
					HttpStatus.BAD_REQUEST);
		}
	
	}
    
    @PostMapping("/updateinterviewtwo")
	public ServiceResponse<?> updateinterviewtwo(@RequestBody Interview interview) {
	String time=interview.getInterview2time();
	String date=interview.getInterview2date();
	String url=interview.getInterview2url();
	String panelist=interview.getInterview2panelist();
	String cid=interview.getCandidateid();
			try {
				interviewService.updateinterviewtwodata(time,date,url,panelist,cid);
		return new ServiceResponse<>(new GeneralMessage<>("Interview Rescheduled", true, 201), HttpStatus.CREATED);
		}
		catch(Exception e) {
			return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
					HttpStatus.BAD_REQUEST);
		}
	
	}
    
    @PostMapping("/updateinterviewthree")
   	public ServiceResponse<?> updateinterviewthree(@RequestBody Interview interview) {
   	String time=interview.getInterview3time();
   	String date=interview.getInterview3date();
   	String url=interview.getInterview3url();
   	String panelist=interview.getInterview3panelist();
   	String cid=interview.getCandidateid();
   			try {
   				interviewService.updateinterviewthreedata(time,date,url,panelist,cid);
   		return new ServiceResponse<>(new GeneralMessage<>("Interview Rescheduled", true, 201), HttpStatus.CREATED);
   		}
   		catch(Exception e) {
   			return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
   					HttpStatus.BAD_REQUEST);
   		}
   	
   	}
    
    @PostMapping("/updateinterviewfour")
   	public ServiceResponse<?> updateinterviewfour(@RequestBody Interview interview) {
   	String time=interview.getInterview4time();
   	String date=interview.getInterview4date();
   	String url=interview.getInterview4url();
   	String panelist=interview.getInterview4panelist();
   	String cid=interview.getCandidateid();
   			try {
   				interviewService.updateinterviewfourdata(time,date,url,panelist,cid);
   		return new ServiceResponse<>(new GeneralMessage<>("Interview Rescheduled", true, 201), HttpStatus.CREATED);
   		}
   		catch(Exception e) {
   			return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
   					HttpStatus.BAD_REQUEST);
   		}
   	
   	}
    
    @PostMapping("/updateinterviewfive")
   	public ServiceResponse<?> updateinterviewfive(@RequestBody Interview interview) {
   	String time=interview.getInterview5time();
   	String date=interview.getInterview5date();
   	String url=interview.getInterview5url();
   	String panelist=interview.getInterview5panelist();
   	String cid=interview.getCandidateid();
   			try {
   				interviewService.updateinterviewfivedata(time,date,url,panelist,cid);
   		return new ServiceResponse<>(new GeneralMessage<>("Interview Rescheduled", true, 201), HttpStatus.CREATED);
   		}
   		catch(Exception e) {
   			return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
   					HttpStatus.BAD_REQUEST);
   		}
   	
   	}
	 
	 @PostMapping("/interviewtwo")
		public ServiceResponse<?> interviewtwo(@RequestBody Interview interview) {
		 String cid=interview.getCandidateid();
		 int id=interview.getId();
		 String panelist=interview.getInterview2panelist();
		 String date=interview.getInterview2date();
		 String time=interview.getInterview2time();
		 String url=interview.getInterview2url();
		 String remarks=interview.getInterview2remarks();
		 Interview check=interviewService.checkcandidateroundtwo(cid);
		 if(check!=null) {
			 return new ServiceResponse<>(new GeneralMessage<>("Already Scheduled", false, 400),
						HttpStatus.BAD_REQUEST);
		 }
		 interview.setIsinterview2scheduled(true);
		 interview.setIsinterview2cleared(false);
		 interview.setIsinterview2over(false);
		 interview.setIsinterview3scheduled(false);
		 interview.setStatus("");
			try {
				interviewService.saveinterviewtwodata(id,panelist,date,time,url,remarks);
			return new ServiceResponse<>(new GeneralMessage<>("Interview Scheduled", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewthree")
		public ServiceResponse<?> interviewthree(@RequestBody Interview interview) {
		 String cid=interview.getCandidateid();
		 int id=interview.getId();
		 String panelist=interview.getInterview3panelist();
		 String date=interview.getInterview3date();
		 String time=interview.getInterview3time();
		 String url=interview.getInterview3url();
		 String remarks=interview.getInterview3remarks();
		 Interview check=interviewService.checkcandidateroundthree(cid);
		 if(check!=null) {
			 return new ServiceResponse<>(new GeneralMessage<>("Already Scheduled", false, 400),
						HttpStatus.BAD_REQUEST);
		 }
		 interview.setIsinterview3scheduled(true);
		 interview.setIsinterview3cleared(false);
		 interview.setIsinterview3over(false);
		 interview.setIsinterview4scheduled(false);
		 interview.setStatus("");
			try {
				interviewService.saveinterviewthreedata(id,panelist,date,time,url,remarks);
			return new ServiceResponse<>(new GeneralMessage<>("Interview Scheduled", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
		
		@PostMapping("/interviewchro")
		public ServiceResponse<?> interviewchro(@RequestBody Interview interview) {
			System.out.println(interview.toString());
		 String cid=interview.getCandidateid();
		 int id=interview.getId();
		 String panelist=interview.getChroroundpanelist();
		 String date=interview.getChrorounddate();
		 String time=interview.getChroroundtime();
		 String url=interview.getChroroundurl();
		 String remarks="";
		 Interview check=interviewService.checkcandidateroundchro(cid);
		 if(check!=null) {
			 return new ServiceResponse<>(new GeneralMessage<>("Already Scheduled", false, 400),
						HttpStatus.BAD_REQUEST);
		 }
		 interview.setIschroroundscheduled(true);
		 interview.setChroroundcleared(false);
		 interview.setChroroundover(false);
		 interview.setStatus("");
			try {
				interviewService.saveinterviewchrodata(id,panelist,date,time,url,remarks);
			return new ServiceResponse<>(new GeneralMessage<>("Interview Scheduled", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewfour")
		public ServiceResponse<?> interviewfour(@RequestBody Interview interview) {
		 String cid=interview.getCandidateid();
		 int id=interview.getId();
		 String panelist=interview.getInterview4panelist();
		 String date=interview.getInterview4date();
		 String time=interview.getInterview4time();
		 String url=interview.getInterview4url();
		 String remarks=interview.getInterview4remarks();
		 Interview check=interviewService.checkcandidateroundfour(cid);
		 if(check!=null) {
			 return new ServiceResponse<>(new GeneralMessage<>("Already Scheduled", false, 400),
						HttpStatus.BAD_REQUEST);
		 }
		 interview.setIsinterview4scheduled(true);
		 interview.setIsinterview4cleared(false);
		 interview.setIsinterview4over(false);
		 interview.setIsinterview5scheduled(false);
		 interview.setStatus("");
			try {
				interviewService.saveinterviewfourdata(id,panelist,date,time,url,remarks);
			return new ServiceResponse<>(new GeneralMessage<>("Interview Scheduled", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewfive")
		public ServiceResponse<?> interviewfive(@RequestBody Interview interview) {
		 String cid=interview.getCandidateid();
		 int id=interview.getId();
		 String panelist=interview.getInterview5panelist();
		 String date=interview.getInterview5date();
		 String time=interview.getInterview5time();
		 String url=interview.getInterview5url();
		 String remarks=interview.getInterview5remarks();
		 Interview check=interviewService.checkcandidateroundfive(cid);
		 if(check!=null) {
			 return new ServiceResponse<>(new GeneralMessage<>("Already Scheduled", false, 400),
						HttpStatus.BAD_REQUEST);
		 }
		 interview.setIsinterview5scheduled(true);
		 interview.setIsinterview5cleared(false);
		 interview.setIsinterview5over(false);
		 interview.setStatus("");
			try {
				interviewService.saveinterviewfivedata(id,panelist,date,time,url,remarks);
			return new ServiceResponse<>(new GeneralMessage<>("Interview Scheduled", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @GetMapping("getAllPendingInterviewsround1")
	    public List<Interview> getAllPendingInterviewsround1(@RequestParam String mail){
		 System.out.println("!!!"+interviewService.getpendinginterviews(mail));
	    	return interviewService.getpendinginterviews(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsbychro")
	    public List<Interview> getAllPendingInterviewsbychro(@RequestParam String mail){
		 
	    	return interviewService.getpendinginterviewsbychro(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsround2")
	    public List<Interview> getAllPendingInterviewsround2(@RequestParam String mail){
	    	return interviewService.getpendinginterviewsround2(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsround3")
	    public List<Interview> getAllPendingInterviewsround3(@RequestParam String mail){
	    	return interviewService.getpendinginterviewsround3(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsround4")
	    public List<Interview> getAllPendingInterviewsround4(@RequestParam String mail){
	    	return interviewService.getpendinginterviewsround4(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsround5")
	    public List<Interview> getAllPendingInterviewsround5(@RequestParam String mail){
	    	return interviewService.getpendinginterviewsround5(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsbyrecruiter")                                   
	    public List<Interview> getAllPendingInterviewsbyrecruiter(@RequestParam String mail){
	    	return interviewService.getpendinginterviewsbyrecruiter(mail);
	    }
	 
	 @GetMapping("getAllPendingInterviewsbycandidateid")                                   
	    public Interview getAllPendingInterviewsbycandidateid(@RequestParam String id){
		 System.out.println(interviewService.checkcandidate(id)+"id"+id);
		return  interviewService.checkcandidate(id);
	    }
	    
	    @GetMapping("getAllinterviewdata")                                   
	    public Interview getAllinterviewdata(@RequestParam String id){
		return  interviewService.getAllinterviewdata(id);
	    }

	 @PostMapping("/interviewoneresult")
		public ServiceResponse<?> interviewoneresult(@RequestParam String cid,@RequestParam String interviewid,@RequestParam String remarks,@RequestParam String result) {
		Boolean isinterviewoneover=true;
		try {
		if(result.equals("0")) {
			Status status=statusService.fetchstatus("CR1");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CR1";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewoneresult(sid,sta,desc,interviewid,remarks,checks,isinterviewoneover);
		}
		if(result.equals("1")) {
			Status status=statusService.fetchstatus("CCR1");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CCR1";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,checks);
			interviewService.updateinterviewoneresult(sid,sta,desc,interviewid,remarks,check,isinterviewoneover);
		}
		if(result.equals("2")) {
			Status status=statusService.fetchstatus("HOLD1");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="HOLD1";
	    	String desc=status.getDescription();
			Boolean check=false;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewoneresult(sid,sta,desc,interviewid,remarks,checks,checks);
		}
			return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 @PostMapping("/interviewtworesult")
		public ServiceResponse<?> interviewtworesult(@RequestParam String cid,@RequestParam String interviewid,@RequestParam String remarks,@RequestParam String result) {
		Boolean isinterviewtwoover=true;
		try {
		if(result.equals("0")) {
			Status status=statusService.fetchstatus("CR2");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CR2";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewtworesult(sid,sta,desc,interviewid,remarks,checks,isinterviewtwoover);
		}
		if(result.equals("1")) {
			Status status=statusService.fetchstatus("CCR2");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CCR2";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,checks);
			interviewService.updateinterviewtworesult(sid,sta,desc,interviewid,remarks,check,isinterviewtwoover);
		}
		if(result.equals("2")) {
			Status status=statusService.fetchstatus("HOLD2");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="HOLD2";
	    	String desc=status.getDescription();
			Boolean check=false;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewtworesult(sid,sta,desc,interviewid,remarks,checks,checks);
						
		}
			return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewchroresult")
		public ServiceResponse<?> interviewchroresult(@RequestParam String cid,@RequestParam String interviewid,@RequestParam String remarks,@RequestParam String result) {
		Boolean chroroundover=true;
		try {
		if(result.equals("0")) {
			Status status=statusService.fetchstatus("CRCR");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CRCR";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewchroresult(sid,sta,desc,interviewid,remarks,checks,chroroundover);
		}
		if(result.equals("1")) {
			Status status=statusService.fetchstatus("CCCR");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CCCR";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,checks);
			interviewService.updateinterviewchroresult(sid,sta,desc,interviewid,remarks,check,chroroundover);
		}
		/*
		 * if(result.equals("2")) { Status status=statusService.fetchstatus("HOLD2");
		 * int statusid=status.getId(); String sid=String.valueOf(statusid); String
		 * sta="HOLD2"; String desc=status.getDescription(); Boolean check=false;
		 * Boolean checks=false;
		 * applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
		 * interviewService.updateinterviewchroresult(sid,sta,desc,interviewid,remarks,
		 * checks,checks);
		 * 
		 * }
		 */
			return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewthreeresult")
		public ServiceResponse<?> interviewthreeresult(@RequestParam String cid,@RequestParam String interviewid,@RequestParam String remarks,@RequestParam String result) {
		Boolean isinterviewthreeover=true;
		try {
		if(result.equals("0")) {
			System.out.println("hi");
			Status status=statusService.fetchstatus("CR3");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CR3";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewthreeresult(sid,sta,desc,interviewid,remarks,checks,isinterviewthreeover);
		}
		if(result.equals("1")) {
			Status status=statusService.fetchstatus("CCR3");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CCR3";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,checks);
			interviewService.updateinterviewthreeresult(sid,sta,desc,interviewid,remarks,check,isinterviewthreeover);
		}
		if(result.equals("2")) {
			Status status=statusService.fetchstatus("HOLD3");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="HOLD3";
	    	String desc=status.getDescription();
			Boolean check=false;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewthreeresult(sid,sta,desc,interviewid,remarks,checks,checks);
		}
			return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewfourresult")
		public ServiceResponse<?> interviewfourresult(@RequestParam String cid,@RequestParam String interviewid,@RequestParam String remarks,@RequestParam String result) {
		Boolean isinterviewthreeover=true;
		try {
		if(result.equals("0")) {
			System.out.println("hi");
			Status status=statusService.fetchstatus("CR4");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CR4";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewfourresult(sid,sta,desc,interviewid,remarks,checks,isinterviewthreeover);
		}
		if(result.equals("1")) {
			Status status=statusService.fetchstatus("CCR4");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CCR4";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,checks);
			interviewService.updateinterviewfourresult(sid,sta,desc,interviewid,remarks,check,isinterviewthreeover);
		}
		if(result.equals("2")) {
			Status status=statusService.fetchstatus("HOLD4");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="HOLD4";
	    	String desc=status.getDescription();
			Boolean check=false;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewfourresult(sid,sta,desc,interviewid,remarks,checks,checks);
		}
			return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
	 
	 @PostMapping("/interviewfiveresult")
		public ServiceResponse<?> interviewfiveresult(@RequestParam String cid,@RequestParam String interviewid,@RequestParam String remarks,@RequestParam String result) {
		Boolean isinterviewthreeover=true;
		try {
		if(result.equals("0")) {
			System.out.println("hi");
			Status status=statusService.fetchstatus("CR5");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CR5";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewfiveresult(sid,sta,desc,interviewid,remarks,checks,isinterviewthreeover);
		}
		if(result.equals("1")) {
			Status status=statusService.fetchstatus("CCR5");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="CCR5";
	    	String desc=status.getDescription();
			Boolean check=true;
			Boolean checks=false;
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,checks);
			interviewService.updateinterviewfiveresult(sid,sta,desc,interviewid,remarks,check,isinterviewthreeover);
		}
		if(result.equals("2")) {
			Status status=statusService.fetchstatus("HOLD5");
	    	int statusid=status.getId();
	    	String sid=String.valueOf(statusid);
	    	String sta="HOLD5";
	    	String desc=status.getDescription();
			Boolean check=false;
			Boolean checks=false; 
			applicantService.applicantrejectedinterviewone(cid,sid,sta,desc,check);
			interviewService.updateinterviewfiveresult(sid,sta,desc,interviewid,remarks,checks,checks);
		}
			return new ServiceResponse<>(new GeneralMessage<>("Ok", true, 201), HttpStatus.CREATED);
			}
			catch(Exception e) {
				return new ServiceResponse<>(new GeneralMessage<>("Error", false, 400),
						HttpStatus.BAD_REQUEST);
			}
		
		}
}
