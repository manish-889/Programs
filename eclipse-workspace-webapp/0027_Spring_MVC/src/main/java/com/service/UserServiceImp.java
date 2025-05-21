package com.service;

import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.UserDao;
import com.model.User;

@Service
public class UserServiceImp implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	public void addOrUpdateUser(User u) {
		// TODO Auto-generated method stub
		dao.addOrUpdateUser(u);
	}

	@Override
	public List<User> viewUsers() {
	
	
		return dao.viewUsers();
	}

	@Override
	public void deleteUser(int id) {
		dao.deleteUser(id);
	}

	@Override
	public User getUserById(int id) {
		User u = dao.getUserById(id);
		return u;
	}

}
