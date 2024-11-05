package com.ats.ATS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ATS.model.Department;
import com.ats.ATS.model.Roles;

public interface RoleRepo extends JpaRepository<Roles, Integer>{

	
	
	@Query(value = "SELECT roles FROM role_master WHERE roles = :roles",nativeQuery = true)
	String checkrole(String roles);
	
	

}
