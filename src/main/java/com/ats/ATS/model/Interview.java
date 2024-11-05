package com.ats.ATS.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "interview")
@lombok.Data
public class Interview {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "jobid")
	private String jobid;
	
	@Column(unique = true)
	private String candidateid;
	
	@Column(name = "iscandidatescreened")
	private Boolean iscandidatescreened;
	
	@Column(name = "screeningremarks")
	private String screeningremarks;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "statusdesc")
	private String statusdesc;
	
	@Column(name = "statusid")
	private Integer statusid;
	
	@Column(name = "interview1date")
	private String interview1date;
	
	@Column(name = "interview1time")
	private String interview1time;
	
	@Column(name = "interview1panelist")
	private String interview1panelist;
	
	@Column(name = "interview1url")
	private String interview1url;
	
	@Column(name = "interview1remarks")
	private String interview1remarks;
	
	@Column(name = "recruiter")
	private String recruiter;
	
	@Column(name = "noofround")
	private String noofround;
	
	@Column(name = "isinterview1cleared")
	private Boolean isinterview1cleared;
	
	@Column(name = "isinterview1over")
	private Boolean isinterview1over;
	
	@Column(name = "isinterview1scheduled")
	private Boolean isinterview1scheduled;
	
	@Column(name = "interview2date")
	private String interview2date;
	
	@Column(name = "interview2time")
	private String interview2time;
	
	@Column(name = "interview2panelist")
	private String interview2panelist;
	
	@Column(name = "interview2url")
	private String interview2url;
	
	@Column(name = "interview2remarks")
	private String interview2remarks;
	
	@Column(name = "isinterview2cleared")
	private Boolean isinterview2cleared;
	
	@Column(name = "isinterview2over")
	private Boolean isinterview2over;
	
	@Column(name = "isinterview2scheduled")
	private Boolean isinterview2scheduled;
	
	@Column(name = "interview3date")
	private String interview3date;
	
	@Column(name = "interview3time")
	private String interview3time;
	
	@Column(name = "interview3panelist")
	private String interview3panelist;
	
	@Column(name = "interview3url")
	private String interview3url;
	
	@Column(name = "interview3remarks")
	private String interview3remarks;
	
	@Column(name = "isinterview3cleared")
	private Boolean isinterview3cleared;
	
	@Column(name = "isinterview3over")
	private Boolean isinterview3over;
	
	@Column(name = "isinterview3scheduled")
	private Boolean isinterview3scheduled;
	
	@Column(name = "interview4date")
	private String interview4date;
	
	@Column(name = "interview4time")
	private String interview4time;
	
	@Column(name = "interview4panelist")
	private String interview4panelist;
	
	@Column(name = "interview4url")
	private String interview4url;
	
	@Column(name = "interview4remarks")
	private String interview4remarks;
	
	@Column(name = "isinterview4cleared")
	private Boolean isinterview4cleared;
	
	@Column(name = "isinterview4over")
	private Boolean isinterview4over;
	
	@Column(name = "isinterview4scheduled")
	private Boolean isinterview4scheduled;
	
	@Column(name = "interview5date")
	private String interview5date;
	
	@Column(name = "interview5time")
	private String interview5time;
	
	@Column(name = "interview5panelist")
	private String interview5panelist;
	
	@Column(name = "interview5url")
	private String interview5url;
	
	@Column(name = "interview5remarks")
	private String interview5remarks;
	
	@Column(name = "isinterview5cleared")
	private Boolean isinterview5cleared;
	
	@Column(name = "isinterview5over")
	private Boolean isinterview5over;
	
	@Column(name = "isinterview5scheduled")
	private Boolean isinterview5scheduled;
	
	@Column(name = "ischroroundscheduled")
	  private Boolean ischroroundscheduled;
	
	@Column(name = "chroremarks")
	private String chroremarks;
	
	@Column(name = "chroapproved")
	  private Boolean chroapproved;
	
	@Column(name = "chrorejected")
	  private Boolean chrorejected;
	
	@Column(name = "chrorounddate")
	private String chrorounddate;
	
	@Column(name = "chroroundtime")
	private String chroroundtime;
	
	@Column(name = "chroroundpanelist")
	private String chroroundpanelist;
	
	@Column(name = "chroroundurl")
	private String chroroundurl;
	
	@Column(name = "chroroundcleared")
	private Boolean chroroundcleared;
	
	@Column(name = "chroroundover")
	private Boolean chroroundover;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getJobid() {
		return jobid;
	}

	public void setJobid(String jobid) {
		this.jobid = jobid;
	}

	public String getCandidateid() {
		return candidateid;
	}

	public void setCandidateid(String candidateid) {
		this.candidateid = candidateid;
	}

	public Boolean getIscandidatescreened() {
		return iscandidatescreened;
	}

	public void setIscandidatescreened(Boolean iscandidatescreened) {
		this.iscandidatescreened = iscandidatescreened;
	}

	public String getScreeningremarks() {
		return screeningremarks;
	}

	public void setScreeningremarks(String screeningremarks) {
		this.screeningremarks = screeningremarks;
	}
	
	

	public String getNoofround() {
		return noofround;
	}

	public void setNoofround(String noofround) {
		this.noofround = noofround;
	}
	
	

	public Boolean getIsinterview1over() {
		return isinterview1over;
	}

	public void setIsinterview1over(Boolean isinterview1over) {
		this.isinterview1over = isinterview1over;
	}

	public String getInterview1date() {
		return interview1date;
	}

	public void setInterview1date(String interview1date) {
		this.interview1date = interview1date;
	}

	public String getInterview1time() {
		return interview1time;
	}

	public void setInterview1time(String interview1time) {
		this.interview1time = interview1time;
	}
	
	

	public String getRecruiter() {
		return recruiter;
	}

	public void setRecruiter(String recruiter) {
		this.recruiter = recruiter;
	}

	public String getInterview1panelist() {
		return interview1panelist;
	}

	public void setInterview1panelist(String interview1panelist) {
		this.interview1panelist = interview1panelist;
	}

	public String getInterview1remarks() {
		return interview1remarks;
	}

	public void setInterview1remarks(String interview1remarks) {
		this.interview1remarks = interview1remarks;
	}
	
	

	public String getInterview1url() {
		return interview1url;
	}

	public void setInterview1url(String interview1url) {
		this.interview1url = interview1url;
	}

	public Boolean getIsinterview1scheduled() {
		return isinterview1scheduled;
	}

	public void setIsinterview1scheduled(Boolean isinterview1scheduled) {
		this.isinterview1scheduled = isinterview1scheduled;
	}

	public Boolean getIsinterview1cleared() {
		return isinterview1cleared;
	}

	public void setIsinterview1cleared(Boolean isinterview1cleared) {
		this.isinterview1cleared = isinterview1cleared;
	}

	


	public String getInterview2date() {
		return interview2date;
	}

	public void setInterview2date(String interview2date) {
		this.interview2date = interview2date;
	}

	public String getInterview2time() {
		return interview2time;
	}

	public void setInterview2time(String interview2time) {
		this.interview2time = interview2time;
	}

	public String getInterview2panelist() {
		return interview2panelist;
	}

	public void setInterview2panelist(String interview2panelist) {
		this.interview2panelist = interview2panelist;
	}

	public String getInterview2url() {
		return interview2url;
	}

	public void setInterview2url(String interview2url) {
		this.interview2url = interview2url;
	}

	public String getInterview2remarks() {
		return interview2remarks;
	}

	public void setInterview2remarks(String interview2remarks) {
		this.interview2remarks = interview2remarks;
	}

	public Boolean getIsinterview2cleared() {
		return isinterview2cleared;
	}

	public void setIsinterview2cleared(Boolean isinterview2cleared) {
		this.isinterview2cleared = isinterview2cleared;
	}

	public Boolean getIsinterview2over() {
		return isinterview2over;
	}

	public void setIsinterview2over(Boolean isinterview2over) {
		this.isinterview2over = isinterview2over;
	}

	public Boolean getIsinterview2scheduled() {
		return isinterview2scheduled;
	}

	public void setIsinterview2scheduled(Boolean isinterview2scheduled) {
		this.isinterview2scheduled = isinterview2scheduled;
	}
	
	

	

	public String getInterview3date() {
		return interview3date;
	}

	public void setInterview3date(String interview3date) {
		this.interview3date = interview3date;
	}

	public String getInterview3time() {
		return interview3time;
	}

	public void setInterview3time(String interview3time) {
		this.interview3time = interview3time;
	}

	public String getInterview3panelist() {
		return interview3panelist;
	}

	public void setInterview3panelist(String interview3panelist) {
		this.interview3panelist = interview3panelist;
	}

	public String getInterview3url() {
		return interview3url;
	}

	public void setInterview3url(String interview3url) {
		this.interview3url = interview3url;
	}

	public String getInterview3remarks() {
		return interview3remarks;
	}

	public void setInterview3remarks(String interview3remarks) {
		this.interview3remarks = interview3remarks;
	}

	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusdesc() {
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}

	public Integer getStatusid() {
		return statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	public Boolean getIsinterview3cleared() {
		return isinterview3cleared;
	}

	public void setIsinterview3cleared(Boolean isinterview3cleared) {
		this.isinterview3cleared = isinterview3cleared;
	}

	public Boolean getIsinterview3over() {
		return isinterview3over;
	}

	public void setIsinterview3over(Boolean isinterview3over) {
		this.isinterview3over = isinterview3over;
	}

	public Boolean getIsinterview3scheduled() {
		return isinterview3scheduled;
	}

	public void setIsinterview3scheduled(Boolean isinterview3scheduled) {
		this.isinterview3scheduled = isinterview3scheduled;
	}

	public String getInterview4date() {
		return interview4date;
	}

	public void setInterview4date(String interview4date) {
		this.interview4date = interview4date;
	}

	public String getInterview4time() {
		return interview4time;
	}

	public void setInterview4time(String interview4time) {
		this.interview4time = interview4time;
	}

	public String getInterview4panelist() {
		return interview4panelist;
	}

	public void setInterview4panelist(String interview4panelist) {
		this.interview4panelist = interview4panelist;
	}

	public String getInterview4url() {
		return interview4url;
	}

	public void setInterview4url(String interview4url) {
		this.interview4url = interview4url;
	}

	public String getInterview4remarks() {
		return interview4remarks;
	}

	public void setInterview4remarks(String interview4remarks) {
		this.interview4remarks = interview4remarks;
	}

	public Boolean getIsinterview4cleared() {
		return isinterview4cleared;
	}

	public void setIsinterview4cleared(Boolean isinterview4cleared) {
		this.isinterview4cleared = isinterview4cleared;
	}

	public Boolean getIsinterview4over() {
		return isinterview4over;
	}

	public void setIsinterview4over(Boolean isinterview4over) {
		this.isinterview4over = isinterview4over;
	}

	public Boolean getIsinterview4scheduled() {
		return isinterview4scheduled;
	}

	public void setIsinterview4scheduled(Boolean isinterview4scheduled) {
		this.isinterview4scheduled = isinterview4scheduled;
	}

	public String getInterview5date() {
		return interview5date;
	}

	public void setInterview5date(String interview5date) {
		this.interview5date = interview5date;
	}

	public String getInterview5time() {
		return interview5time;
	}

	public void setInterview5time(String interview5time) {
		this.interview5time = interview5time;
	}

	public String getInterview5panelist() {
		return interview5panelist;
	}

	public void setInterview5panelist(String interview5panelist) {
		this.interview5panelist = interview5panelist;
	}

	public String getInterview5url() {
		return interview5url;
	}

	public void setInterview5url(String interview5url) {
		this.interview5url = interview5url;
	}

	public String getInterview5remarks() {
		return interview5remarks;
	}

	public void setInterview5remarks(String interview5remarks) {
		this.interview5remarks = interview5remarks;
	}

	public Boolean getIsinterview5cleared() {
		return isinterview5cleared;
	}

	public void setIsinterview5cleared(Boolean isinterview5cleared) {
		this.isinterview5cleared = isinterview5cleared;
	}

	public Boolean getIsinterview5over() {
		return isinterview5over;
	}

	public void setIsinterview5over(Boolean isinterview5over) {
		this.isinterview5over = isinterview5over;
	}

	public Boolean getIsinterview5scheduled() {
		return isinterview5scheduled;
	}

	public void setIsinterview5scheduled(Boolean isinterview5scheduled) {
		this.isinterview5scheduled = isinterview5scheduled;
	}

	

	

	public Interview() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Interview [id=" + id + ", jobid=" + jobid + ", candidateid=" + candidateid + ", iscandidatescreened="
				+ iscandidatescreened + ", screeningremarks=" + screeningremarks + ", status=" + status
				+ ", statusdesc=" + statusdesc + ", statusid=" + statusid + ", interview1date=" + interview1date
				+ ", interview1time=" + interview1time + ", interview1panelist=" + interview1panelist
				+ ", interview1url=" + interview1url + ", interview1remarks=" + interview1remarks + ", recruiter="
				+ recruiter + ", noofround=" + noofround + ", isinterview1cleared=" + isinterview1cleared
				+ ", isinterview1over=" + isinterview1over + ", isinterview1scheduled=" + isinterview1scheduled
				+ ", interview2date=" + interview2date + ", interview2time=" + interview2time + ", interview2panelist="
				+ interview2panelist + ", interview2url=" + interview2url + ", interview2remarks=" + interview2remarks
				+ ", isinterview2cleared=" + isinterview2cleared + ", isinterview2over=" + isinterview2over
				+ ", isinterview2scheduled=" + isinterview2scheduled + ", interview3date=" + interview3date
				+ ", interview3time=" + interview3time + ", interview3panelist=" + interview3panelist
				+ ", interview3url=" + interview3url + ", interview3remarks=" + interview3remarks
				+ ", isinterview3cleared=" + isinterview3cleared + ", isinterview3over=" + isinterview3over
				+ ", isinterview3scheduled=" + isinterview3scheduled + ", interview4date=" + interview4date
				+ ", interview4time=" + interview4time + ", interview4panelist=" + interview4panelist
				+ ", interview4url=" + interview4url + ", interview4remarks=" + interview4remarks
				+ ", isinterview4cleared=" + isinterview4cleared + ", isinterview4over=" + isinterview4over
				+ ", isinterview4scheduled=" + isinterview4scheduled + ", interview5date=" + interview5date
				+ ", interview5time=" + interview5time + ", interview5panelist=" + interview5panelist
				+ ", interview5url=" + interview5url + ", interview5remarks=" + interview5remarks
				+ ", isinterview5cleared=" + isinterview5cleared + ", isinterview5over=" + isinterview5over
				+ ", isinterview5scheduled=" + isinterview5scheduled + ", ischroroundscheduled=" + ischroroundscheduled
				+ ", chroremarks=" + chroremarks + ", chroapproved=" + chroapproved + ", chrorejected=" + chrorejected
				+ ", chrorounddate=" + chrorounddate + ", chroroundtime=" + chroroundtime + ", chroroundpanelist="
				+ chroroundpanelist + ", chroroundurl=" + chroroundurl + ", chroroundcleared=" + chroroundcleared
				+ ", chroroundover=" + chroroundover + "]";
	}
	
	

}
