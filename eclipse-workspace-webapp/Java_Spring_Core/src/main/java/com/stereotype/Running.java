package com.stereotype;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/stereotype/stereoConfig.xml");
		
		Person p  =(Person) context.getBean("person");
		
		System.out.println(p);
		
		System.out.println(p.getState());
		System.out.println(p.getState().getClass().getName());
	}
	
}
