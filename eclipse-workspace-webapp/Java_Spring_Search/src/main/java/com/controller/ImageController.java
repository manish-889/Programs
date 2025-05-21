package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ImageController {

	@RequestMapping("/img")
	public String showUploadIamge() {
		return "fileform";
	}
	
}
