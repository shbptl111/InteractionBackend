package com.coll.test;

import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.coll.dao.FriendDAO;
import com.coll.model.Friend;
import com.coll.model.UserDetail;

public class FriendDAOTestCase {

	static FriendDAO friendDAO;
	static AnnotationConfigApplicationContext context;

	@BeforeClass
	public static void setUp() {
		context = new AnnotationConfigApplicationContext();
		context.scan("com.coll");
		context.refresh();
		friendDAO = (FriendDAO) context.getBean("friendDAO");
	}

	@Ignore
	public void showFriendListTestCase() {
		List<Friend> listFriends = friendDAO.showFriendList("Khalid");
		assertTrue("Problem in getting the friend list", listFriends.size() > 0);
		for (Friend friend : listFriends) {
			System.out.println(friend.getFriendLoginName());
		}
	}

	@Ignore
	public void sendPendingFriendRequestTestCase() {
		List<Friend> listFriends = friendDAO.showPendingFriendRequest("shbptl222");
		assertTrue("Problem in getting the friend list", listFriends.size() > 0);
		for (Friend friend : listFriends) {
			System.out.println(friend.getFriendLoginName());
		}
	}

	@Ignore
	public void sendFriendRequestTestCase() {
		Friend friend = new Friend();
		friend.setLoginName("shbptl222");
		friend.setFriendLoginName("Shahbaaz");
		assertTrue("Could not send request", friendDAO.sendFriendRequest(friend));
	}

	@Ignore
	public void acceptFriendRequestTestCase() {
		assertTrue("Could not accept request", friendDAO.acceptFriendRequest(978));
	}

	@Ignore
	public void deleteFriendRequestTestCase() {
		assertTrue("Could not delete the request", friendDAO.deleteFriendRequest(979));
	}

	@Ignore
	public void showSuggestFriendTestCase() {
		List<UserDetail> listFriends = friendDAO.showSuggestFriend("shbptl222");
		assertTrue("Could not retrieve the list", friendDAO.showSuggestFriend("shbptl222").size() > 0);
		for (UserDetail user : listFriends) {
			System.out.println(user.getUsername());
		}
	}

	@AfterClass
	public static void closeContext() {
		context.close();
	}
}
