package com.standaloneCollections;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/standaloneCollections/alone.xml");
		
		Person p = (Person) context.getBean("p1");
		
		System.out.println(p.getName());
		System.out.println(p.getName().getClass().getName());
		System.out.println("******************************************");
		
		System.out.println(p.getCourse());
		System.out.println(p.getCourse().getClass().getName());
		System.out.println("******************************************");
		
		System.out.println(p.getProperties());
		System.out.println(p.getProperties().getClass().getName());
		System.out.println("******************************************");
	}
	
}
