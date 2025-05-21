package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HqlQuery {
	/**
	 * @param args
	 */
	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure().buildSessionFactory();

		// :-Setting all data into the student object Student st1 = new Student();

//		Student st1 = new Student();
//		  st1.setStudent("Manish Giri"); st1.setCourse("Java");
//		  
//		  Student st2 = new Student();
//		  
//		  st2.setStudent("Hariom Tripathi"); st2.setCourse("Java");
//		  
//		  Student st3 = new Student();
//		  
//		  st3.setStudent("Tarun Tailor"); st3.setCourse("Python");
//
//		Student st1 = new Student();
//		st1.setStudent("Guptaji");
//		st1.setCourse("Full Satck");
//
//		Student st2 = new Student();
//		st2.setStudent("Giri");
//		st2.setCourse("React");

		Session session = factory.openSession();

		// for putting all data in database
//		Transaction tran = session.beginTransaction();
//		
//		session.save(st1);
//		session.save(st2);
//				
//		tran.commit();

		// HQL
		/*
		 * this is for getting a multiple record so we use the list(getresultlist())
		 * String query = "from Student"; Query q = session.createQuery(query);
		 * 
		 * List<Student> list = q.getResultList();
		 * 
		 * for (Student student : list) {
		 * System.out.println(student.getStudent()+" : "+student.getCourse()); }
		 */

		// for getting a single record so we use the unique

		// for getting a dynamic value
//		String query = "from Student where course=:x";
//		Query q = session.createQuery(query);
//		q.setParameter("x", "Java");
//
//		List<Student> list = q.getResultList();
//
//		for (Student student : list) {
//			System.out.println(student.getStudent() );
//		}

		// Delete Query
//		Transaction tran = session.beginTransaction();
//
//		String query = "delete from Student where course =: x";
//		Query q = session.createQuery(query);
//		
//		q.setParameter("x", "React");
//		int num = q.executeUpdate();
//		
//		System.out.println(num + " object deleted!!");
//		
//		String query = "update Student set course=:c where student=:s";
//		Query q = session.createQuery(query);
//		q.setParameter("c", "Career Path");
//		q.setParameter("s", "Tarun Tailor");
//		
//		int num = q.executeUpdate();
//		
//		System.out.println(num +" object Updated successfully....");
//		tran.commit();
		
		//How to execute joins query 
		String query = "select q.question, a.answer from Question as q INNER JOIN q.answer as a";
		Query q = session.createQuery(query);
		
		List<Object []> list = q.getResultList();
		
		for (Object[] objects : list) {
			System.out.println(Arrays.toString(objects));
		}
		session.close();
	}
}
