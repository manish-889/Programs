package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.Model.UserModel;
import com.Util.DbConnector;
import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet{
	private UserDao dao;
	private UserModel user;
	
	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		dao = new UserDao(con);
		user = new UserModel();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");
		
		user.setName(uname);
		user.setEmail(email);
		user.setContact(contact);
		user.setPassword(password);
		
		try {
			int i = dao.insertUser(user);
			
			if(i > 0) {
				out.append("User register successfully...");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
