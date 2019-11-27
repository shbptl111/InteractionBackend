package com.coll.dao;

import java.util.List;

import com.coll.model.Job;

public interface JobDAO {

	public boolean postJob(Job job);
	public boolean updateJob(Job job);
	public Job getJob(int jobId);
	public List<Job> listJobDetails();
	
}
