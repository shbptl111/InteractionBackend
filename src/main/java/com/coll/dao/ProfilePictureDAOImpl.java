package com.coll.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.ProfilePicture;

@Repository("profilePictureDAO")
@Transactional
public class ProfilePictureDAOImpl implements ProfilePictureDAO {

	@Autowired
	SessionFactory sessionFactory;
	
	public void save(ProfilePicture profilePicture) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(profilePicture);
		/*session.flush();
		session.getTransaction().commit();*/ // Try removing this part
	}

	public ProfilePicture getProfilePicture(String loginname) {
		Session session = sessionFactory.openSession();
		ProfilePicture profilePicture = (ProfilePicture)session.get(ProfilePicture.class, loginname);
		return profilePicture;
	}

}
