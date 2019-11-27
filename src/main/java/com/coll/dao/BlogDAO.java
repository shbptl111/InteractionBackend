package com.coll.dao;

import java.util.List;

import com.coll.model.Blog;

public interface BlogDAO {

	public boolean addBlog(Blog blog);
	public boolean deleteBlog(Blog blog);
	public boolean update(Blog blog);
	public List<Blog> listBlogs();
	public List<Blog> listApprovedBlogs();
	public Blog getBlog(int blogId);
	public boolean incrementLikes(int blogId);
	public boolean incrementDisLikes(int blogId);
	public boolean approveBlog(int blogId);
	public boolean rejectBlog(int blogId);
	
}
