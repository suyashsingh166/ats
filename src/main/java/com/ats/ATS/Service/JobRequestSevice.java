package com.ats.ATS.Service;

import java.util.List;

import com.ats.ATS.model.JobRequest;

public interface JobRequestSevice {

	List<JobRequest> getAlljobRequest();

	public void deletejobRequest(int id);

	public JobRequest saveJobRequest(JobRequest job);

}
