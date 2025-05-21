package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.google.gson.Gson;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int uId = Integer.parseInt(req.getParameter("id"));
		String action = req.getParameter("action");
		
		PrintWriter out = resp.getWriter();
		
		if(action.equals("delete")) {
			
			UserDao dao = new UserDao();
			int i = dao.deleteUser(uId);
			
			out.append("User Deleted Successfully...");
		}
		else if(action.equals("edit")) {
			
			UserDao dao = new UserDao();
			
			User user = dao.getUserById(uId);
			
			Gson json = new Gson();
			
			out.append(json.toJson(user));
		}
		
	}
	
}
