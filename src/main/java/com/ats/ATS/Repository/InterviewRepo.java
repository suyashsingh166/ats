package com.ats.ATS.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.Interview;

import jakarta.transaction.Transactional;

@Repository
public interface InterviewRepo extends JpaRepository<Interview, Integer> {
	
	@Query(value = "select * from interview where candidateid = :cid and isinterview1scheduled = :check" , nativeQuery = true)
	Interview checkcandidate(String cid, Boolean check);

	@Query(value = "select * from interview where interview1panelist = :mail and isinterview1over= :isinterviewover and isinterview1scheduled = :isinterview1scheduled and status!= :status" , nativeQuery = true)
	List<Interview> findpendinginterview(String mail, Boolean isinterviewover, Boolean isinterview1scheduled,String status);

	@Query(value = "select * from interview where recruiter = :mail" , nativeQuery = true)
	List<Interview> findpendinginterviewbyrecruiter(String mail);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  isinterview1cleared = :check ,interview1remarks = :remarks, isinterview1over = :isinterviewoneover,statusid = :statusid,statusdesc = :desc,status = :status \r\n"
			+ "WHERE id = :interviewid" , nativeQuery = true) 
	void updateinterviewoneresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean check,Boolean isinterviewoneover);

	@Query(value = "select * from interview where interview2panelist = :mail and isinterview2over= :isinterviewover and isinterview2scheduled = :isinterview2scheduled and status!= :status" , nativeQuery = true)
	List<Interview> findpendinginterviewround2(String mail, Boolean isinterviewover, Boolean isinterview2scheduled, String status);

	@Query(value = "select * from interview where candidateid = :cid and isinterview2scheduled = :check" , nativeQuery = true)
	Interview checkcandidateroundtwo(String cid, Boolean check);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview2panelist = :panelist , interview2date = :date, interview2time = :time, interview2url = :url,interview2remarks = :remarks, isinterview2over = :checks, isinterview2scheduled = :check, isinterview2cleared = :checks \r\n"
			+ "WHERE id = :id" , nativeQuery = true) 
	void updateinterviewtwoschedule(int id, String panelist, String date, String time, String url, String remarks, Boolean check, Boolean checks);

	

	@Query(value = "select * from interview where candidateid = :cid and isinterview3scheduled = :check" , nativeQuery = true)
	Interview checkcandidateroundthree(String cid, Boolean check);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview3panelist = :panelist , interview3date = :date, interview3time = :time, interview3url = :url,interview3remarks = :remarks, isinterview3over = :checks, isinterview3scheduled = :check, isinterview3cleared = :checks \r\n"
			+ "WHERE id = :id" , nativeQuery = true) 
	void updateinterviewthreeschedule(int id, String panelist, String date, String time, String url, String remarks,
			Boolean check, Boolean checks);

	@Query(value = "select * from interview where interview3panelist = :mail and isinterview3over= :isinterviewover and isinterview3scheduled = :isinterview3scheduled and status!= :status" , nativeQuery = true)
	List<Interview> findpendinginterviewround3(String mail, Boolean isinterviewover, Boolean isinterview3scheduled, String status);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  isinterview3cleared = :checks ,interview3remarks = :remarks, isinterview3over = :isinterviewthreeover ,statusid = :statusid,statusdesc = :desc,status = :status\r\n"
			+ "WHERE id = :interviewid" , nativeQuery = true) 
	void updateinterviewthreeresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewthreeover);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  isinterview4cleared = :checks ,interview4remarks = :remarks, isinterview4over = :isinterviewthreeover,statusid = :statusid,statusdesc = :desc,status = :status \r\n"
			+ "WHERE id = :interviewid" , nativeQuery = true) 
	void updateinterviewfourresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewthreeover);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  isinterview5cleared = :checks ,interview5remarks = :remarks, isinterview5over = :isinterviewthreeover ,statusid = :statusid,statusdesc = :desc,status = :status\r\n"
			+ "WHERE id = :interviewid" , nativeQuery = true) 
	void updateinterviewfiveresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewthreeover);

	@Query(value = "select * from interview where candidateid = :cid and isinterview4scheduled = :check" , nativeQuery = true)
	Interview checkcandidateroundfour(String cid, Boolean check);

	@Query(value = "select * from interview where candidateid = :cid and isinterview5scheduled = :check" , nativeQuery = true)
	Interview checkcandidateroundfive(String cid, Boolean check);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview4panelist = :panelist , interview4date = :date, interview4time = :time, interview4url = :url,interview4remarks = :remarks, isinterview4over = :checks, isinterview4scheduled = :check, isinterview4cleared = :checks \r\n"
			+ "WHERE id = :id" , nativeQuery = true) 
	void updateinterviewfourschedule(int id, String panelist, String date, String time, String url, String remarks,
			Boolean check, Boolean checks);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview5panelist = :panelist , interview5date = :date, interview5time = :time, interview5url = :url,interview5remarks = :remarks, isinterview5over = :checks, isinterview5scheduled = :check, isinterview5cleared = :checks \r\n"
			+ "WHERE id = :id" , nativeQuery = true) 
	void updateinterviewfiveschedule(int id, String panelist, String date, String time, String url, String remarks,
			Boolean check, Boolean checks);

	@Query(value = "select * from interview where interview4panelist = :mail and isinterview4over= :isinterviewover and isinterview4scheduled = :isinterview4scheduled and status!= :status" , nativeQuery = true)
	List<Interview> findpendinginterviewround4(String mail, Boolean isinterviewover, Boolean isinterview4scheduled, String status);

	@Query(value = "select * from interview where interview5panelist = :mail and isinterview5over= :isinterviewover and isinterview5scheduled = :isinterview5scheduled and status!= :status" , nativeQuery = true)
	List<Interview> findpendinginterviewround5(String mail, Boolean isinterviewover, Boolean isinterview5scheduled, String status);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview1panelist = :panelist , interview1date = :date, interview1time = :time, interview1url = :url \r\n"
			+ "WHERE candidateid = :cid" , nativeQuery = true) 
	void updateinterviewone(String time, String date, String url, String panelist, String cid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview2panelist = :panelist , interview2date = :date, interview2time = :time, interview2url = :url \r\n"
			+ "WHERE candidateid = :cid" , nativeQuery = true) 
	void updateinterviewtwo(String time, String date, String url, String panelist, String cid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview3panelist = :panelist , interview3date = :date, interview3time = :time, interview3url = :url \r\n"
			+ "WHERE candidateid = :cid" , nativeQuery = true) 
	void updateinterviewthree(String time, String date, String url, String panelist, String cid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview4panelist = :panelist , interview4date = :date, interview4time = :time, interview4url = :url \r\n"
			+ "WHERE candidateid = :cid" , nativeQuery = true) 
	void updateinterviewfour(String time, String date, String url, String panelist, String cid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  interview5panelist = :panelist , interview5date = :date, interview5time = :time, interview5url = :url \r\n"
			+ "WHERE candidateid = :cid" , nativeQuery = true) 
	void updateinterviewfive(String time, String date, String url, String panelist, String cid);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  isinterview2cleared = :checks ,interview2remarks = :remarks, isinterview2over = :isinterviewtwoover ,statusid = :statusid,statusdesc = :desc,status = :status\r\n"
			+ "WHERE id = :interviewid" , nativeQuery = true) 
	void updateinterviewtworesult(String statusid, String status, String desc, String interviewid, String remarks,
			Boolean checks, Boolean isinterviewtwoover);

	@Query(value = "select * from interview where candidateid = :id " , nativeQuery = true)
	Interview getAllinterviewdata(String id);

	@Query(value = "select * from interview where candidateid = :cid and ischroroundscheduled = :check" , nativeQuery = true)
	Interview checkcandidateroundchro(String cid, Boolean check);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  chroroundpanelist = :panelist , chrorounddate = :date, chroroundtime = :time, chroroundurl = :url,chroremarks = :remarks, chroroundover = :checks, ischroroundscheduled = :check, chroroundcleared = :checks \r\n"
			+ "WHERE id = :id" , nativeQuery = true) 
	void updateinterviewchroschedule(int id, String panelist, String date, String time, String url, String remarks,
			Boolean check, Boolean checks);
	@Query(value = "select * from interview where chroroundpanelist = :mail and chroroundover= :chroroundover and ischroroundscheduled = :ischroroundscheduled " , nativeQuery = true)
	List<Interview> findpendinginterviewbychro(String mail, Boolean chroroundover, Boolean ischroroundscheduled);

	@Transactional
	@Modifying
	@Query(value = "UPDATE interview\r\n"
			+ "SET  chroroundcleared = :checks ,chroremarks = :remarks, chroroundover = :chroroundover ,statusid = :sid,statusdesc = :desc,status = :sta,chroapproved= :checks\r\n"
			+ "WHERE id = :interviewid" , nativeQuery = true) 
	void updateinterviewchroresult(String sid, String sta, String desc, String interviewid, String remarks,
			Boolean checks, Boolean chroroundover);

	

}
