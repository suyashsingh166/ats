package com.ats.ATS.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "department_master")
@lombok.Data
public class Department {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "created_date")
	Date created_date;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
	
	
	
	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	public Department(int id, String department, Date created_date) {
		super();
		this.id = id;
		this.department = department;
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", department=" + department + ", created_date=" + created_date + "]";
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
