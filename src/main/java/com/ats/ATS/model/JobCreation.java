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
@Table(name = "job_creation")
@Data
public class JobCreation {
               
               @Id
               @GeneratedValue(strategy = GenerationType.IDENTITY)
               @Column(name = "id")
               private int id;
               
               @Column(name = "request_position_name")
               private String request_position_name;
               
               @Column(name = "no_of_position")
               private int no_of_position;
               
               @Column(name = "department")
               private String department;
               
               @Column(name = "department_id")
               private String department_id;
               
               @Column(name = "requesterId")
               private String requesterId;
               
               @Column(name = "designation")
               private String designation;
               
               @Column(name = "designation_id")
               private String designation_id;
               
               @Column(name = "location")
               private String location;   

               @Column(name = "department_name")
               private String department_name;
               
               @Column(name = "requestedby")
               private String requestedby;
               
               @Column(name = "project_name")
               private String project_name;
               
               @Column(name = "working_days")
               private int working_days;
               
               @Column(name = "experience")
               private String experience;
               
               @Column(name = "experiencemax")
               private String experiencemax;
               
               @Column(name = "specific_skills")
               private String specific_skills;
               
               @Column(name = "educational_qualifications")
               private String educational_qualifications ;            

               @Column(name = "reporting_manager")
               private String reporting_manager;
               
               @Column(name = "reporting_manager2")
               private String reporting_manager2;
               
               
               @Column(name = "round")
               private String round ;
               
               @Column(name = "round1")
               private String round1;
               
               @Column(name = "round2")
               private String round2;
               
               @Column(name = "round3")
               private String round3;
               
               @Column(name = "round4")
               private String round4;
               
               @Column(name = "round5")
               private String round5;

             
               
               @Column(name = "job_responsibility")
               private String job_responsibility ;             

               @Column(name = "it_nonit_assets")
               private String it_nonit_assets;
               
               @Column(name = "tat")
               private String tat;
               
               @Column(name = "salary_range")
               private String salary_range;
               
               @Column(name = "note")
               private String note;
               
               @Column(name = "requestername")
               private String requestername;
               
               @Column(name = "status")
               private String status;
               
               @Column(name = "status_id")
               private String status_id;
               
               @Column(name = "statusdesc")
               private String statusdesc;
               
               @Column(name = "created_date")
               private Date created_date;
               
               @Column(name = "chro_remarks")
               private String chro_remarks;
               
               @Column(name = "band")
               private String band;
               
               @Column(name = "priority")
               private String priority;
               
               @Column(name = "hod_remarks")
               private String hod_remarks; 

               @Column(name = "isacceptedbyhod")
               private Boolean isacceptedbyhod;
               
               @Column(name = "isacceptedbychro")
               private Boolean isacceptedbychro;
               
               @Column(name = "hiringmanager")
               private String hiringmanager;
               
               @Column(name = "recruiter")
               private String recruiter;
               
               @Column(name = "isassignedtorecruitor")
               private Boolean isassignedtorecruitor;
               
               
               @Column(name = "chroaccepted_date")
               private Date chroaccepted_date;
               
               @Column(name = "rmaccepted_date")
               private Date rmaccepted_date;
               
               
               @Column(name = "target_date")
               private Date target_date;
               
               public String getHiringmanager() {
				return hiringmanager;
			}

			public void setHiringmanager(String hiringmanager) {
				this.hiringmanager = hiringmanager;
			}
			
			

			public Date getChroaccepted_date() {
				return chroaccepted_date;
			}

			public void setChroaccepted_date(Date chroaccepted_date) {
				this.chroaccepted_date = chroaccepted_date;
			}

			public Date getRmaccepted_date() {
				return rmaccepted_date;
			}

			public void setRmaccepted_date(Date rmaccepted_date) {
				this.rmaccepted_date = rmaccepted_date;
			}

			public String getChro_remarks() {
                              return chro_remarks;
               }

               public void setChro_remarks(String chro_remarks) {
                              this.chro_remarks = chro_remarks;
               }
               
               

               public Boolean getIsassignedtorecruitor() {
				return isassignedtorecruitor;
			}

			public void setIsassignedtorecruitor(Boolean isassignedtorecruitor) {
				this.isassignedtorecruitor = isassignedtorecruitor;
			}

			public String getRecruiter() {
				return recruiter;
			}

			public void setRecruiter(String recruiter) {
				this.recruiter = recruiter;
			}
			
			

			public String getRound4() {
				return round4;
			}

			public void setRound4(String round4) {
				this.round4 = round4;
			}

			public String getRound5() {
				return round5;
			}

			public void setRound5(String round5) {
				this.round5 = round5;
			}

			public String getHod_remarks() {
                              return hod_remarks;
               }

               public void setHod_remarks(String hod_remarks) {
                              this.hod_remarks = hod_remarks;
               }

               public Boolean getIsacceptedbyhod() {
                              return isacceptedbyhod;
               }

