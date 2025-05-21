package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.UserService;

@Controller
public class ContactController {

	@Autowired
	public UserService userService;
	
	@ModelAttribute
	public void commanDataForAllView(Model model) {
		model.addAttribute("Header", "This code written by manish...");
		model.addAttribute("Desc", "Hello everyone...");
	}
	
	@RequestMapping("/contact")
	public String contactUser() {
		return "contact";
	}
	
	@RequestMapping(path =  "/processFrom", method = RequestMethod.POST)
	public String hadle(@ModelAttribute User user,Model model) {

		if(user.getUname().isBlank()) {
			return "redirect:/contact";
		}
		
		this.userService.createUser(user);
		
		return "success";
	}
	
	/*
	@RequestMapping(path =  "/processFrom", method = RequestMethod.POST)
	public String hadle(
			@RequestParam("uname") String uname,
			@RequestParam("email") String uemail,
			@RequestParam("pass") String upass,Model model) {
		
		User user = new User();
		
		user.setUname(uname);
		user.setEmail(uemail);
		user.setPass(upass);
		
		model.addAttribute("uname" , uname);
		model.addAttribute("email" , uemail);
		model.addAttribute("pass" , upass);
		
		System.out.println(user);
		
		model.addAttribute(user);
		
		return "success";
	}*/
}
