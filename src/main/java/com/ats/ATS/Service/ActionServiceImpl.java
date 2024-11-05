package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.ActionRepo;
import com.ats.ATS.model.ActionDto;
import com.ats.ATS.model.ActionModel;
import com.ats.ATS.model.DesignationMaster;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class ActionServiceImpl implements ActionService {
	
	 @PersistenceContext
	    private EntityManager entityManager;
	
	@Autowired
	private ActionRepo actionRepo;

	@Override
	public String action_name(String action_name) {
		// TODO Auto-generated method stub
		return actionRepo.action_name(action_name);
	}

	@Override
	public ActionModel saveAction(ActionModel action) {
		return actionRepo.save(action);
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<ActionModel> getAllAction() {
		// TODO Auto-generated method stub
		return actionRepo.findAll();
	}

	@Override
	public void deleteActionById(int id) {
		// TODO Auto-generated method stub
		actionRepo.deleteById(id);
	}

	@Override
	public Date getcreateaction(Integer id) {
		// TODO Auto-generated method stub
		return actionRepo.getcreateaction(id);
	}

	@Override
	@Transactional
	public void updateAction(Integer id, ActionModel action) {
		ActionModel existingEntity = entityManager.find(ActionModel.class, id);
        if (existingEntity != null) {
            existingEntity.setAction_name(action.getAction_name());
            existingEntity.setAction_status(action.getAction_status());
            existingEntity.setCreated_date(action.getCreated_date());
            // Set other properties as needed
            entityManager.merge(existingEntity);
	}
	}

	@Override
	public ArrayList<ActionDto> getActioName() {
		// TODO Auto-generated method stub
		return actionRepo.getActioName();
	}

}
