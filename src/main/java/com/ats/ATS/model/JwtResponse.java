package com.ats.ATS.model;

import lombok.Builder;


@Builder
public class JwtResponse {

	private String jwtToken;
	private String username;
	private String name;
	private Integer department_id;
	private Integer designation_id;
	private String role;
	private String designation;
	private String department;
	private Integer id;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(Integer department_id) {
		this.department_id = department_id;
	}
	public Integer getDesignation_id() {
		return designation_id;
	}
	public void setDesignation_id(Integer designation_id) {
		this.designation_id = designation_id;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJwtToken() {
		return jwtToken;
	}
	public void setJwtToken(String jwtToken) {
		this.jwtToken = jwtToken;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	

	
 
	public JwtResponse(String jwtToken, String username, String name, Integer department_id, Integer designation_id,
			String role, String designation, String department, Integer id) {
		super();
		this.jwtToken = jwtToken;
		this.username = username;
		this.name = name;
		this.department_id = department_id;
		this.designation_id = designation_id;
		this.role = role;
		this.designation = designation;
		this.department = department;
		this.id = id;
	}
	@Override
	public String toString() {
		return "JwtResponse [jwtToken=" + jwtToken + ", username=" + username + ", name=" + name + ", department_id="
				+ department_id + ", designation_id=" + designation_id + ", role=" + role + ", designation="
				+ designation + ", department=" + department + ", id=" + id + "]";
	}
	public static Object builder() {
		// TODO Auto-generated method stub
		return null;
	}
	public JwtResponse() {
		super();
		// TODO Auto-generated constructor stub
	}
}
