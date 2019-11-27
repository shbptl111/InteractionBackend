package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogCommentDAO;
import com.coll.model.BlogComment;

public class BlogCommentTestCase {

	static BlogCommentDAO blogCommentDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();

		blogCommentDAO = (BlogCommentDAO) context.getBean("blogCommentDAO");
	}

	@Ignore
	public void addBlogCommentTestCase() {

		BlogComment blogComment = new BlogComment();
		blogComment.setCommentText("Very nice blog");
		blogComment.setLoginName("Hamza");
		blogComment.setCommentDate(new Date());
		blogComment.setBlogId(1);

		assertTrue("Could not add the comment", blogCommentDAO.addComment(blogComment));
	}

	@Ignore
	public void deleteBlogCommentTestCase() {

		BlogComment blogComment = blogCommentDAO.getBlogComment(954);

		assertTrue("Could not delete the comment", blogCommentDAO.deleteComment(blogComment));
	}

	@Ignore
	public void getBlogCommentTestCase() {

		assertNotNull("Could not retrieve comment", blogCommentDAO.getBlogComment(952));

	}

	@Ignore
	public void getCommentListTestCase() {
		assertNotNull("Could not retrieve comment list", blogCommentDAO.listBlogComments(952));
	}

	@AfterClass
	public static void closeContext() {
		context.close();
	}

}
