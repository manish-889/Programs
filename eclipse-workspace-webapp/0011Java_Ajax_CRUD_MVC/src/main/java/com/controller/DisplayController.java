package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import com.dao.UserDao;
import com.google.gson.Gson;
import com.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Display")
public class DisplayController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao dao = new UserDao();
		
		ArrayList<User> al = dao.diplayUser();
		
		Gson json = new Gson();
		
		PrintWriter out = resp.getWriter();
		
		out.append(json.toJson(al));
	}
	
}
