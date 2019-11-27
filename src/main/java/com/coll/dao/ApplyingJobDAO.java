package com.coll.dao;

import java.util.List;

import com.coll.model.ApplyingJob;

public interface ApplyingJobDAO {

	public boolean addApplyingJob(ApplyingJob job);
	public boolean updateApplyingJob(ApplyingJob job);
	public boolean deleteApplyingJob(ApplyingJob job);
	public ApplyingJob getApplyingJob(int applyJobId);
	public List<ApplyingJob> listAppliedJobs();
	
}
