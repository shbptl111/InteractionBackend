package com.coll.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table
public class ApplyingJob {

	@Id
	@SequenceGenerator(name="myApplyingJobSeq", sequenceName="applyingJobSeq")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="myApplyingJobSeq")
	int applyJobId;
	
	int jobId;
	String loginName;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	Date appliedDate;
	
	public int getApplyJobId() {
		return applyJobId;
	}
	public void setApplyJobId(int applyJobId) {
		this.applyJobId = applyJobId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public Date getAppliedDate() {
		return appliedDate;
	}
	public void setAppliedDate(Date appliedDate) {
		this.appliedDate = appliedDate;
	}
	
}
