package com.coll.test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.UserDetailDAO;
import com.coll.model.UserDetail;

public class UserDetailTestCase {

	static UserDetailDAO userDetailDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		userDetailDAO = (UserDetailDAO) context.getBean("userDetailDAO");
	}

	@Ignore
	public void registerUserTestCase() {
		UserDetail user = new UserDetail();
		user.setUsername("hmzptl111");
		user.setPassword("123");
		user.setLoginName("Hamza");
		user.setEmailid("hmzptll111@gmail.com");
		user.setMobileno("9769737397");
		user.setRole("ROLE_USER");
		user.setAddress("Mumbai");

		assertTrue("Could not register the user", userDetailDAO.registerUser(user));
	}

	@Ignore
	public void updateUserTestCase() {
		UserDetail user = userDetailDAO.getUser("shbptl222");
		user.setUsername("shbptl121");

		assertTrue("Could not update the user", userDetailDAO.updateProfile(user));
	}

	@Ignore
	public void getUserTestCase() {
		assertNotNull("Could not retrieve user", userDetailDAO.getUser("Shoeb"));
	}

	@Ignore
	public void checkUserTestCase() {
		assertNotNull("Not a valid user", userDetailDAO.checkUserValidation("Hamza", "123"));
	}

	@AfterClass
	public static void closeContext() {
		context.close();
	}

}
