package com.ats.ATS.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ATS.model.LocationMaster;

public interface LocationRepo extends JpaRepository<LocationMaster, Integer>{

	@Query(value = "SELECT location FROM location_master WHERE location = :locations",nativeQuery = true)
	String locationnname(String locations);

	@Query(value = "SELECT created_date FROM location_master WHERE id = :id",nativeQuery = true)
	Date getcreateDateLoc(Integer id);



}
