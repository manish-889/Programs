package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class SearchController {

	@RequestMapping("/home")
	public String searchThing() {
		return "home";
	}
	
	@RequestMapping("/search")
	public RedirectView search(@RequestParam("queryBox") String query) {
		
		String url = "https://www.google.com/search?q="+query;
		
		RedirectView redirectView = new RedirectView();
		
		redirectView.setUrl(url);
		return redirectView;
	}
}
