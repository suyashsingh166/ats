package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ats.ATS.model.JobCreation;

public interface JobCreationService {

	public JobCreation saveJobCreation(JobCreation job);

	public List<JobCreation> getAlljobCreation();

	public void deletejobCreationById(int id);


	public List<JobCreation> getApprovalPendingbyCHRO(String desc);

	public JobCreation getAlljobCreationbyid(Integer id);

	public void declinedByCHRO(String sid,String status,String desc,Boolean isacceptedbychro, String chro_remarks, int id);
	public void acceptedByCHRO(String sid,String status,String desc,Boolean isacceptedbychro, String chro_remarks, int id,String hiringmanager);
	
	public void declinedByHOD(String sid,String status,String desc,Boolean isacceptedbyhod, String hod_remarks, int id);
	public void acceptedByHOD(String sid,String status,String desc,Boolean isacceptedbyhod, String hod_remarks, int id);

	public List<JobCreation> getJobCreationBySupervisor(String username);

	public List<JobCreation> getJobCreationByDepartment();

	public ArrayList<JobCreation> JobListRecuriter(String email);

	public String getrequesterid(Integer id);

	public void assignrecruitor(String sid, String sta, String desc, Boolean isassignedtorecruitor, int id,
			String hiringmanager,Date date);

	public ArrayList<JobCreation> JobListRecurit(String email);

	public void updateJobCreation(JobCreation job);

}
