package com.referenceType;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/referenceType/RefConfig.xml");
		
		A a =(A) context.getBean("aref");
		System.out.println(a);
		
		System.out.println(a.getOb().toString());
	}
	
}
