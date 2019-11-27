package com.coll.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Blog;

@Repository("blogDAO")
@Transactional
public class BlogDAOImpl implements BlogDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Autowired
	BlogDAO blogDAO;

	public boolean addBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().save(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteBlog(Blog blog) {
		try {
			sessionFactory.getCurrentSession().delete(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean update(Blog blog) {
		try {
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Blog> listBlogs() {
		try {
			return (sessionFactory.getCurrentSession().createQuery("from Blog").list());
		} catch (Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Blog> listApprovedBlogs(){
		try {
			return (sessionFactory.getCurrentSession().createQuery("from Blog where status='A'").list());
		} catch (Exception e) {
			return null;
		}
	}

	public Blog getBlog(int blogId) {
		try {
			return (sessionFactory.getCurrentSession().get(Blog.class, blogId));
		} catch (Exception e) {
			return null;
		}
	}

	public boolean incrementLikes(int blogId) {
		try {
			Blog blog = blogDAO.getBlog(blogId);
			blog.setLikes(blog.getLikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean incrementDisLikes(int blogId) {
		try {
			Blog blog = blogDAO.getBlog(blogId);
			blog.setDislikes(blog.getDislikes() + 1);
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean approveBlog(int blogId) {
		try {
			Blog blog = blogDAO.getBlog(blogId);
			blog.setStatus("A");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean rejectBlog(int blogId) {
		try {
			Blog blog = blogDAO.getBlog(blogId);
			blog.setStatus("NA");
			sessionFactory.getCurrentSession().update(blog);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
