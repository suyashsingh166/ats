package com.ats.ATS.Repository;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.ApplicantData;
import com.ats.ATS.model.Department;
import com.ats.ATS.model.JobCreation;

@Repository
public interface DepartmentRepo extends JpaRepository<Department, Integer>{

	@Query(value = "SELECT department FROM department_master WHERE department = :department",nativeQuery = true)
	String checkdept(String department);
	
	@Query(value = "SELECT created_date FROM department_master WHERE id = :id",nativeQuery = true)
	Date getcreateRole(Integer id);

	
	@Query(value = "SELECT id FROM department_master WHERE department = :department",nativeQuery = true)
	public Integer finddepartmentId(String department);

	@Query(value = "SELECT department FROM department_master",nativeQuery = true)
	ArrayList<String> getallDept();

	//ArrayList<JobCreation> JobListRecuriter();



}
