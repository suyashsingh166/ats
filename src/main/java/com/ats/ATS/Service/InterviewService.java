package com.ats.ATS.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.Interview;

@Service
public interface InterviewService {

	void saveinterviewonedata(Interview interview);

	Interview checkcandidate(String cid);

	List<Interview> getpendinginterviews(String mail);

	List<Interview> getpendinginterviewsbyrecruiter(String mail);

	void updateinterviewoneresult(String statusid,String status,String desc,String interviewid, String remarks,Boolean check, Boolean isinterviewoneover);

	List<Interview> getpendinginterviewsround2(String mail);

	Interview checkcandidateroundtwo(String cid);

	void saveinterviewtwodata(int id, String panelist, String date, String time, String url, String remarks);

	void updateinterviewtworesult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewtwoover);

	Interview checkcandidateroundthree(String cid);

	void saveinterviewthreedata(int id, String panelist, String date, String time, String url, String remarks);

	List<Interview> getpendinginterviewsround3(String mail);

	void updateinterviewthreeresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewthreeover);

	void updateinterviewfourresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewthreeover);

	void updateinterviewfiveresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks, Boolean isinterviewthreeover);

	Interview checkcandidateroundfour(String cid);

	Interview checkcandidateroundfive(String cid);

	void saveinterviewfourdata(int id, String panelist, String date, String time, String url, String remarks);

	void saveinterviewfivedata(int id, String panelist, String date, String time, String url, String remarks);

	List<Interview> getpendinginterviewsround4(String mail);

	List<Interview> getpendinginterviewsround5(String mail);

	void updateinterviewonedata(String time, String date, String url, String panelist, String cid);

	void updateinterviewtwodata(String time, String date, String url, String panelist, String cid);

	void updateinterviewthreedata(String time, String date, String url, String panelist, String cid);

	void updateinterviewfourdata(String time, String date, String url, String panelist, String cid);

	void updateinterviewfivedata(String time, String date, String url, String panelist, String cid);

	Interview getAllinterviewdata(String id);

	Interview checkcandidateroundchro(String cid);

	void saveinterviewchrodata(int id, String panelist, String date, String time, String url, String remarks);

	List<Interview> getpendinginterviewsbychro(String mail);

	void updateinterviewchroresult(String sid, String sta, String desc, String interviewid, String remarks,
			Boolean check, Boolean isinterviewtwoover);

	

}
