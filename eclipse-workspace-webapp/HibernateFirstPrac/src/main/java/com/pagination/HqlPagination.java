package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hql.Student;

public class HqlPagination {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String query = "from Student";
		Query q = session.createQuery(query);
		
		//implementing the pagination
		q.setFirstResult(1);
		q.setMaxResults(3);
		
		List<Student> list = q.getResultList();
		
		for (Student student : list) {
			System.out.println(student.getStudentId()+" : "+student.getStudent()+" : "+student.getCourse());
		}
		
		
		session.close();
		factory.close();
	}
	
}
