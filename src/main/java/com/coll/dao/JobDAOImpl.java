package com.coll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Job;

@SuppressWarnings("deprecation")
@Repository("jobDetailDAO")
@Transactional
public class JobDAOImpl implements JobDAO {
	
	@Autowired
	SessionFactory sessionFactory;

	public boolean postJob(Job job) {
		try {
			sessionFactory.getCurrentSession().save(job);			
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateJob(Job job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Job> listJobDetails() {
		try {
			Session session = sessionFactory.getCurrentSession();
			Query<Job> query = session.createQuery("from Job");
			List<Job> listJobs = query.list();
			return listJobs;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	public Job getJob(int jobId) {
		try {
			Session session = sessionFactory.getCurrentSession();
			Job job = session.get(Job.class, jobId);
			return job;
		}
		catch(Exception e) {
			return null;
		}
		
	}

}
