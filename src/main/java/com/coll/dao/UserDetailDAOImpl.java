package com.coll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.UserDetail;

@SuppressWarnings("deprecation")
@Repository("userDetailDAO")
@Transactional
public class UserDetailDAOImpl implements UserDetailDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public boolean registerUser(UserDetail user) {
		try {
			user.setRole("ROLE_USER");
			sessionFactory.getCurrentSession().save(user);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public boolean updateProfile(UserDetail user) {
		try {
			sessionFactory.getCurrentSession().update(user);
			return true;
		}
		catch(Exception e) {
			return false;
		}
	}

	public UserDetail getUser(String loginname) {
		try {
			UserDetail user = (UserDetail)sessionFactory.getCurrentSession().get(UserDetail.class, loginname);
			return user;
		}
		catch(Exception e) {
			return null;
		}
	}
	
	@SuppressWarnings({ "unchecked" })
	public UserDetail checkUserValidation(String loginName, String password) {
		try {
			Query<UserDetail> query = sessionFactory.getCurrentSession().createQuery("from UserDetail where loginName=:myloginName and password=:mypassword");
			query.setParameter("myloginName", loginName);
			query.setParameter("mypassword", password);
			
			List<UserDetail> listUser = query.list();
			
			if(listUser.size()>0) {
				UserDetail user = listUser.get(0);
				return user;
			}
			else {
				return null;
			}
		}
		catch(Exception e) {
			return null;
		}
	}

}
