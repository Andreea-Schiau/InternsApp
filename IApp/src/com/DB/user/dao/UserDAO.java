package com.DB.user.dao;

import com.DB.user.model.User;

public interface UserDAO {

	public void insert(User user);
	public User findByUserId(int id);
}
