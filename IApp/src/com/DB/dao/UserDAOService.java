package com.DB.dao;

import java.util.List;

import com.DB.model.User;

public interface UserDAOService {

	public boolean insert(User user);
	public User findById(int id);
	public List<User> getAll();
}
