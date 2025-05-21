package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentDetails {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Student st1 = new Student();
		st1.setId(1);
		st1.setName("Manish Giri");
		st1.setCity("Bharuch");
		
		Certificate c1 = new Certificate();
		c1.setCourse("Java");
		c1.setDuration("8 months");
		
		st1.setCerti(c1);
		
		Student st2 = new Student();
		st2.setId(2);
		st2.setName("Hariom Tripathi");
		st2.setCity("Kim");
		
		Certificate c2 = new Certificate();
		c2.setCourse("Python");
		c2.setDuration("6 months");
		
		st2.setCerti(c2);

		Student st3 = new Student();
		st3.setId(3);
		st3.setName("Tarun Tailor");
		st3.setCity("Surat");
		
		Certificate c3 = new Certificate();
		c3.setCourse("Cyber");
		c3.setDuration("1.5 Year");
		
		st3.setCerti(c3);
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(st1);
		session.save(st2);
		session.save(st3);
		
		tr.commit();
		
		factory.close();
		
	}
}
