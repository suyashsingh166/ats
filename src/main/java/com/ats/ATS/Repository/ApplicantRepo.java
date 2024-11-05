package com.ats.ATS.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.ApplicantData;

import jakarta.transaction.Transactional;

@Repository
public interface ApplicantRepo extends JpaRepository<ApplicantData, Integer>{

	@Query(value = "select * from applicant where email_id = :mail" , nativeQuery = true)
	public ApplicantData findbyMail(String mail);

	@Query(value = "select * from applicant where jobid = :jobid" , nativeQuery = true)
	public List<ApplicantData> findbyjobid(String jobid);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET is_remarks = :remarks,\r\n"
			+ "    is_approved = true, status = :status, statusdesc = :desc, accepteddate =  NOW() , is_interviewonescheduled = :isinterviewonescheduled ,interviewpanel = :panel , statusid = :statusid\r\n"
			+ "WHERE user_id = :id" , nativeQuery = true)
	public void acceptedApplicant(String remarks, String id,Integer statusid,String status,String desc,String panel,Boolean isinterviewonescheduled);

	
	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET is_remarks = :remarks,\r\n"
			+ "    is_approved = false, iscandidaterejected = true,status = :status, statusdesc = :desc, statusid = :statusid\r\n"
			+ "WHERE "
			+ "user_id = :id" , nativeQuery = true)
	public void rejectedApplicant(String remarks, String id,Integer statusid,String status,String desc);

	@Query(value = "select * from applicant where user_id = :id" , nativeQuery = true)
	public List<ApplicantData> fetchcandidatebyid(String id);

	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET \r\n"
			+ "    is_interviewonescheduled = :intervewone \r\n"
			+ "WHERE "
			+ "user_id = :cid" , nativeQuery = true)
	public void updateinterviewone(Boolean intervewone,String cid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET iscandidaterejected = :check , statusid = :statusid , statusdesc = :desc, status = :status \r\n"
			+ "WHERE user_id = :cid" , nativeQuery = true)
	public void applicantrejectedinterviewone(String cid, Boolean check,String statusid,String status,String desc);

	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET iscandidaterejected = :check , statusid = :statusid , statusdesc = :desc, status = :status \r\n"
			+ "WHERE user_id = :cid" , nativeQuery = true)
	public void applicantrejectedinterviewtwo(String cid, Boolean check, String statusid, String status, String desc);

	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET is_selected = :result , statusid = :sid , statusdesc = :desc, status = :sta \r\n"
			+ "WHERE user_id = :cid" , nativeQuery = true)
	public void updateresult(String sid, String sta, String desc, String cid, Boolean result);

	@Query(value = "select * from applicant where jobid = :jobid and is_selected = :selected" , nativeQuery = true)
	public List<ApplicantData> findselectedcandidatesbyjobid(String jobid,Boolean selected);

	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid, status = :sta, statusdesc = :desc, docpath = :path , docsubmitted = :check WHERE user_id = :cid" , nativeQuery = true)
	public void savedocpath(String sid, String sta, String desc, String cid, String path, Boolean check);

	@Query(value = "select docpath from applicant where user_id = :candidateId" , nativeQuery = true)
	public String fetchpathbyid(String candidateId);

	@Transactional
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc ,encryptedid = :cid , aredocsrejected = :checks,isemailsent = :check WHERE user_id = :id" , nativeQuery = true)
	public void updatecandidateid(String sid, String sta, String desc, String cid, String id, Boolean check, Boolean checks);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , encryptedid = :encrypted , aredocsrejected = :check , aredocsapproved = :checks,docsubmitted = :checks ,isemailsent = :checks WHERE user_id = :id" , nativeQuery = true)
	public void updatecandidate(String sid, String sta, String desc, String id, Boolean check, String encrypted,Boolean checks);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , aredocsrejected = :checks ,aredocsapproved = :check WHERE user_id = :id" , nativeQuery = true)
	public void updatecandidate(String sid, String sta, String desc, String id, Boolean check,Boolean checks);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , offerreleaseforapproval = :check , loi = :name WHERE user_id = :cid" , nativeQuery = true)
		public void updatecandidateoffer(String sid, String sta, String desc, String cid, Boolean check,String name);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , offerapprovedbymanager = :check WHERE user_id = :cid" , nativeQuery = true)
	public void updatecandidateofferstatus(String sid, String sta, String desc, String cid, Boolean check);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , offerrejectedbymanager = :check WHERE user_id = :cid" , nativeQuery = true)
	public void offerrejectedbymanager(String sid, String sta, String desc, String cid, Boolean check);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , offerapprovedbychro = :check WHERE user_id = :cid" , nativeQuery = true)
	public void offeracceptedbychro(String sid, String sta, String desc, String cid, Boolean check);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , offerrejectedbychro = :check WHERE user_id = :cid" , nativeQuery = true)
	public void offerrejectedbychro(String sid, String sta, String desc, String cid, Boolean check);

	@Query(value = "select * from applicant where status = :status" , nativeQuery = true)
	public List<ApplicantData> getalloffers(String status);

	@Transactional 
	@Modifying 
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , loi = :resumename , offerrejectedbymanager = :check , offerapprovedbymanager = :check  WHERE user_id = :cid" , nativeQuery = true)
	public void offerrereleasedforapproval(String sid, String sta, String desc, String cid, Boolean check,
			String resumename);

	@Query(value = "select * from applicant where  offerapprovedbychro = :check" , nativeQuery = true)
	public List<ApplicantData> getAllOfferstobereleased( Boolean check);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc ,isoffersentbyhrops = :check  WHERE user_id = :cid" , nativeQuery = true)
	public void updateofferdata(String sid, String sta, String desc, String cid, Boolean check);

	@Query(value = "SELECT ats.interview.candidateid,ats.interview.id,ats.interview.jobid,ats.interview.status,ats.interview.statusdesc,ats.job_creation.requestedby FROM ats.interview join  job_creation on ats.interview.jobid=ats.job_creation.id where ats.interview.status in('HOLD1','HOLD2','HOLD3','HOLD4','HOLD5') and requestedby = :id" , nativeQuery = true)
	public List<Object[]> getholdcandidatesdata(String id);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , isofferreleased = :check , offerlettername = :filename WHERE user_id = :cid" , nativeQuery = true)
	public void offersenttocanidate(String sid, String sta, String desc, String cid, Boolean check, String filename);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , isloiaccepted = :check , loirejectedreason = :reason WHERE user_id = :cid" , nativeQuery = true)
	public void loiacceptedbycandidate(String sid, String sta, String desc, String cid, Boolean check, String reason);

	@Transactional 
	@Modifying
	@Query(value = "UPDATE applicant\r\n"
			+ "SET statusid = :sid , status = :sta , statusdesc = :desc , isloirejected = :check, loirejectedreason = :reason WHERE user_id = :cid" , nativeQuery = true)
	public void loirejectedbycandidate(String sid, String sta, String desc, String cid, Boolean check, String reason);

	

}
