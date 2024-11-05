package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

import com.ats.ATS.model.Department;
import com.ats.ATS.model.JobCreation;
import com.ats.ATS.model.Roles;

@Service
public interface DepartmentService {
	
public List<Department> find();

public List<Roles> findRole();

public Roles saverolemaster(Roles role);

public String checkrole(String roles);

public Department savedeptmaster(Department dept);

public String checkdept(String department);
public Integer finddepartmentid(String department);

public void deleteroleById(int id);

public void deletedeptById(int id);

public Date getcreateRole(Integer id);

public void updateRole(Integer id, Roles role);

public ArrayList<String> getallDept();

//ArrayList<JobCreation> JobListRecuriter();


}
