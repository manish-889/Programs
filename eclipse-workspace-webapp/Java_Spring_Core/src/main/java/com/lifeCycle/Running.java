package com.lifeCycle;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Running {

	public static void main(String[] args) {
		
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/lifeCycle/LcConfig.xml");
		context.registerShutdownHook();
		
		Car c = (Car) context.getBean("c1");
		System.out.println(c);
		
		System.out.println("******************************");
		
		Bike b = (Bike) context.getBean("b1");
		System.out.println(b);
	}

}
