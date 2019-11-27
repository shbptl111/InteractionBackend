package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.ForumCommentDAO;
import com.coll.model.ForumComment;

public class ForumCommentTestCase {

	static ForumCommentDAO forumCommentDAO;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		forumCommentDAO = (ForumCommentDAO)context.getBean("forumCommentDAO");
	}
	
	@Ignore
	public void addForumComment() {
		ForumComment comment = new ForumComment();
		comment.setCommentDate(new Date());
		comment.setCommentText("visit: https://www.baeldung.com/spring-channel-security-https");
		comment.setForumId(1);
		comment.setLoginName("Khalid");
		
		assertTrue("Could not add comment to the forum comment", forumCommentDAO.addForumComment(comment));
	}
	
	@Ignore
	public void getForumComment() {
		assertNotNull("Could not retrieve the forum comment", forumCommentDAO.getForumComment(951));
	}
	
	@Ignore
	public void deleteForumComment() {
		ForumComment comment = forumCommentDAO.getForumComment(951);
		assertTrue("Could not delete the forum comment", forumCommentDAO.deleteForumComment(comment));
	}
	
	@Ignore
	public void listForumComment() {
		assertNotNull("Could not delete the forum comment", forumCommentDAO.listComments());
	}
	
	@AfterClass
	public static void closeContext() {
		context.close();
	}
	
}
