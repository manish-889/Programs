package org;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class main {

	public static void main(String[] args) {
		
		ApplicationContext con = new ClassPathXmlApplicationContext("application2.xml");
		
		User u = con.getBean("user",User.class);
		u.display();
	}
	
}
