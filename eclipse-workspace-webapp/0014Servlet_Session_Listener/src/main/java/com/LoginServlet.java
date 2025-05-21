package com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String pass = req.getParameter("pass");
		
		if(uname.equals("manish") && pass.equals("m")) {
			
			HttpSession session = req.getSession(false);
			
			session.setAttribute("uname",uname);
			session.setAttribute("p",pass);
			req.getRequestDispatcher("home.jsp").forward(req, resp);
			
		}else {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
	
}
