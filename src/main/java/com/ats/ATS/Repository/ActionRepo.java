package com.ats.ATS.Repository;
import com.ats.ATS.model.ActionDto;
import java.util.ArrayList;
import java.util.Date;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.ats.ATS.model.ActionModel;
@Repository
public interface ActionRepo extends JpaRepository<ActionModel, Integer>{

	@Query(value = "SELECT action_name FROM action WHERE action_name = :action_name",nativeQuery = true)
	String action_name(String action_name);

	@Query(value = "SELECT created_date FROM action WHERE action_id = :id",nativeQuery = true)
	Date getcreateaction(Integer id);

	@Query(value = "SELECT new com.ats.ATS.model.ActionDto(actions.action_id , actions.action_name) from ActionModel actions")
	ArrayList<ActionDto> getActioName();



}
