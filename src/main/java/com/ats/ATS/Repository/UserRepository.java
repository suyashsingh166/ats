package com.ats.ATS.Repository;

import java.util.Optional;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.User;

import jakarta.transaction.Transactional;
@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public Optional<User> findByEmail(String email);

	@Query(value = "select * from user where email = :email" , nativeQuery = true)
	public User finduserbymail(String email);

	@Transactional
	@Modifying
	@Query(value = "Update user set designation = :designation, department = :department where id = :id" , nativeQuery = true)
	public void updateuser(String id, String designation, String department);

}
