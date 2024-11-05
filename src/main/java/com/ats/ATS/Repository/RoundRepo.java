package com.ats.ATS.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ats.ATS.model.RoundsMaster;

public interface RoundRepo extends JpaRepository<RoundsMaster,Integer>{

	@Query(value = "SELECT no_of_rounds FROM no_of_rounds_master WHERE no_of_rounds = :no_of_rounds",nativeQuery = true)
	Integer noOfRounds(Integer no_of_rounds);

	@Query(value = "SELECT created_date FROM no_of_rounds_master WHERE id = :id",nativeQuery = true)
	Date getcreateDate(Integer id);

}
