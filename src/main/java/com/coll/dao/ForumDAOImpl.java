package com.coll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Forum;

@SuppressWarnings({ "deprecation", "unused" })
@Repository("forumDAO")
@Transactional
public class ForumDAOImpl implements ForumDAO {

	@Autowired
	SessionFactory sessionFactory;

	public boolean addForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().save(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean deleteForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().delete(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean updateForum(Forum forum) {
		try {
			sessionFactory.getCurrentSession().update(forum);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Forum getForum(int forumId) {
		try {
			return (sessionFactory.getCurrentSession().get(Forum.class, forumId));
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Forum> listForums() {
		try {
			return (sessionFactory.getCurrentSession().createQuery("from Forum").list());
		} catch (Exception e) {
			return null;
		}
	}

}
