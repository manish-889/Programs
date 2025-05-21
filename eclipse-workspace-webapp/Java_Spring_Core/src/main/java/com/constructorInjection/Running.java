package com.constructorInjection;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/constructorInjection/ConInjConfig.xml");
		Person p = (Person) context.getBean("p1");
		
		System.out.println(p);
	}
	
}
