package com.ats.ATS.model;

import java.util.Arrays;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "applicant")
@lombok.Data
public class ApplicantData {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "userId")
	private int id;
	
	@Column(name = "encryptedid")
	  private String encryptedid;
	
	@Column(name = "jobid")
	private String jobid;
	
	@Column(name = "applicantName")
	private String name;
	
	@Column(name = "mobileNumber")
	private String mobNo;
	
	@Column(name = "DOB")
	private String dob;
	
	@Column(name = "Gender")
	private String gender;
	
	@Column(unique = true)
	private String emailId; 
	
	@Column(name = "experience")
	private String experience;
	
	@Column(name = "department")
	private String department;
	
	@Column(name = "source")
	private String source;
	
	@Column(name = "noticePeriod")
	private String noticePeriod;
	
	@Column(name = "resumename")
	private String resumename;
	
	@Column(name = "presentsalary")
	private String presentsalary;
	
	@Column(name = "expectedsalary")
	private String expectedsalary;
	
	@Column(name = "changereason")
	private String changereason;
	
	@Column(name = "is_approved")
  private Boolean is_approved;
	 
	@Column(name = "is_remarks")
	private String is_remarks;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "isofferreleased")
	  private Boolean isofferreleased;
	
	@Column(name = "statusdesc")
	private String statusdesc;
	
	@Column(name = "interviewpanel")
	private String interviewpanel;
	
	@Column(name = "statusid")
	private Integer statusid;
	
	@Column(name = "accepteddate")
	private Date accepteddate;
	
	@Column(name = "is_interviewonescheduled")
	  private Boolean is_interviewonescheduled;
	
	@Column(name = "is_selected")
	  private Boolean is_selected;
	
	@Column(name = "iscandidaterejected")
	  private Boolean iscandidaterejected;
	
	@Column(name = "docpath")
	  private String docpath;
	
	@Column(name = "LOI")
	  private String LOI;
	
	@Column(name = "offerlettername")
	  private String offerlettername;
	
	@Column(name = "isemailsent")
	  private Boolean isemailsent;
	
	@Column(name = "docsubmitted")
	  private Boolean docsubmitted;
	
	@Column(name = "aredocsapproved")
	  private Boolean aredocsapproved;
	
	@Column(name = "aredocsrejected")
	  private Boolean aredocsrejected;
	
	@Column(name = "offerreleaseforapproval")
	  private Boolean offerreleaseforapproval;
	
	@Column(name = "offerapprovedbymanager")
	  private Boolean offerapprovedbymanager;
	
	@Column(name = "offerrejectedbymanager")
	  private Boolean offerrejectedbymanager;
	
	@Column(name = "offerapprovedbychro")
	  private Boolean offerapprovedbychro;
	
	@Column(name = "offerrejectedbychro")
	  private Boolean offerrejectedbychro;
	
	@Column(name = "isoffersentbyhrops")
	  private Boolean isoffersentbyhrops;
	
	@Column(name = "isloiaccepted")
	  private Boolean isloiaccepted;
	
	@Column(name = "isloirejected")
	  private Boolean isloirejected;
	
	@Column(name = "loirejectedreason")
	  private String loirejectedreason;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSource() {
		return source;
	}
	
	

	public Date getAccepteddate() {
		return accepteddate;
	}

	public void setAccepteddate(Date accepteddate) {
		this.accepteddate = accepteddate;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getStatusdesc() {
		return statusdesc;
	}

	public void setStatusdesc(String statusdesc) {
		this.statusdesc = statusdesc;
	}
	
	

	public Boolean getIscandidaterejected() {
		return iscandidaterejected;
	}

	public void setIscandidaterejected(Boolean iscandidaterejected) {
		this.iscandidaterejected = iscandidaterejected;
	}

	public Integer getStatusid() {
		return statusid;
	}

	public void setStatusid(Integer statusid) {
		this.statusid = statusid;
	}

	@Transient
	private MultipartFile resume;
	
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

	

	public String getInterviewpanel() {
		return interviewpanel;
	}

	public void setInterviewpanel(String interviewpanel) {
		this.interviewpanel = interviewpanel;
	}

	public String getResumename() {
		return resumename;
	}

	public void setResumename(String resumename) {
		this.resumename = resumename;
	}

	public MultipartFile getResume() {
		return resume;
	}

	public void setResume(MultipartFile resume) {
		this.resume = resume;
	}


	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}
	
	

	public Boolean getIs_selected() {
		return is_selected;
	}

	public void setIs_selected(Boolean is_selected) {
		this.is_selected = is_selected;
	}

	public Boolean getIs_interviewonescheduled() {
		return is_interviewonescheduled;
	}

	public void setIs_interviewonescheduled(Boolean is_interviewonescheduled) {
		this.is_interviewonescheduled = is_interviewonescheduled;
	}

	public String getNoticePeriod() {
		return noticePeriod;
	}

	public void setNoticePeriod(String noticePeriod) {
		this.noticePeriod = noticePeriod;
	}
	
	

	
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public Boolean getIs_approved() {
		return is_approved;
	}

	public void setIs_approved(Boolean is_approved) {
		this.is_approved = is_approved;
	}

	public String getIs_remarks() {
		return is_remarks;
	}

	public void setIs_remarks(String is_remarks) {
		this.is_remarks = is_remarks;
	}
	public String getDocpath() {
		return docpath;
	}

	public void setDocpath(String docpath) {
		this.docpath = docpath;
	}

	

	public String getEncryptedid() {
		return encryptedid;
	}

	public void setEncryptedid(String encryptedid) {
		this.encryptedid = encryptedid;
	}

	public Boolean getIsemailsent() {
		return isemailsent;
	}

	public void setIsemailsent(Boolean isemailsent) {
		this.isemailsent = isemailsent;
	}

	

	public Boolean getDocsubmitted() {
		return docsubmitted;
	}

	public void setDocsubmitted(Boolean docsubmitted) {
		this.docsubmitted = docsubmitted;
	}

	

	public Boolean getAredocsapproved() {
		return aredocsapproved;
	}

	public void setAredocsapproved(Boolean aredocsapproved) {
		this.aredocsapproved = aredocsapproved;
	}

	

	public Boolean getAredocsrejected() {
		return aredocsrejected;
	}

	public void setAredocsrejected(Boolean aredocsrejected) {
		this.aredocsrejected = aredocsrejected;
	}

	

	public Boolean getOfferreleaseforapproval() {
		return offerreleaseforapproval;
	}

	public void setOfferreleaseforapproval(Boolean offerreleaseforapproval) {
		this.offerreleaseforapproval = offerreleaseforapproval;
	}

	public Boolean getOfferapprovedbymanager() {
		return offerapprovedbymanager;
	}

	public void setOfferapprovedbymanager(Boolean offerapprovedbymanager) {
		this.offerapprovedbymanager = offerapprovedbymanager;
	}

	public Boolean getOfferrejectedbymanager() {
		return offerrejectedbymanager;
	}

	public void setOfferrejectedbymanager(Boolean offerrejectedbymanager) {
		this.offerrejectedbymanager = offerrejectedbymanager;
	}

	public Boolean getOfferapprovedbychro() {
		return offerapprovedbychro;
	}

	public void setOfferapprovedbychro(Boolean offerapprovedbychro) {
		this.offerapprovedbychro = offerapprovedbychro;
	}

	public Boolean getOfferrejectedbychro() {
		return offerrejectedbychro;
	}

	public void setOfferrejectedbychro(Boolean offerrejectedbychro) {
		this.offerrejectedbychro = offerrejectedbychro;
	}

	

	public String getLOI() {
		return LOI;
	}

	public void setLOI(String LOI) {
		this.LOI = LOI;
	}

	
	public Boolean getIsoffersentbyhrops() {
		return isoffersentbyhrops;
	}

	public void setIsoffersentbyhrops(Boolean isoffersentbyhrops) {
		this.isoffersentbyhrops = isoffersentbyhrops;
	}

	


	public ApplicantData() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ApplicantData(int id, String encryptedid, String jobid, String name, String mobNo, String dob, String gender,
			String emailId, String experience, String department, String source, String noticePeriod, String resumename,
			String presentsalary, String expectedsalary, String changereason, Boolean is_approved, String is_remarks,
			String status, String statusdesc, String interviewpanel, Integer statusid, Date accepteddate,
			Boolean is_interviewonescheduled, Boolean is_selected, Boolean iscandidaterejected, String docpath,
			String lOI, String offerlettername, Boolean isemailsent, Boolean docsubmitted, Boolean aredocsapproved,
			Boolean aredocsrejected, Boolean offerreleaseforapproval, Boolean offerapprovedbymanager,
			Boolean offerrejectedbymanager, Boolean offerapprovedbychro, Boolean offerrejectedbychro,
			Boolean isoffersentbyhrops, MultipartFile resume) {
		super();
		this.id = id;
		this.encryptedid = encryptedid;
		this.jobid = jobid;
		this.name = name;
		this.mobNo = mobNo;
		this.dob = dob;
		this.gender = gender;
		this.emailId = emailId;
		this.experience = experience;
		this.department = department;
		this.source = source;
		this.noticePeriod = noticePeriod;
		this.resumename = resumename;
		this.presentsalary = presentsalary;
		this.expectedsalary = expectedsalary;
		this.changereason = changereason;
		this.is_approved = is_approved;
		this.is_remarks = is_remarks;
		this.status = status;
		this.statusdesc = statusdesc;
		this.interviewpanel = interviewpanel;
		this.statusid = statusid;
		this.accepteddate = accepteddate;
		this.is_interviewonescheduled = is_interviewonescheduled;
		this.is_selected = is_selected;
		this.iscandidaterejected = iscandidaterejected;
		this.docpath = docpath;
		LOI = lOI;
		this.offerlettername = offerlettername;
		this.isemailsent = isemailsent;
		this.docsubmitted = docsubmitted;
		this.aredocsapproved = aredocsapproved;
		this.aredocsrejected = aredocsrejected;
		this.offerreleaseforapproval = offerreleaseforapproval;
		this.offerapprovedbymanager = offerapprovedbymanager;
		this.offerrejectedbymanager = offerrejectedbymanager;
		this.offerapprovedbychro = offerapprovedbychro;
		this.offerrejectedbychro = offerrejectedbychro;
		this.isoffersentbyhrops = isoffersentbyhrops;
		this.resume = resume;
	}
	
	
}
