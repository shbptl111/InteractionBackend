package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumDAO;
import com.coll.model.Forum;

public class ForumTestCase {
	
	static ForumDAO forumDAO;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		
		forumDAO = (ForumDAO)context.getBean("forumDAO");
	}
	
	@Ignore
	public void addForum() {
		Forum forum = new Forum();
		forum.setForumName("Problem with Spring Security");
		forum.setForumContent("How to use https channel in Spring MVC webapp?");
		forum.setCreateDate(new Date());
		forum.setLoginName("Hamza");
		forum.setStatus("NA");
		
		assertTrue("Could not add the forum", forumDAO.addForum(forum));
	}
	
	@Ignore
	public void deleteForum() {
		Forum forum = forumDAO.getForum(951);
		
		assertTrue("Could not delete the forum", forumDAO.deleteForum(forum));
	}
	
	@Ignore
	public void updateForum() {
		Forum forum = forumDAO.getForum(952);
		
		forum.setForumName("JavaScript Forum");
		
		assertTrue("Could not update the forum", forumDAO.updateForum(forum));
	}
	
	@Ignore
	public void getForum() {
		assertNotNull("Could not retrieve the forum", forumDAO.getForum(952));
	}
	
	@Ignore
	public void listForums() {
		assertNotNull("Could not retrieve the forum list", forumDAO.listForums());
	}
	
	@AfterClass
	public static void closeContext() {
		context.close();
	}

}
