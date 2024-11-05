package com.ats.ATS.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.PriviligeModel;

@Repository
public interface PriviligeRepo extends JpaRepository<PriviligeModel,Integer>{

	

	@Query(value = "SELECT privilege_id FROM privilege WHERE role_Id = :role_Id",nativeQuery = true)
	Integer roleIdCheck(int role_Id);


	@Query(value = "SELECT created_date FROM privilege WHERE privilege_id = :privligeId",nativeQuery = true)
	Date getcreateDate(Integer privligeId);

	@Query(value = "SELECT action_permissions FROM privilege WHERE role_Id = :role_Id",nativeQuery = true)
	String getActioPermission(int role_Id);





	
}
