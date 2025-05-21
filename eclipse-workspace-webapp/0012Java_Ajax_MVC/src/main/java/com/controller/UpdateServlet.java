package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.Model.UserModel;
import com.Util.DbConnector;
import com.dao.UserDao;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet{
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
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");
		
		user.setId(id);
		user.setName(name);
		user.setEmail(email);
		user.setContact(contact);
		user.setPassword(password);
		
		PrintWriter out = resp.getWriter();
		
		try {
			int rs = dao.updateRecord(user);
			
			if(rs > 0) {
				
				List<UserModel> users = dao.getUserList();
				Gson gson = new Gson();
				
				String jsonResponse  = gson.toJson(users);
				
				out.append(jsonResponse);
			}else{
				System.out.println("Something went wrong");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