               public void setIsacceptedbyhod(Boolean isacceptedbyhod) {
                              this.isacceptedbyhod = isacceptedbyhod;
               }

               public Boolean getIsacceptedbychro() {
                              return isacceptedbychro;
               }

               public void setIsacceptedbychro(Boolean isacceptedbychro) {
                              this.isacceptedbychro = isacceptedbychro;
               }

               public String getRound1() {
                              return round1;
               }

               public void setRound1(String round1) {
                              this.round1 = round1;
               }

               public String getRound2() {
                              return round2;
               }

               public void setRound2(String round2) {
                              this.round2 = round2;
               }

               public String getRound3() {
                              return round3;
               }

               public void setRound3(String round3) {
                              this.round3 = round3;
               }

               public String getReporting_manager2() {
                              return reporting_manager2;
               }

               public void setReporting_manager2(String reporting_manager2) {
                              this.reporting_manager2 = reporting_manager2;
               }

               public String getStatus() {
                              return status;
               }

               public void setStatus(String status) {
                              this.status = status;
               }

               public String getStatus_id() {
                              return status_id;
               }

               public void setStatus_id(String status_id) {
                              this.status_id = status_id;
               }

               public String getStatusdesc() {
                              return statusdesc;
               }

               public void setStatusdesc(String statusdesc) {
                              this.statusdesc = statusdesc;
               }

               public String getDepartment_id() {
                              return department_id;
               }

               public void setDepartment_id(String department_id) {
                              this.department_id = department_id;
               }

               public String getDesignation_id() {
                              return designation_id;
               }

               public void setDesignation_id(String designation_id) {
                              this.designation_id = designation_id;
               }

               public String getRequestername() {
                              return requestername;
               }

               public void setRequestername(String requestername) {
                              this.requestername = requestername;
               }

               public String getRequesterId() {
                              return requesterId;
               }

               public void setRequesterId(String requesterId) {
                              this.requesterId = requesterId;
               }

               public String getRequestedby() {
                              return requestedby;
               }

