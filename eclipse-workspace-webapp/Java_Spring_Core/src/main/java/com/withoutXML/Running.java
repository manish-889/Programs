package com.withoutXML;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student st1 = (Student) context.getBean("getStudent");
		
		System.out.println(st1);
		
		st1.study();
	}
	
}
