package com;

import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class MyIntercepter implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		System.out.println("This is PreHandler...");
	
		String name = request.getParameter("name");
		
		if(name.startsWith("m")) {
			response.setContentType("text/html");
			response.getWriter().println("Invalid Name....");
			
			return false;
		}
		
		return true;
	}
	
}
