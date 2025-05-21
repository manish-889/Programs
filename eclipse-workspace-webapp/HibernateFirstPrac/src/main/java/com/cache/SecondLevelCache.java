package com.cache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.Student;

public class SecondLevelCache {

	public static void main(String[] args) {
	
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		//first Session
		Session session1 = factory.openSession();
		
		Student st1 = session1.get(Student.class, 1);
		System.out.println(st1);
		
		session1.close();
		
		//second session
		Session session2 = factory.openSession();
		
		Student st2 = session2.get(Student.class, 1);
		System.out.println(st2);
		
		session2.close();
		
		factory.close();
	}
	
}
