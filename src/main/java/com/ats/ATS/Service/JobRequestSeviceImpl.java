package com.ats.ATS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.JobRequestRepo;
import com.ats.ATS.model.JobRequest;

@Service
public class JobRequestSeviceImpl implements JobRequestSevice {
	
	@Autowired
	JobRequestRepo jobRequestRepo;

	@Override
	public List<JobRequest> getAlljobRequest() {
		// TODO Auto-generated method stub
		return jobRequestRepo.findAll();
	}

	@Override
	public void deletejobRequest(int id) {
		// TODO Auto-generated method stub
		jobRequestRepo.deleteById(id);
	}

	@Override
	public JobRequest saveJobRequest(JobRequest job) {
		// TODO Auto-generated method stub
		return jobRequestRepo.save(job);
	}

}
