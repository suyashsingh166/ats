package com.ats.ATS.Service;

import java.util.Date;
import java.util.List;

import com.ats.ATS.model.PriviligeModel;

public interface PriviligeService {

	public Integer roleIdCheck(int role_Id);

	public PriviligeModel savePrivilge(PriviligeModel privilige);


	public Date getcreateDate(Integer privligeId);

	public void updatePrivilge(Integer privligeId, PriviligeModel privilige);

	public List<PriviligeModel> getAllPrivlige();

	public void deletePrivlige(int id);

	public String getActioPermission(int role_Id);


}
