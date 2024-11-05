package com.ats.ATS.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ats.ATS.model.ActionDto;
import com.ats.ATS.model.ActionModel;

public interface ActionService {

	String action_name(String action_name);

	public ActionModel saveAction(ActionModel action);

	public List<ActionModel> getAllAction();

	public void deleteActionById(int id);

	Date getcreateaction(Integer id);

	void updateAction(Integer id, ActionModel action);

	ArrayList<ActionDto> getActioName();

}
