package com.servlet;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/otp")
public class OtpServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String mOtp = req.getParameter("otp");
		
		ServletContext context = req.getServletContext();
		String otp =  (String) context.getAttribute("otp");
		
		if(mOtp.equals(otp)) {
			resp.sendRedirect("home.jsp");
		}else {
			req.setAttribute("msg", "Otp mismatch");
			req.getRequestDispatcher("otp.jsp").forward(req, resp);
		}
	}
	
}
