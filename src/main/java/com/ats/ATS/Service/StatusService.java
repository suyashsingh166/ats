package com.ats.ATS.Service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.Status;

@Service
public interface StatusService {

	public void deletestatusById(int id);
	public Status saveStatus(Status status);
	public List<Status> getAllStatus();
    public Status fetchstatus(String status);
	
}
