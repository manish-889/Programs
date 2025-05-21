package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;


import com.Util.DbConnector;
import com.dao.UserDao;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class UserEditServlet extends HttpServlet{
	private UserDao dao;
	
	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		dao = new UserDao(con);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		PrintWriter out = resp.getWriter();
		try {
			HashMap<String , Object> map = dao.editRecord(id);
			
			Gson gson = new Gson();
			
			String jsonString = gson.toJson(map);
			
			out.append(jsonString);
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
