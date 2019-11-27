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

public class FriendTestCase {

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
	public void sendFriendRequestTestCase() {
		Friend friend = new Friend();
		friend.setFriendLoginName("Hamza");
		friend.setLoginName("Khalid");
		assertTrue("Could not add friend", friendDAO.sendFriendRequest(friend));
	}

	@Ignore
	public void deleteFriendRequestTestCase() {
		assertTrue("Could not delete friend", friendDAO.deleteFriendRequest(976));
	}

	@Ignore
	public void acceptFriendRequestTestCase() {
		assertTrue("Could not accept the friend request", friendDAO.acceptFriendRequest(1));
	}

	@Ignore
	public void showFriendListTestCase() {
		List<Friend> listFriends = friendDAO.showFriendList("shbptl222");

		if (listFriends == null) {
			System.out.println("listFriends object is null");
		}

		for (Friend friend : listFriends) {
			System.out.print(friend.getLoginName() + "    ");
			System.out.print(friend.getFriendLoginName() + "    ");
			System.out.print(friend.getStatus());
			System.out.println();
		}

		assertTrue("Problem in getting the friend list", listFriends.size() > 0);

	}

	@Ignore
	public void showPendingFriendRequestTestCase() {
		List<Friend> listFriends = friendDAO.showPendingFriendRequest("shbptl222");

		for (Friend friend : listFriends) {
			System.out.print(friend.getLoginName() + "    ");
			System.out.print(friend.getFriendLoginName() + "    ");
			System.out.println(friend.getStatus());
		}

		assertTrue("Problem in getting the list", listFriends.size() > 0);
	}

	@Ignore
	public void showSuggestFriendTestCase() {
		List<UserDetail> listFriends = friendDAO.showSuggestFriend("shbptl222");
		assertTrue("Could not get the list", listFriends.size() > 0);
	}

	@AfterClass
	public static void closeContext() {
		context.close();
	}
}
