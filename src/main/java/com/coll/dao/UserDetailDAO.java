package com.coll.dao;

import com.coll.model.UserDetail;

public interface UserDetailDAO {

	public boolean registerUser(UserDetail user);
	public boolean updateProfile(UserDetail user);
	public UserDetail getUser(String loginname);
	public UserDetail checkUserValidation(String loginName, String password);
}
