package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.ArrayList;

import com.Model.UserModel;
import com.Util.DbConnector;
import com.dao.UserDao;
import com.google.gson.Gson;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userList")
public class UserListServlet extends HttpServlet{
	
	private UserDao dao;
	
	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		dao = new UserDao(con);
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PrintWriter out = resp.getWriter();
		ArrayList<UserModel> users = dao.getUserList();
		
		Gson gson = new Gson();
		
		String jsonResponse  = gson.toJson(users);
		
		out.append(jsonResponse);
	}
}
