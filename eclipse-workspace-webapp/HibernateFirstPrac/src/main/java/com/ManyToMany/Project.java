package com.ManyToMany;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {
		
	@Id
	private int projectId;
	private String projectName;
	
	@ManyToMany
	private List<Employee> emps;

	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(int projectId, String projectName, List<Employee> emps) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.emps = emps;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}
	
}
