package com.coll.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.ForumComment;

@Repository("forumCommentDAO")
@Transactional
public class ForumCommentDAOImpl implements ForumCommentDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addForumComment(ForumComment comment) {
		try {
			sessionFactory.getCurrentSession().save(comment);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public ForumComment getForumComment(int commentId) {
		try {
			return (sessionFactory.getCurrentSession().get(ForumComment.class, commentId));
		}
		catch(Exception e) {
			return null;
		}
	}

	public boolean deleteForumComment(ForumComment comment) {
		try {
			sessionFactory.getCurrentSession().delete(comment);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	@SuppressWarnings("unchecked")
	public List<ForumComment> listComments() {
		try {
			return (sessionFactory.getCurrentSession().createQuery("from ForumComment").list());
		}
		catch(Exception e) {
			return null;
		}
	}

}
