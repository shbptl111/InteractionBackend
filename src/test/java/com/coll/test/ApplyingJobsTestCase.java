package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ApplyingJobDAO;
import com.coll.model.ApplyingJob;

public class ApplyingJobsTestCase {

	static ApplyingJobDAO applyingJobDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		applyingJobDAO = (ApplyingJobDAO) context.getBean("applyingJobDAO");
	}

	@Ignore
	public void addApplyingJob() {
		ApplyingJob apply = new ApplyingJob();
		apply.setAppliedDate(new Date());
		apply.setJobId(1);
		apply.setLoginName("Hamza");

		assertTrue("Could not add applyjob", applyingJobDAO.addApplyingJob(apply));
	}

	@Ignore
	public void updateApplyingJob() {
		ApplyingJob apply = applyingJobDAO.getApplyingJob(952);
		apply.setAppliedDate(new Date());

		assertTrue("Could not update the applyjob", applyingJobDAO.updateApplyingJob(apply));
	}

	@Ignore
	public void getApplyingJob() {
		assertNotNull("Could not get the applyjob", applyingJobDAO.getApplyingJob(952));
	}

	@Ignore
	public void deleteApplyingJob() {
		ApplyingJob job = applyingJobDAO.getApplyingJob(952);
		assertTrue("Could not delete applyjob", applyingJobDAO.deleteApplyingJob(job));
	}

	@Ignore
	public void listApplyingJob() {
		assertNotNull("Could not retrieve list of ApplyingJob", applyingJobDAO.listAppliedJobs());
	}

	@AfterClass
	public static void closeContext() {
		context.close();
	}
}
