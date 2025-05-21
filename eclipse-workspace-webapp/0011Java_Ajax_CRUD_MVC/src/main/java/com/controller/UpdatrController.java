package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdatrController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("uid"));
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		
		User user = new User();
		user.setId(id);
		user.setUname(uname);
		user.setEmail(email);
		user.setPhone(phone);

		UserDao dao = new UserDao();
		
		int i = dao.updateUser(user);
		PrintWriter out = resp.getWriter();
		
		out.append("Done");
	}
	
}
