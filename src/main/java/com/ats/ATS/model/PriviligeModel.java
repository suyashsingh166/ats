package com.ats.ATS.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "privilege")
public class PriviligeModel {
	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	@Column(name = "privilege_id")
	private int privilege_id;
	
	@Column(name = "role_Id")
	private int role_Id;
	
	@Column(name = "action_permissions")
	private String action_permissions;
	
	@Column(name = "created_date")
	private Date created_date;

	public int getPrivilege_id() {
		return privilege_id;
	}

	public void setPrivilege_id(int privilege_id) {
		this.privilege_id = privilege_id;
	}

	public int getRole_Id() {
		return role_Id;
	}

	public void setRole_Id(int role_Id) {
		this.role_Id = role_Id;
	}

	public String getAction_permissions() {
		return action_permissions;
	}

	public void setAction_permissions(String action_permissions) {
		this.action_permissions = action_permissions;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "PriviligeModel [privilege_id=" + privilege_id + ", role_Id=" + role_Id + ", action_permissions="
				+ action_permissions + ", created_date=" + created_date + "]";
	}
	
	

}
