package com.ats.ATS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.JobRequest;

@Repository
public interface JobRequestRepo extends JpaRepository<JobRequest, Integer>{

}
