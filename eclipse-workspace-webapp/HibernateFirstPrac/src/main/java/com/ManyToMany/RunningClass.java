package com.ManyToMany;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunningClass {
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Employee emp1 = new Employee();
		Employee emp2 = new Employee();
		emp1.setEmpId(23);
		emp1.setEmpName("Manish");
		emp2.setEmpId(56);
		emp2.setEmpName("Hariom");
		
		Project pro1 = new Project();
		Project pro2 = new Project();
		pro1.setProjectId(101);
		pro1.setProjectName("Job Portal");
		pro2.setProjectId(102);
		pro2.setProjectName("Car Rental");
		
		List<Employee> list1 = new ArrayList<Employee>();
		List<Project> list2 = new ArrayList<Project>();
		
		list1.add(emp1);
		list1.add(emp2);
		
		list2.add(pro1);
		list2.add(pro2);
		
		emp1.setProjects(list2);
		pro2.setEmps(list1);
		
		Session session = factory.openSession();
		
		Transaction tr = session.beginTransaction();
		
		session.save(emp1);
		session.save(emp2);
		session.save(pro1);
		session.save(pro2);
		
		tr.commit();
		session.close();
		factory.close();
		
	}
}