               public void setRequestedby(String requestedby) {
                              this.requestedby = requestedby;
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

               public int getId() {
                              return id;
               }

               public void setId(int id) {
                              this.id = id;
               }

               public String getRequest_position_name() {
                              return request_position_name;
               }

               public void setRequest_position_name(String request_position_name) {
                              this.request_position_name = request_position_name;
               }

               public int getNo_of_position() {
                              return no_of_position;
               }

               public void setNo_of_position(int no_of_position) {
                              this.no_of_position = no_of_position;
               }

               public String getLocation() {
                              return location;
               }

               public void setLocation(String location) {
                              this.location = location;
               }

               public String getDepartment_name() {
                              return department_name;
               }

               public void setDepartment_name(String department_name) {
                              this.department_name = department_name;
               }

               public String getProject_name() {
                              return project_name;
               }

               public void setProject_name(String project_name) {
                              this.project_name = project_name;
               }

               public int getWorking_days() {
                              return working_days;
               }

               public void setWorking_days(int working_days) {
                              this.working_days = working_days;
               }

               

               public String getExperience() {
                              return experience;
               }

               public void setExperience(String experience) {
                              this.experience = experience;
               }

               public String getSpecific_skills() {
                              return specific_skills;
               }

               public void setSpecific_skills(String specific_skills) {
                              this.specific_skills = specific_skills;
               }

               public String getEducational_qualifications() {
                              return educational_qualifications;
               }

               public void setEducational_qualifications(String educational_qualifications) {
                              this.educational_qualifications = educational_qualifications;
               }

               public String getReporting_manager() {
                              return reporting_manager;
               }

               public void setReporting_manager(String reporting_manager) {
                              this.reporting_manager = reporting_manager;
               }

             

               public String getRound() {
                              return round;
               }

               public void setRound(String round) {
                              this.round = round;
               }

               public String getJob_responsibility() {
                              return job_responsibility;
               }

               public void setJob_responsibility(String job_responsibility) {
                              this.job_responsibility = job_responsibility;
               }

               public String getIt_nonit_assets() {
                              return it_nonit_assets;
               }

               public void setIt_nonit_assets(String it_nonit_assets) {
                              this.it_nonit_assets = it_nonit_assets;
               }

               public String getTat() {
                              return tat;
               }

               public void setTat(String tat) {
                              this.tat = tat;
               }

               public String getSalary_range() {
                              return salary_range;
               }

               public void setSalary_range(String salary_range) {
                              this.salary_range = salary_range;
               }
               
               

               public String getExperiencemax() {
				return experiencemax;
			}

			public void setExperiencemax(String experiencemax) {
				this.experiencemax = experiencemax;
			}

			public String getBand() {
				return band;
			}

			public void setBand(String band) {
				this.band = band;
			}

			public String getPriority() {
				return priority;
			}

			public void setPriority(String priority) {
				this.priority = priority;
			}

			public String getNote() {
                              return note;
               }

               public void setNote(String note) {
                              this.note = note;
               }

               public Date getCreated_date() {
                              return created_date;
               }

               public void setCreated_date(Date created_date) {
                              this.created_date = created_date;
               }

			

			public Date getTarget_date() {
				return target_date;
			}

			public void setTarget_date(Date target_date) {
				this.target_date = target_date;
			}

			

			public JobCreation(int id, String request_position_name, int no_of_position, String department,
					String department_id, String requesterId, String designation, String designation_id,
					String location, String department_name, String requestedby, String project_name, int working_days,
					String experience, String experiencemax, String specific_skills, String educational_qualifications,
					String reporting_manager, String reporting_manager2, String round, String round1, String round2,
					String round3, String round4, String round5,  String job_responsibility,
					String it_nonit_assets, String tat, String salary_range, String note, String requestername,
					String status, String status_id, String statusdesc, Date created_date, String chro_remarks,
					String band, String priority, String hod_remarks, Boolean isacceptedbyhod, Boolean isacceptedbychro,
					String hiringmanager, String recruiter, Boolean isassignedtorecruitor, Date chroaccepted_date,
					Date rmaccepted_date, Date target_date) {
				super();
				this.id = id;
				this.request_position_name = request_position_name;
				this.no_of_position = no_of_position;
				this.department = department;
				this.department_id = department_id;
				this.requesterId = requesterId;
				this.designation = designation;
				this.designation_id = designation_id;
				this.location = location;
				this.department_name = department_name;
				this.requestedby = requestedby;
				this.project_name = project_name;
				this.working_days = working_days;
				this.experience = experience;
				this.experiencemax = experiencemax;
				this.specific_skills = specific_skills;
				this.educational_qualifications = educational_qualifications;
				this.reporting_manager = reporting_manager;
				this.reporting_manager2 = reporting_manager2;
				this.round = round;
				this.round1 = round1;
				this.round2 = round2;
				this.round3 = round3;
				this.round4 = round4;
				this.round5 = round5;
				this.job_responsibility = job_responsibility;
				this.it_nonit_assets = it_nonit_assets;
				this.tat = tat;
				this.salary_range = salary_range;
				this.note = note;
				this.requestername = requestername;
				this.status = status;
				this.status_id = status_id;
				this.statusdesc = statusdesc;
				this.created_date = created_date;
				this.chro_remarks = chro_remarks;
				this.band = band;
				this.priority = priority;
				this.hod_remarks = hod_remarks;
				this.isacceptedbyhod = isacceptedbyhod;
				this.isacceptedbychro = isacceptedbychro;
				this.hiringmanager = hiringmanager;
				this.recruiter = recruiter;
				this.isassignedtorecruitor = isassignedtorecruitor;
				this.chroaccepted_date = chroaccepted_date;
				this.rmaccepted_date = rmaccepted_date;
				this.target_date = target_date;
			}

			@Override
			public String toString() {
				return "JobCreation [id=" + id + ", request_position_name=" + request_position_name
						+ ", no_of_position=" + no_of_position + ", department=" + department + ", department_id="
						+ department_id + ", requesterId=" + requesterId + ", designation=" + designation
						+ ", designation_id=" + designation_id + ", location=" + location + ", department_name="
						+ department_name + ", requestedby=" + requestedby + ", project_name=" + project_name
						+ ", working_days=" + working_days + ", experience=" + experience + ", experiencemax="
						+ experiencemax + ", specific_skills=" + specific_skills + ", educational_qualifications="
						+ educational_qualifications + ", reporting_manager=" + reporting_manager
						+ ", reporting_manager2=" + reporting_manager2 + ", round=" + round + ", round1=" + round1
						+ ", round2=" + round2 + ", round3=" + round3 + ", round4=" + round4 + ", round5=" + round5
						+ ", job_responsibility=" + job_responsibility + ", it_nonit_assets="
						+ it_nonit_assets + ", tat=" + tat + ", salary_range=" + salary_range + ", note=" + note
						+ ", requestername=" + requestername + ", status=" + status + ", status_id=" + status_id
						+ ", statusdesc=" + statusdesc + ", created_date=" + created_date + ", chro_remarks="
						+ chro_remarks + ", band=" + band + ", priority=" + priority + ", hod_remarks=" + hod_remarks
						+ ", isacceptedbyhod=" + isacceptedbyhod + ", isacceptedbychro=" + isacceptedbychro
						+ ", hiringmanager=" + hiringmanager + ", recruiter=" + recruiter + ", isassignedtorecruitor="
						+ isassignedtorecruitor + ", chroaccepted_date=" + chroaccepted_date + ", rmaccepted_date="
						+ rmaccepted_date + ", target_date=" + target_date + "]";
			}

			public JobCreation() {
				super();
				// TODO Auto-generated constructor stub
			}

              

       
               

}
