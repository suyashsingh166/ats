package com.ats.ATS.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="role_master")
public class Roles {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(unique = true)
	String roles;
	
	Date created_date;


	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoles() {
		return roles;
	}

	public void setRoles(String roles) {
		this.roles = roles;
	}



	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	
	
	public Roles(int id, String roles, Date created_date) {
		super();
		this.id = id;
		this.roles = roles;
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Roles [id=" + id + ", roles=" + roles + ", created_date=" + created_date + "]";
	}

	public Roles() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
