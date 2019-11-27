package com.coll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.BlogComment;

@SuppressWarnings("deprecation")
@Repository("blogCommentDAO")
@Transactional
public class BlogCommentDAOImpl implements BlogCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addComment(BlogComment comment) {
		try {
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean deleteComment(BlogComment comment) {
		try {
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public BlogComment getBlogComment(int blogCommentId) {
		try {
			return (sessionFactory.getCurrentSession().get(BlogComment.class, blogCommentId));
		}
		catch(Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<BlogComment> listBlogComments(int blogId) {
		try {
			Query<BlogComment> query = sessionFactory.getCurrentSession().createQuery("from BlogComment where BlogId=:bId");
			query.setParameter("bId", blogId);
			List<BlogComment> listComments = query.list();
			return listComments;
		}
		catch(Exception e) {
			return null;
		}
		
	}
	
}
