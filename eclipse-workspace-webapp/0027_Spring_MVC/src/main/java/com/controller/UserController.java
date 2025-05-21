package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.model.User;
import com.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService service;

	@RequestMapping("/")
	public String index(Model m) {
		User u = new User();
		m.addAttribute("user", u);
		m.addAttribute("view", service.viewUsers());
		return "index";
	}

	@PostMapping("/addUser")
	public String addUser(@ModelAttribute("user") User u) {

		service.addOrUpdateUser(u);

		return "redirect:/";
	}

	@GetMapping("/delete")
	public String deleteUser(@RequestParam("did") int id) {
		service.deleteUser(id);
		return "redirect:/";
	}

	@GetMapping("/edit")
	public String updateUser(@RequestParam("uid") int id, Model m) {
		User u = service.getUserById(id);
		System.out.println(u.getId()+" "+u.getName());
		m.addAttribute("user", u);
		m.addAttribute("view", service.viewUsers());
		return "index";
	}

}
