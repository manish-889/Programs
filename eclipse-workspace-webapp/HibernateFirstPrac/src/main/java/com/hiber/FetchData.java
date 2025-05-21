package com.hiber;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchData {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		Session session = factory.openSession();
//
//		Student st = (Student) session.load(Student.class, 1);
//
//		System.out.println(st);

		Student st1 = (Student) session.get(Student.class, 1);

		System.out.println(st1);


		session.clear();

	}
}
