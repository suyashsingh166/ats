package com.ats.ATS.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.ApplicantData;
import com.ats.ATS.model.JobCreation;

import jakarta.transaction.Transactional;
@Repository
public interface JobCreationRepo extends JpaRepository<JobCreation, Integer>{
	
	@Query(value = "select * from applicant where email_id = :mail" , nativeQuery = true)
	public ApplicantData findbyMail(String mail);


	@Query(value = "select * from job_creation where status = :desc" , nativeQuery = true)
	public List<JobCreation> getApprovalPendingbyCHRO(String desc);

	@Query(value = "select * from job_creation where id = :id" , nativeQuery = true)
	public JobCreation findbyjobid(Integer id);

	@Transactional
	@Modifying
	@Query(value = "Update job_creation set status = :status, status_id = :sid, statusdesc = :descrip,  isacceptedbyhod = :isacceptedbyhod, hod_remarks = :hod_remarks where id = :id" , nativeQuery = true)
	public void declinedByHOD(String sid,String status,String descrip,Boolean isacceptedbyhod, String hod_remarks, int id);

	
	@Transactional
	@Modifying
	@Query(value = "Update job_creation set status = :status, status_id = :sid, statusdesc = :descrip,  isacceptedbychro = :isacceptedbychro, chro_remarks = :chro_remarks where id = :id" , nativeQuery = true)
	public void declinedByCHRO(String sid,String status,String descrip,Boolean isacceptedbychro, String chro_remarks, int id);

	@Transactional
	@Modifying
	@Query(value = "Update job_creation set status = :status, status_id = :sid, statusdesc = :desc,  isacceptedbyhod = :isacceptedbyhod, hod_remarks = :hod_remarks where id = :id" , nativeQuery = true)
	public void acceptedByHOD(String sid, String status, String desc, Boolean isacceptedbyhod, String hod_remarks,
			int id);

	@Transactional
	@Modifying
	@Query(value = "Update job_creation set status = :status, status_id = :sid, statusdesc = :desc,  isacceptedbychro = :isacceptedbychro, chro_remarks = :chro_remarks, hiringmanager = :hiringmanager, chroaccepted_date = NOW()   where id = :id" , nativeQuery = true)
	public void acceptedByCHRO(String sid, String status, String desc, Boolean isacceptedbychro, String chro_remarks,
			int id, String hiringmanager);

	@Query(value = "select * from job_creation where requestedby = :username" , nativeQuery = true)
	public List<JobCreation> getJobCreationBySupervisor(String username);

	@Query(value = "select job.* from job_creation job left join user u1 on job.hiringmanager = u1.name where job.isacceptedbychro = 1 and u1.email=:email" , nativeQuery = true)
	public ArrayList<JobCreation> JobListRecuriter(String email);

	@Query(value = "select requestedby from job_creation where id = :id" , nativeQuery = true)
	public String getrequesterid(Integer id);

	@Transactional
	@Modifying
	@Query(value = "Update job_creation set status = :sta, status_id = :sid, statusdesc = :desc,  isassignedtorecruitor = :isassignedtorecruitor, recruiter = :hiringmanager, rmaccepted_date = NOW() , target_date = :date where id = :id" , nativeQuery = true)
		public void assignrecruitor(String sid, String sta, String desc, Boolean isassignedtorecruitor, int id,
			String hiringmanager,Date date);

	@Query(value = "select * from job_creation where recruiter=:email" , nativeQuery = true)
	public ArrayList<JobCreation> JobListRecurit(String email);

	

}
