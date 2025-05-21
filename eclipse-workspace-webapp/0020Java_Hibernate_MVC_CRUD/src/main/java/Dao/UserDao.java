package Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.User;

public class UserDao {

	SessionFactory sf = null;
	public UserDao() {
		sf = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class).buildSessionFactory();
	}
	
	//Method for adding user to database
	public int addUser(User u) {
		int i = 0;
		
		Transaction tx = null;
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			s.saveOrUpdate(u);
			tx.commit();
			i = 1;
		} catch (Exception e) {
			tx.rollback();
		}
		
		return i;
	}

	//this method of get all user for display
	public List<User> viewAllUsers() {
		
		Session s = sf.openSession();
		
		return s.createQuery("from User").list();
	}

	//this is for delete user details
	public int deleteUser(int id) {
		int i = 0;
		
		Transaction tx = null;
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			s.delete(s.get(User.class, id));
			tx.commit();
			i = 1;
		} catch (Exception e) {
			tx.rollback();
		}
		
		return i;
	}

	//this for get the single users from database
	public User getUserById(int id) {
		User u = null;
		Transaction tx = null;
		try {
			Session s = sf.openSession();
			tx = s.beginTransaction();
			u = s.get(User.class, id);
			tx.commit();
			
		} catch (Exception e) {
			tx.rollback();
		}
		return u;
	}
	
	
	
}
