package com.withoutXML;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JavaConfig {

	@Bean
	public Address getAddress() {
		Address add = new Address();
		return add;
	}
	
	@Bean
	public Student getStudent() {
		Student student = new Student(getAddress());
		return student;
	}
	
	
}
