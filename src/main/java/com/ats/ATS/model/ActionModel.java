package com.ats.ATS.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "action")
@lombok.Data
public class ActionModel {
	
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "action_id")
	private int action_id;
	
	@Column(name = "action_name")
	private String action_name;

	@Column(name = "action_status")
	private String action_status;

	@Column(name = "created_date")
	private Date created_date;

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

	public String getAction_status() {
		return action_status;
	}

	public void setAction_status(String action_status) {
		this.action_status = action_status;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "ActionModel [action_id=" + action_id + ", action_name=" + action_name + ", action_status="
				+ action_status + ", created_date=" + created_date + "]";
	}
	
    
	
}
