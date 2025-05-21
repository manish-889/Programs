package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ReController {

	@RequestMapping("/one")
	public String pageOne() {
		System.out.println("One number handler is calling...");
		return "redirect:/two";
	}
	
	@RequestMapping("/two")
	public RedirectView pageTwo() {
		System.out.println("Two number handler is calling...");
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl("one");
		return redirectView;
	}
	
}
