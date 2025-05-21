package com.standaloneCollections;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class Person {

	private List<String> name;
	private Map<String, Integer> course;
	private Properties properties;

	public List<String> getName() {
		return name;
	}

	public void setName(List<String> name) {
		this.name = name;
	}
	
	

	public Map<String, Integer> getCourse() {
		return course;
	}

	public void setCourse(Map<String, Integer> course) {
		this.course = course;
	}
	
	

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", course=" + course + "]";
	}

	
 	
}
