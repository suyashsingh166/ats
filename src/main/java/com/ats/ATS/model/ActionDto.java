package com.ats.ATS.model;

import jakarta.persistence.Column;

public class ActionDto {
	
private int action_id;
	
	private String action_name;

	public int getAction_id() {
		return action_id;
	}

	public void setAction_id(int action_id) {
		this.action_id = action_id;
	}

	public String getAction_name() {
		return action_name;
	}

	public void setAction_name(String action_name) {
		this.action_name = action_name;
	}

	@Override
	public String toString() {
		return "ActionDto [action_id=" + action_id + ", action_name=" + action_name + "]";
	}

	public ActionDto(int action_id, String action_name) {
		super();
		this.action_id = action_id;
		this.action_name = action_name;
	}
	
	
}
