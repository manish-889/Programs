package com;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class main {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext cx = new AnnotationConfigApplicationContext(App.class);
		
		Account a = cx.getBean("savingAccount",Account.class);
		a.deposite();
		
	}
	
}
