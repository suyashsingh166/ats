package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ats.ATS.Repository.DepartmentRepo;
import com.ats.ATS.Repository.RoleRepo;
import com.ats.ATS.model.Department;
import com.ats.ATS.model.DesignationMaster;
import com.ats.ATS.model.JobCreation;
import com.ats.ATS.model.Roles;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
@Service
public class DepartmentServiceImpl implements  DepartmentService{
	
	 @PersistenceContext
	    private EntityManager entityManager;
	
	@Autowired
	DepartmentRepo departmentrepo;
	
	@Autowired
	RoleRepo rolerepo;

	@Override
	public List<Department> find() {
		return departmentrepo.findAll();
	}

	@Override
	public List<Roles> findRole() {
		// TODO Auto-generated method stub
		return rolerepo.findAll();
	}

	@Override
	public Roles saverolemaster(Roles role) {
		// TODO Auto-generated method stub
		return rolerepo.save(role);
	}

	@Override
	public String checkrole(String roles) {
		// TODO Auto-generated method stub
		return rolerepo.checkrole(roles);
	}

	@Override
	public Department savedeptmaster(Department dept) {
		// TODO Auto-generated method stub
		return departmentrepo.save(dept);
	}

	@Override
	public String checkdept(String department) {
		// TODO Auto-generated method stub
		return departmentrepo.checkdept(department);
	}

	@Override
	public void deleteroleById(int id) {
		rolerepo.deleteById(id);
		
	}

	@Override
	public void deletedeptById(int id) {
		// TODO Auto-generated method stub
		departmentrepo.deleteById(id);

	
	}

	@Override
	public Date getcreateRole(Integer id) {
		// TODO Auto-generated method stub
		return departmentrepo.getcreateRole(id);
	}

	@Override
	@Transactional
	public void updateRole(Integer id, Roles role) {
		Roles existingEntity = entityManager.find(Roles.class, id);
        if (existingEntity != null) {
            existingEntity.setRoles(role.getRoles());
            existingEntity.setCreated_date(role.getCreated_date());
            // Set other properties as needed
            entityManager.merge(existingEntity);
	}
	}

	public Integer finddepartmentid(String department) {
		
		return departmentrepo.finddepartmentId(department);

	}

	@Override
	public ArrayList<String> getallDept() {
		// TODO Auto-generated method stub
		return departmentrepo.getallDept();
	}

	

}
