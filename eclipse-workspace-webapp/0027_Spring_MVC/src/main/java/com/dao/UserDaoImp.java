package com.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.model.User;

@Transactional
@Repository
public class UserDaoImp implements UserDao {

	@Autowired
	SessionFactory sf;
	
	@Override
	public void addOrUpdateUser(User u) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		s.saveOrUpdate(u);
		
		tx.commit();
	}

	@Override
	public List<User> viewUsers() {
		Session s = sf.openSession();
		return s.createQuery("from User").list();
	}

	@Override
	public void deleteUser(int id) {
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		User u = s.get(User.class, id);
		s.delete(u);
		tx.commit();
	}

	@Override
	public User getUserById(int id) {
		Session s = sf.openSession();
		User u = s.get(User.class, id);
		return u;
	}

	
	
}
