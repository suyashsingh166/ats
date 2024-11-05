package com.ats.ATS.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "jobRequest")
@Data
public class JobRequest {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "job_id")
	private int job_id;
	
	@Column(name = "job_name")
	private String job_name;
	

	@Column(name = "no_of_position")
	private String no_of_position;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "designation")
	private String designation;
	
	@Column(name = "ctc_candidate")
	private String ctc_candidate;
	
	@Column(name = "location")
	private String location;
	
	@Column(name = "job_description")
	private String job_description;
	
	@Column(name = "hiring_manager")
	private String hiring_manager ;	

	@Column(name = "replacement_newJoinee")
	private String replacement_newJoinee;
	
	@Column(name = "skills")
	private String skills;
	
	@Column(name = "experience")
	private String experience ;

	@Column(name = "created_date")
	private Date created_date;

	public int getJob_id() {
		return job_id;
	}

	public void setJob_id(int job_id) {
		this.job_id = job_id;
	}
	
	

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getJob_name() {
		return job_name;
	}

	public void setJob_name(String job_name) {
		this.job_name = job_name;
	}

	public String getNo_of_position() {
		return no_of_position;
	}

	public void setNo_of_position(String no_of_position) {
		this.no_of_position = no_of_position;
	}

	public String getCtc_candidate() {
		return ctc_candidate;
	}

	public void setCtc_candidate(String ctc_candidate) {
		this.ctc_candidate = ctc_candidate;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getJob_description() {
		return job_description;
	}

	public void setJob_description(String job_description) {
		this.job_description = job_description;
	}

	public String getHiring_manager() {
		return hiring_manager;
	}

	public void setHiring_manager(String hiring_manager) {
		this.hiring_manager = hiring_manager;
	}

	public String getReplacement_newJoinee() {
		return replacement_newJoinee;
	}

	public void setReplacement_newJoinee(String replacement_newJoinee) {
		this.replacement_newJoinee = replacement_newJoinee;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "JobRequest [job_id=" + job_id + ", job_name=" + job_name + ", no_of_position=" + no_of_position
				+ ", department=" + department + ", designation=" + designation + ", ctc_candidate=" + ctc_candidate
				+ ", location=" + location + ", job_description=" + job_description + ", hiring_manager="
				+ hiring_manager + ", replacement_newJoinee=" + replacement_newJoinee + ", skills=" + skills
				+ ", experience=" + experience + ", created_date=" + created_date + "]";
	}

	public JobRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	public JobRequest(int job_id, String job_name, String no_of_position, String department, String designation,
			String ctc_candidate, String location, String job_description, String hiring_manager,
			String replacement_newJoinee, String skills, String experience, Date created_date) {
		super();
		this.job_id = job_id;
		this.job_name = job_name;
		this.no_of_position = no_of_position;
		this.department = department;
		this.designation = designation;
		this.ctc_candidate = ctc_candidate;
		this.location = location;
		this.job_description = job_description;
		this.hiring_manager = hiring_manager;
		this.replacement_newJoinee = replacement_newJoinee;
		this.skills = skills;
		this.experience = experience;
		this.created_date = created_date;
	}

	
	
	


}
