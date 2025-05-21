package com.SqlQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

public class SqlExample {

	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		Session session = factory.openSession();
		
		String sql = "select * from student";
		NativeQuery nq = session.createNativeQuery(sql);
		
		List<Object[]> list = nq.list();
		
		for (Object[] objects : list) {
			System.out.println(objects[0]+" : "+objects[1]+" : "+objects[2]);
		}
		
		session.close();
		factory.close();
	}
	
}
