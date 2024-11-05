package com.ats.ATS.Service;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.aspectj.weaver.bcel.Utility;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.ats.ATS.Repository.ApplicantRepo;
import com.ats.ATS.Response.ServiceResponse;
import com.ats.ATS.model.ApplicantData;

@Service
public class ApplicantServiceImpl implements ApplicantService{
	

	@Autowired
	ApplicantRepo applicantrepo;

	@Override
	public void saveapplicant(ApplicantData data) {
    
		applicantrepo.save(data);
		
	}

	

	@Override
	public ApplicantData getCandidateByMail(String mail) {
		// TODO Auto-generated method stub
		return applicantrepo.findbyMail(mail);
	}



	@Override
	public List<ApplicantData> getAllCandidates(String jobid) {
		// TODO Auto-generated method stub
		return applicantrepo.findbyjobid(jobid);
	}



	@Override
	public void acceptedApplicant(String remarks, String id,Integer statusid,String status,String desc,String panel,Boolean isinterviewonescheduled) {
		// TODO Auto-generated method stub
		applicantrepo.acceptedApplicant(remarks, id,statusid,status,desc,panel,isinterviewonescheduled);
	}



	@Override
	public void rejectedApplicant(String remarks, String id,Integer statusid,String status,String desc) {
		// TODO Auto-generated method stub
		applicantrepo.rejectedApplicant(remarks, id,statusid,status,desc);
	}



	@Override
	public List<ApplicantData> getcandidatebymail(String id) {
		// TODO Auto-generated method stub
		return applicantrepo.fetchcandidatebyid(id);
	}



	@Override
	public void updateinterviewone(Boolean intervewone,String jobid) {
		applicantrepo.updateinterviewone(intervewone,jobid);
		
	}




	@Override
	public void applicantrejectedinterviewone(String cid, String statusid, String status, String desc,Boolean check) {
		applicantrepo.applicantrejectedinterviewone(cid,check,statusid,status,desc);
		
	}



	@Override
	public void applicantrejectedinterviewtwo(String cid, String statusid, String status, String desc,Boolean check) {
		applicantrepo.applicantrejectedinterviewtwo(cid,check,statusid,status,desc);
		
	}



	@Override
	public void updateresult(String sid, String sta, String desc, String cid, Boolean result) {
		applicantrepo.updateresult(sid,sta,desc,cid,result);
		
	}



	@Override
	public List<ApplicantData> getAllselectedCandidates(String jobid) {
		Boolean selected = true;
		return applicantrepo.findselectedcandidatesbyjobid(jobid,selected);
	}



	@Override
	public void savedocpath(String sid, String sta, String desc,String cid, Path candidateDir) {
		String path=candidateDir.toString();
		Boolean check=true;
		applicantrepo.savedocpath(sid,sta,desc,cid,path,check);
	}



	@Override
	public String getAllCandidatesbyid(String candidateId) {
		
		return applicantrepo.fetchpathbyid(candidateId);
	}



	@Override
	public void updatecandidateencryptedid(String sid, String sta, String desc,String cid, String id) {
		Boolean check=true;
		Boolean checks=false;
		applicantrepo.updatecandidateid(sid,sta,desc,cid,id,check,checks);
		
	}



	@Override
	public void updatecandidate(String sid, String sta, String desc,String id) {
		Boolean check=true;
		Boolean checks=false;
		String encrypted="";
		applicantrepo.updatecandidate(sid,sta,desc,id,check,encrypted,checks);
	}



	@Override
	public void updatecandidatedocs(String sid, String sta, String desc, String id) {
		Boolean check=true;
		Boolean checks=false;
		applicantrepo.updatecandidate(sid,sta,desc,id,check,checks);
	}



	@Override
	public void offerreleasedforapproval(String sid, String sta, String desc, String cid,String name) {
		Boolean check=true;
		applicantrepo.updatecandidateoffer(sid,sta,desc,cid,check,name);
		
	}



	@Override
	public void updatecandidateofferstatus(String sid, String sta, String desc, String cid, Boolean check) {
		applicantrepo.updatecandidateofferstatus(sid,sta,desc,cid,check);
	}



	@Override
	public void offerrejectedbymanager(String sid, String sta, String desc, String cid, Boolean check) {
		applicantrepo.offerrejectedbymanager(sid,sta,desc,cid,check);
		
	}



	@Override
	public void offeracceptedbychro(String sid, String sta, String desc, String cid, Boolean check) {
		applicantrepo.offeracceptedbychro(sid,sta,desc,cid,check);
		
	}



	@Override
	public void offerrejectedbychro(String sid, String sta, String desc, String cid, Boolean check) {
		applicantrepo.offerrejectedbychro(sid,sta,desc,cid,check);
		
	}



	@Override
	public List<ApplicantData> getAllOffers() {
		String status="OAPC";
		return applicantrepo.getalloffers(status);
	}



	@Override
	public void offerrereleasedforapproval(String sid, String sta, String desc, String cid, String resumename) {
		Boolean check=false;
		applicantrepo.offerrereleasedforapproval(sid,sta,desc,cid,check,resumename);
		
		
	}



	@Override
	public List<ApplicantData> getAllOfferstobereleased() {
		Boolean check=true;
		return applicantrepo.getAllOfferstobereleased(check);
	} 



	@Override
	public void offersent(String sid, String sta, String desc, String cid, Boolean check) {
		applicantrepo.updateofferdata(sid,sta,desc,cid,check);
		
	}



	@Override
	public List<Object[]> getholdcandidatesdata(String id) {
		// TODO Auto-generated method stub
		return applicantrepo.getholdcandidatesdata(id);
	}



	@Override
	public void offersendtocandidate(String sid, String sta, String desc, String cid, String filename) {
		Boolean check=true;
		applicantrepo.offersenttocanidate(sid,sta,desc,cid,check,filename);
		
	}



	@Override
	public void loiacceptedbycandidate(String sid, String sta, String desc, String cid, Boolean check,String reason) {
		applicantrepo.loiacceptedbycandidate(sid,sta,desc,cid,check,reason);
		
	}



	@Override
	public void loirejectedbycandidate(String sid, String sta, String desc, String cid, Boolean check, String reason) {
		
		applicantrepo.loirejectedbycandidate(sid,sta,desc,cid,check,reason);
	}



	
	

}
