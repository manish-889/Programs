package com;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

	@RequestMapping("/home")
	public String callingHome() {
		return "home";
	}
	
	@RequestMapping("/welcome")
	public String goingToWelcome(@RequestParam("name") String name,Model m) {
		
		m.addAttribute("name", name);
		return "welcome";
	}
	
}
