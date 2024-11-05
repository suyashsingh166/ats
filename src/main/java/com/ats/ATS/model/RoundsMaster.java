package com.ats.ATS.model;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "no_of_rounds_master")
@lombok.Data
public class RoundsMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "no_of_rounds")
	private Integer no_of_rounds;
	
	@Column(name = "created_date")
	Date created_date;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	

	public Integer getNo_of_rounds() {
		return no_of_rounds;
	}

	public void setNo_of_rounds(Integer no_of_rounds) {
		this.no_of_rounds = no_of_rounds;
	}

	public Date getCreated_date() {
		return created_date;
	}

	public void setCreated_date(Date created_date) {
		this.created_date = created_date;
	}

	@Override
	public String toString() {
		return "RoundsMaster [id=" + id + ", no_of_rounds=" + no_of_rounds + ", created_date=" + created_date + "]";
	}


}
