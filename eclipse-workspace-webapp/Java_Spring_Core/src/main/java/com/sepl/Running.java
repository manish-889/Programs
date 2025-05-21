package com.sepl;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

public class Running {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/sepl/sepl.xml");
		Student s = (Student) context.getBean("student");
		
		System.out.println(s);
		
		SpelExpressionParser el = new SpelExpressionParser();
		Expression expression = el.parseExpression("22+5");
		
		System.out.println(expression);
	}
	
}
