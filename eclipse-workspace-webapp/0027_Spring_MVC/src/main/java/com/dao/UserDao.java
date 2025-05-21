package com.dao;

import java.util.List;

import com.model.User;

public interface UserDao {

	public void addOrUpdateUser(User u);
	public List<User> viewUsers();
	public void deleteUser(int id);
	public User getUserById(int id);
	
	
}
