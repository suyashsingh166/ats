package com.ats.ATS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.Status;
@Repository
public interface StatusRepo extends JpaRepository<Status, Integer>{
   
	@Query(value = "SELECT * FROM status_master WHERE status = :status",nativeQuery = true)
	Status findstatus(String status);

}
