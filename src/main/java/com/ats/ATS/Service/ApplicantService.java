package com.ats.ATS.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.ApplicantData;

@Service
public interface ApplicantService {
	
	public void saveapplicant(ApplicantData data);
 public List<ApplicantData> getAllCandidates(String jobid);
 public ApplicantData getCandidateByMail(String mail);
public void acceptedApplicant(String remarks, String id,Integer statusid,String status,String desc,String panel,Boolean isinterviewonescheduled);
public void rejectedApplicant(String remarks, String id,Integer statusid,String status,String desc);
public List<ApplicantData> getcandidatebymail(String id);
public void updateinterviewone(Boolean intervewone, String jobid);
public void applicantrejectedinterviewone(String cid,String statusid,String status,String desc,Boolean check);
public void applicantrejectedinterviewtwo(String cid, String sid, String sta, String desc, Boolean check);
public void updateresult(String sid, String sta, String desc, String cid, Boolean result);
public List<ApplicantData> getAllselectedCandidates(String jobid);
public void savedocpath(String cid, String sta, String desc, String cid2, Path candidateDir);
public String getAllCandidatesbyid(String candidateId);
public void updatecandidateencryptedid(String sid, String sta, String desc,String cid, String id);
public void updatecandidate(String sid, String sta, String desc,String id);
public void updatecandidatedocs(String sid, String sta, String desc, String id);
public void offerreleasedforapproval(String sid, String sta, String desc, String cid, String resumename);
public void updatecandidateofferstatus(String sid, String sta, String desc, String cid, Boolean check);
public void offerrejectedbymanager(String sid, String sta, String desc, String cid, Boolean check);
public void offeracceptedbychro(String sid, String sta, String desc, String cid, Boolean check);
public void offerrejectedbychro(String sid, String sta, String desc, String cid, Boolean check);
public List<ApplicantData> getAllOffers();
public void offerrereleasedforapproval(String sid, String sta, String desc, String cid, String resumename);
public List<ApplicantData> getAllOfferstobereleased();
public void offersent(String sid, String sta, String desc, String cid, Boolean check);
public List<Object[]> getholdcandidatesdata(String id);
public void offersendtocandidate(String sid, String sta, String desc, String cid, String filena);
public void loiacceptedbycandidate(String sid, String sta, String desc, String cid, Boolean check, String reason);
public void loirejectedbycandidate(String sid, String sta, String desc, String cid, Boolean check, String reason);
}
