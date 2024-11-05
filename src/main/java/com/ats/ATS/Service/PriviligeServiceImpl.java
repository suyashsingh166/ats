package com.ats.ATS.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.PriviligeRepo;
import com.ats.ATS.model.PriviligeModel;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class PriviligeServiceImpl implements PriviligeService {

	  @PersistenceContext
	    private EntityManager entityManager;
	
	@Autowired
	private PriviligeRepo priviligeRepo;
	
	@Override
	public Integer roleIdCheck(int role_Id) {
		// TODO Auto-generated method stub
		return priviligeRepo.roleIdCheck(role_Id);
	}

	@Override
	public PriviligeModel savePrivilge(PriviligeModel privilige) {
		return priviligeRepo.save(privilige);
		// TODO Auto-generated method stub
		
	}



	@Override
	public Date getcreateDate(Integer privligeId) {
		// TODO Auto-generated method stub
		return priviligeRepo.getcreateDate(privligeId);
	}

	@Override
	 @Transactional
	public void updatePrivilge(Integer privligeId, PriviligeModel privilige) {
		PriviligeModel existingEntity = entityManager.find(PriviligeModel.class, privligeId);
	        if (existingEntity != null) {
	            existingEntity.setAction_permissions(privilige.getAction_permissions());
	            existingEntity.setRole_Id(privilige.getRole_Id());
	            existingEntity.setCreated_date(privilige.getCreated_date());
	            // Set other properties as needed
	            entityManager.merge(existingEntity);
	        }


	}

	@Override
	public List<PriviligeModel> getAllPrivlige() {
		// TODO Auto-generated method stub
		return priviligeRepo.findAll();
	}

	@Override
	public void deletePrivlige(int id) {
		// TODO Auto-generated method stub
		priviligeRepo.deleteById(id);
	}

	@Override
	public String getActioPermission(int role_Id) {
		// TODO Auto-generated method stub
		return priviligeRepo.getActioPermission(role_Id);
	}

}
