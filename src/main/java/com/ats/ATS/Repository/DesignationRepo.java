package com.ats.ATS.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ATS.model.DesignationMaster;

public interface DesignationRepo extends JpaRepository<DesignationMaster, Integer>{

	@Query(value = "SELECT designation FROM designation_master WHERE designation = :designations",nativeQuery = true)
	String designationname(String designations);
	
	@Query(value = "SELECT id FROM designation_master WHERE designation = :designations",nativeQuery = true)
	Integer findAllById(String designations);

	@Query(value = "SELECT created_date FROM designation_master WHERE id = :id",nativeQuery = true)
	Date getcreateDateDesignation(Integer id);

}
