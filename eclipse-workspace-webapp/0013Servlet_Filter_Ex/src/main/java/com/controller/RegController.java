package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/reg")
public class RegController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String cpass = req.getParameter("cpass");

		PrintWriter out = resp.getWriter();
		out.write("<h1>" + uname + "</h1>");
		out.write("<h1>" + email + "</h1>");
		out.write("<h1>" + pass + "</h1>");
		out.write("<h1>" + cpass + "</h1>");

	}

}
