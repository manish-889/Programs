package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.model.Student;
import com.service.StudentService;

@Controller
public class InfoContoller {

	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/info")
	public String infoStudent() {
		return "info";
	}
	
	@RequestMapping(path = "/action",method = RequestMethod.POST)
	public String getInfo(@ModelAttribute Student student,Model model) {
		
		this.studentService.createStudent(student);
		
		return "takenInfo";
	}
}
