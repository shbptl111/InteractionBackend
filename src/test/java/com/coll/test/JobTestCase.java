package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.JobDAO;
import com.coll.model.Job;

public class JobTestCase {

	static JobDAO jobDetailDAO;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		jobDetailDAO = (JobDAO)context.getBean("jobDetailDAO");
	}
	
	@Ignore
	public void addJob() {
		Job job = new Job();
		job.setDesignation("JAVA Programmer");
		job.setJobdesc("A wonderful job for a JAVA Programmer");
		job.setCompanyName("NIIT");
		job.setSalary(20000);
		job.setExpiryDate(new Date());
		job.setExperience(5);
		job.setSkills("Must have in-depth knowledge of JAVA");
		
		assertTrue("Could not post job", jobDetailDAO.postJob(job));
	}
	
	@Ignore
	public void updateJob() {
		
		Job job = jobDetailDAO.getJob(952);
		job.setExperience(3);
		
		assertNotNull("Could not update the job", jobDetailDAO.updateJob(job));
	}
	
	@Ignore
	public void getJob() {
		assertNotNull("Could not retrieve the job", jobDetailDAO.getJob(952));
	}
	
	@Ignore
	public void listJobs() {
		assertNotNull("Could not list the jobs", jobDetailDAO.listJobDetails());
	}
	
	@AfterClass
	public static void closeContext() {
		context.close();
	}
}
