package com.coll.dao;

import java.util.List;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

public interface FriendDAO {

	public boolean sendFriendRequest(Friend friend);
	public boolean acceptFriendRequest(int friendId);
	public boolean deleteFriendRequest(int friendId);
	public List<Friend> showFriendList(String loginname);
	public List<Friend> showPendingFriendRequest(String loginname);
	public List<UserDetail> showSuggestFriend(String loginname);
}
