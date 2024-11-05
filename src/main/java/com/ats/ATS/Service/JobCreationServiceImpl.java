package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.JobCreationRepo;
import com.ats.ATS.model.JobCreation;

@Service
public class JobCreationServiceImpl implements JobCreationService {
	
	@Autowired
	JobCreationRepo jobCreationRepo;
	

	@Override
	public JobCreation saveJobCreation(JobCreation job) {
		return jobCreationRepo.save(job);
		
	}

	@Override
	public List<JobCreation> getAlljobCreation() {
		// TODO Auto-generated method stub
		return jobCreationRepo.findAll();
	}
	
	

	@Override
	public void deletejobCreationById(int id) {
		jobCreationRepo.deleteById(id);
		
	}

	@Override

	public List<JobCreation> getApprovalPendingbyCHRO(String desc) {
		// TODO Auto-generated method stub
		return jobCreationRepo.getApprovalPendingbyCHRO(desc);
	}

	@Override
	public JobCreation getAlljobCreationbyid(Integer id) {
		// TODO Auto-generated method stub
		return jobCreationRepo.findbyjobid(id);
	}

	public void declinedByHOD(String sid,String status,String desc,Boolean isacceptedbyhod, String hod_remarks, int id) {
		// TODO Auto-generated method stub
		jobCreationRepo.declinedByHOD(sid,status,desc,isacceptedbyhod,hod_remarks, id);

	}
	
	public void declinedByCHRO(String sid,String status,String desc,Boolean isacceptedbychro, String chro_remarks, int id) {
		// TODO Auto-generated method stub
		jobCreationRepo.declinedByCHRO(sid,status,desc,isacceptedbychro,chro_remarks, id);

	}

	@Override
	public void acceptedByHOD(String sid, String status, String desc, Boolean isacceptedbyhod, String hod_remarks,
			int id) {
		jobCreationRepo.acceptedByHOD(sid,status,desc,isacceptedbyhod,hod_remarks, id);
	}

	@Override
	public List<JobCreation> getJobCreationBySupervisor(String username) {
		// TODO Auto-generated method stub
		return jobCreationRepo.getJobCreationBySupervisor(username);
	}

	@Override
	public List<JobCreation> getJobCreationByDepartment() {
		// TODO Auto-generated method stub
		
		return jobCreationRepo.findAll();
	}

	@Override
	public void acceptedByCHRO(String sid, String status, String desc, Boolean isacceptedbychro, String chro_remarks,
			int id, String hiringmanager) {
		jobCreationRepo.acceptedByCHRO(sid,status,desc,isacceptedbychro,chro_remarks, id,hiringmanager);
	}

	@Override
	public ArrayList<JobCreation> JobListRecuriter(String email) {
		// TODO Auto-generated method stub
		return jobCreationRepo.JobListRecuriter(email);
	}

	@Override
	public String getrequesterid(Integer id) {
		// TODO Auto-generated method stub
		return jobCreationRepo.getrequesterid(id);
	}

	@Override
	public void assignrecruitor(String sid, String sta, String desc, Boolean isassignedtorecruitor, int id,
			String hiringmanager,Date date) {
		jobCreationRepo.assignrecruitor(sid,sta,desc,isassignedtorecruitor,id,hiringmanager,date);
		
	}

	@Override
	public ArrayList<JobCreation> JobListRecurit(String email) {
		// TODO Auto-generated method stub
		return jobCreationRepo.JobListRecurit(email);
	}

	@Override
	public void updateJobCreation(JobCreation job) {
		
		jobCreationRepo.save(job);
	}

}
