package com.coll.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.coll.model.Friend;
import com.coll.model.UserDetail;

@SuppressWarnings("deprecation")
@Repository("friendDAO")
@Transactional
public class FriendDAOImpl implements FriendDAO {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public boolean sendFriendRequest(Friend friend) {
		try {
			friend.setStatus("P");
			sessionFactory.getCurrentSession().save(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@Transactional
	public boolean acceptFriendRequest(int friendId) {
		try {
			Friend friend = getFriend(friendId);
			friend.setStatus("A");
			sessionFactory.getCurrentSession().update(friend);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public Friend getFriend(int friendId) {
		return (sessionFactory.getCurrentSession().get(Friend.class, friendId));
	}

	public boolean deleteFriendRequest(int friendId) {
		try {
			sessionFactory.getCurrentSession().delete(getFriend(friendId));
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Friend> showFriendList(String loginname) {
		try {
			Query<Friend> query = sessionFactory.getCurrentSession().createQuery(
					"from Friend where (loginname=:myloginname or friendloginname=:friendlogin) and status='A'");
			query.setParameter("myloginname", loginname);
			query.setParameter("friendlogin", loginname);
			List<Friend> listFriends = (List<Friend>) query.list();
			return listFriends;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<Friend> showPendingFriendRequest(String loginname) {
		try {
			Query<Friend> query = sessionFactory.getCurrentSession()
					.createQuery("from Friend where loginname=:mylogin and status='P'");
			query.setParameter("mylogin", loginname);
			List<Friend> listFriends = query.list();
			return listFriends;
		} catch (Exception e) {
			return null;
		}
	}

	@SuppressWarnings({ "unchecked" })
	public List<UserDetail> showSuggestFriend(String loginname) {
		try {
			Query<UserDetail> query = sessionFactory.getCurrentSession()
					.createQuery("from UserDetail where loginname!=:myloginname");
			query.setParameter("myloginname", loginname);
			List<UserDetail> listUsers = query.list();
			List<Friend> tempUsers = showFriendList(loginname);

			for (int i = 0; i < listUsers.size(); i++) {
				for (int j = 0; j < tempUsers.size(); j++) {
					if (tempUsers.get(j).getFriendLoginName().equals(listUsers.get(i).getLoginName()))
						listUsers.remove(listUsers.get(i));
				}
			}

			return listUsers;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
	}

}
