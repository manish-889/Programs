package com.beanScope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/beanScope/Scope.xml");
		
		//Doing prototype by annotation
//		Person p1 =(Person) context.getBean("p1");
//		System.out.println(p1.hashCode());
//		
//		Person p2 =(Person) context.getBean("p1");
//		System.out.println(p2.hashCode());
		
		Job j1 = (Job) context.getBean("j1");
		System.out.println(j1.hashCode());
		
		Job j2 = (Job) context.getBean("j1");
		System.out.println(j2.hashCode());
	}
	
}
