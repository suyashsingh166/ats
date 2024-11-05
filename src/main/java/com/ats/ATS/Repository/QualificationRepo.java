package com.ats.ATS.Repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ats.ATS.model.QualificationMaster;
@Repository
public interface QualificationRepo extends JpaRepository<QualificationMaster,Integer>{

	@Query(value = "SELECT qualification FROM qualification_master WHERE qualification = :qualification",nativeQuery = true)
	String qualification(String qualification);

	@Query(value = "SELECT created_date FROM qualification_master WHERE id = :id",nativeQuery = true)
	Date getcreateDateQuali(Integer id);

}
