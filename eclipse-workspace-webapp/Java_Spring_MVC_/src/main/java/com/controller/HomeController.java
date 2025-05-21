package com.controller;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String home(Model model) {
		System.out.println("this is home url...");
		
		model.addAttribute("name", "Manish");
		
		model.addAttribute("number", 24);
		
		List<String> list = new ArrayList<String>();
		list.add("Hariom");
		list.add("Rohit");
		list.add("Akash");
		
		model.addAttribute("name" ,list);
		
		return "index";
	}
	
	@RequestMapping("/help")
	public ModelAndView help() {
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("name","Manish");
		modelAndView.addObject("id",12);
		
		LocalDateTime now = LocalDateTime.now();
		modelAndView.addObject("now",now);
		
		modelAndView.setViewName("help");
		return modelAndView;
	}
	
}
