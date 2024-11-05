package com.ats.ATS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.StatusRepo;
import com.ats.ATS.model.Status;

@Service
public class StatusServiceImpl implements StatusService{
@Autowired
StatusRepo statusRepo;
	@Override
	public void deletestatusById(int id) {
		statusRepo.deleteById(id);
		
	}
	@Override
	public Status saveStatus(Status status) {
		// TODO Auto-generated method stub
		return statusRepo.save(status);
	}
	@Override
	public List<Status> getAllStatus() {
		// TODO Auto-generated method stub
		return statusRepo.findAll();
	}
	@Override
	public Status fetchstatus(String status) {
	
		return statusRepo.findstatus(status);
	}

}
