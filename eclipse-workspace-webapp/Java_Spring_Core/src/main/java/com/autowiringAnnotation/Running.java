package com.autowiringAnnotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/autowiringAnnotation/AutoAnnoConfig.xml");
		
	 	Emp e1 = (Emp) context.getBean("emp1");
		
	 	System.out.println(e1);
	}
	
}
