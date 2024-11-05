package com.ats.ATS.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApplicantDTO {

	private String candidateid;
	private String status;
	private Integer interviewid;
	private String jobid;
	private String desc;
	
}
