package com.ats.ATS.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="status_master")
public class Status {
	 
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "status")
	String status;
	
	@Column(name = "description")
	String description;
	
	Date created_date;


	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}


	public Status(int id, String status, String description, Date created_date) {
		super();
		this.id = id;
		this.status = status;
		this.description = description;
		this.created_date = created_date;
	}

	

	@Override
	public String toString() {
		return "Status [id=" + id + ", status=" + status + ", description=" + description + ", created_date="
				+ created_date + "]";
	}

	public Status() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}
