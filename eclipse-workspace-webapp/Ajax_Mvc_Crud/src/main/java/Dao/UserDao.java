package Dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import Model.User;

public class UserDao {

	SessionFactory sf = null;
	public UserDao() {
		sf = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(User.class)
				.buildSessionFactory();
	}
	
	public int addUser(User u) {
		int i =0;
		try {
			Session s = sf.openSession();
			Transaction tx = s.beginTransaction();
			
			s.saveOrUpdate(u);
			
			tx.commit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return i;
	}

	public List<User> viewUser() {
		List<User> al = new ArrayList<User>();
		
		try {
			Session s = sf.openSession();
			
			al = s.createQuery("from User").list();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return al;
	}

	public int deleteUser(int id) {
		int i = 0;
	
		Session s = sf.openSession();
		Transaction tx  = s.beginTransaction();
		
		User U = s.get(User.class, id);
		s.delete(U);
		
		tx.commit();
		i =1;
		
		return i;
	}

	public User getUserById(int id) {
		User u = new User();
		
		Session s = sf.openSession();
		u = s.get(User.class, id);
		
		return u;
	}
	
}
