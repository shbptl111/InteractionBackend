package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Scanner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.BlogDAO;
import com.coll.model.Blog;

public class BlogTestCase {

	static BlogDAO blogDAO;
	static AnnotationConfigApplicationContext context;
	
	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();		
		blogDAO = (BlogDAO)context.getBean("blogDAO");
	}
	
	@Ignore
	public void addBlogTest() {
		Blog blog = new Blog();
		blog.setBlogName("Spring Blog");
		blog.setBlogDesc("This blog is for learning Spring");
		blog.setCreatedate(new java.util.Date());
		blog.setLikes(0);
		blog.setDislikes(0);
		blog.setLoginname("Shoeb");
		blog.setStatus("NA");
		
		assertTrue("Could not add the blog", blogDAO.addBlog(blog));
	}
	
	@Ignore
	public void deleteBlogTest() {
		Blog blog = blogDAO.getBlog(3);
		assertTrue("Could not delete the blog", blogDAO.deleteBlog(blog));
	}
	
	@Ignore
	public void updateBlogTest() {
		Blog blog = blogDAO.getBlog(2);
		blog.setBlogName("JavaScript Blog");
		blog.setBlogDesc("This blog is for JavaScript Learning");
		blog.setCreatedate(new java.util.Date());
		blog.setLikes(5);
		blog.setDislikes(10);
		blog.setLoginname("Shoeb");
		blog.setStatus("NA");
		
		assertTrue("Could not update the blog", blogDAO.update(blog));
	}
	
	@Ignore
	public void listBlogTest() {
		List<Blog> blogList = blogDAO.listBlogs();
		for(Blog blog : blogList) {
			System.out.println(blog.getBlogName());
		}
		assertNotNull(blogDAO.listBlogs());
	}
	
	@Ignore
	public void getBlogTest() {
		assertNotNull(blogDAO.getBlog(952));
	}
	
	@Ignore
	public void incrementLikesBlogTest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Blog ID: ");
		int blogId = sc.nextInt();
		sc.close();
		
		assertTrue("Could not increment likes", blogDAO.incrementLikes(blogId));
	}
	
	@Ignore
	public void incrementDislikesBlogTest() {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter a Blog ID: ");
		int blogId = sc.nextInt();
		sc.close();
		
		assertTrue("Could not increment dislikes", blogDAO.incrementDisLikes(blogId));
	}
	
	@Ignore
	public void approveBlogTestCase() {
		
		assertTrue("Could not approve blog", blogDAO.approveBlog(952));
	}
	
	@Ignore
	public void rejectBlogTestCase() {
		assertTrue("Could not reject blog", blogDAO.rejectBlog(952));
	}
	
	@Ignore
	public void getApprovedBlogsTestCase() {
		List<Blog> blogs = blogDAO.listApprovedBlogs();
		for(Blog blog : blogs) {
			System.out.println(blog.getBlogName());
		}
		assertNotNull(blogDAO.listApprovedBlogs());
	}
	
	@AfterClass
	public static void closeContext() {
		context.close();
	}
	
}