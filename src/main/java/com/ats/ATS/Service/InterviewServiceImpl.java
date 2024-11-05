package com.ats.ATS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.InterviewRepo;
import com.ats.ATS.model.Interview;

@Service
public class InterviewServiceImpl implements InterviewService{
	
	@Autowired
	InterviewRepo interviewRepo;

	@Override
	public void saveinterviewonedata(Interview interview) {
		interviewRepo.save(interview);
		
	}

	@Override
	public Interview checkcandidate(String cid) {
		Boolean check=true;
		return interviewRepo.checkcandidate(cid,check);
	}

	@Override
	public List<Interview> getpendinginterviews(String mail) {
	Boolean isinterviewover=false;
	Boolean isinterview1scheduled=true;
	String status="HOLD1";
		return interviewRepo.findpendinginterview(mail,isinterviewover,isinterview1scheduled,status);
	}

	@Override
	public List<Interview> getpendinginterviewsbyrecruiter(String mail) {
		// TODO Auto-generated method stub
		return interviewRepo.findpendinginterviewbyrecruiter(mail);
	}

	@Override
	public void updateinterviewoneresult(String statusid,String status,String desc,String interviewid, String remarks,Boolean check,Boolean isinterviewoneover) {
		
		interviewRepo.updateinterviewoneresult(statusid,status,desc,interviewid,remarks,check,isinterviewoneover);
		
	}

	@Override
	public List<Interview> getpendinginterviewsround2(String mail) {
		Boolean isinterviewover=false;
		Boolean isinterview2scheduled=true;
		String status="HOLD2";
			return interviewRepo.findpendinginterviewround2(mail,isinterviewover,isinterview2scheduled,status);
	}

	@Override
	public Interview checkcandidateroundtwo(String cid) {
		Boolean check=true;
		return interviewRepo.checkcandidateroundtwo(cid,check);
	}

	@Override
	public void saveinterviewtwodata(int id, String panelist, String date, String time, String url, String remarks) {
		Boolean check=true;
		Boolean checks=false;
		interviewRepo.updateinterviewtwoschedule(id,panelist,date,time,url,remarks,check,checks);
		
	}

	@Override
	public void updateinterviewtworesult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks,
			Boolean isinterviewtwoover) {
		interviewRepo.updateinterviewtworesult(statusid,status,desc,interviewid,remarks,checks,isinterviewtwoover);
		
	}

	@Override
	public Interview checkcandidateroundthree(String cid) {
		Boolean check=true;
		return interviewRepo.checkcandidateroundthree(cid,check);
	}

	@Override
	public void saveinterviewthreedata(int id, String panelist, String date, String time, String url, String remarks) {
		Boolean check=true;
		Boolean checks=false;
		interviewRepo.updateinterviewthreeschedule(id,panelist,date,time,url,remarks,check,checks);
	}

	@Override
	public List<Interview> getpendinginterviewsround3(String mail) {
		Boolean isinterviewover=false;
		Boolean isinterview3scheduled=true;
		String status="HOLD3";
			return interviewRepo.findpendinginterviewround3(mail,isinterviewover,isinterview3scheduled,status);
	}

	@Override
	public void updateinterviewthreeresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks,
			Boolean isinterviewthreeover) {
		interviewRepo.updateinterviewthreeresult(statusid,status,desc,interviewid,remarks,checks,isinterviewthreeover);
		
	}

	@Override
	public void updateinterviewfourresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks,
			Boolean isinterviewthreeover) {
		interviewRepo.updateinterviewfourresult(statusid,status,desc,interviewid,remarks,checks,isinterviewthreeover);
		
	}

	@Override
	public void updateinterviewfiveresult(String statusid,String status,String desc,String interviewid, String remarks, Boolean checks,
			Boolean isinterviewthreeover) {
		interviewRepo.updateinterviewfiveresult(statusid,status,desc,interviewid,remarks,checks,isinterviewthreeover);
		
	}

	@Override
	public Interview checkcandidateroundfour(String cid) {
		Boolean check=true;
		return interviewRepo.checkcandidateroundfour(cid,check);
	}
	
	@Override
	public Interview checkcandidateroundfive(String cid) {
		Boolean check=true;
		return interviewRepo.checkcandidateroundfive(cid,check);
	}

	@Override
	public void saveinterviewfourdata(int id, String panelist, String date, String time, String url, String remarks) {
		Boolean check=true;
		Boolean checks=false;
		interviewRepo.updateinterviewfourschedule(id,panelist,date,time,url,remarks,check,checks);
		
	}

	@Override
	public void saveinterviewfivedata(int id, String panelist, String date, String time, String url, String remarks) {
		Boolean check=true;
		Boolean checks=false;
		interviewRepo.updateinterviewfiveschedule(id,panelist,date,time,url,remarks,check,checks);
		
	}

	@Override
	public List<Interview> getpendinginterviewsround4(String mail) {
		Boolean isinterviewover=false;
		Boolean isinterview4scheduled=true;
		String status="HOLD4";
			return interviewRepo.findpendinginterviewround4(mail,isinterviewover,isinterview4scheduled,status);
	}

	@Override
	public List<Interview> getpendinginterviewsround5(String mail) {
		Boolean isinterviewover=false;
		Boolean isinterview5scheduled=true;
		String status="HOLD5";
			return interviewRepo.findpendinginterviewround5(mail,isinterviewover,isinterview5scheduled,status);
	}

	@Override
	public void updateinterviewonedata(String time, String date, String url, String panelist, String cid) {
		interviewRepo.updateinterviewone(time, date, url, panelist,cid);
	}

	@Override
	public void updateinterviewtwodata(String time, String date, String url, String panelist, String cid) {
		interviewRepo.updateinterviewtwo(time, date, url, panelist,cid);
		
	}

	@Override
	public void updateinterviewthreedata(String time, String date, String url, String panelist, String cid) {
		interviewRepo.updateinterviewthree(time, date, url, panelist,cid);
		
	}

	@Override
	public void updateinterviewfourdata(String time, String date, String url, String panelist, String cid) {
		interviewRepo.updateinterviewfour(time, date, url, panelist,cid);
		
	}

	@Override
	public void updateinterviewfivedata(String time, String date, String url, String panelist, String cid) {
		interviewRepo.updateinterviewfive(time, date, url, panelist,cid);
	}

	@Override
	public Interview getAllinterviewdata(String id) {
		// TODO Auto-generated method stub
		return interviewRepo.getAllinterviewdata(id);
	}

	@Override
	public Interview checkcandidateroundchro(String cid) {
		Boolean check=true;
		return interviewRepo.checkcandidateroundchro(cid,check);
	}

	@Override
	public void saveinterviewchrodata(int id, String panelist, String date, String time, String url, String remarks) {
		Boolean check=true;
		Boolean checks=false;
		interviewRepo.updateinterviewchroschedule(id,panelist,date,time,url,remarks,check,checks);
	}

	@Override
	public List<Interview> getpendinginterviewsbychro(String mail) {
		Boolean chroroundover=false;
		Boolean ischroroundscheduled=true;
			return interviewRepo.findpendinginterviewbychro(mail,chroroundover,ischroroundscheduled);
	}

	@Override
	public void updateinterviewchroresult(String sid, String sta, String desc, String interviewid, String remarks,
			Boolean checks, Boolean chroroundover) {
		interviewRepo.updateinterviewchroresult(sid,sta,desc,interviewid,remarks,checks,chroroundover);
		
	}

	

}
