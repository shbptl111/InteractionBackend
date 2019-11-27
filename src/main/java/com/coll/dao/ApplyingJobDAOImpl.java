package com.coll.dao;


import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.ApplyingJob;

@Repository("applyingJobDAO")
@Transactional
public class ApplyingJobDAOImpl implements ApplyingJobDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addApplyingJob(ApplyingJob job) {
		try {
			sessionFactory.getCurrentSession().save(job);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateApplyingJob(ApplyingJob job) {
		try {
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean deleteApplyingJob(ApplyingJob job) {
		try {
			sessionFactory.getCurrentSession().delete(job);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public ApplyingJob getApplyingJob(int applyJobId) {
		try {
			return (sessionFactory.getCurrentSession().get(ApplyingJob.class, applyJobId));
		}
		catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<ApplyingJob> listAppliedJobs() {
		try {
			return (sessionFactory.getCurrentSession().createQuery("from ApplyingJob").list());
		}
		catch(Exception e) {
			return null;
		}
	}

}
