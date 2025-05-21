package com.OneToOne;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunningPage {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student st1 = new Student();
		st1.setStudent("Manish Giri");
		
		Address add1 = new Address();
		add1.setAddress("Bharuch");
		st1.setAddress(add1);
		
		Student st2 = new Student();
		st2.setStudent("Hariom Tripathi");
		
		Address add2 = new Address();
		add2.setAddress("Kim");
		st2.setAddress(add2);
		
		Student st3 = new Student();
		st3.setStudent("Tarun Tailor");
		
		Address add3 = new Address();
		add3.setAddress("Surat");
		st3.setAddress(add3);
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(st1);
		session.save(st2);
		session.save(st3);
		
		session.save(add1);
		session.save(add2);
		session.save(add3);
		
		tr.commit();
		session.close();
		factory.close();
	}
}
