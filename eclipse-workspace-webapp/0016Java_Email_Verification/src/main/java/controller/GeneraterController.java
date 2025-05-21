package controller;

import java.io.IOException;
import java.util.Random;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import util.EmailSender;

@WebServlet("/verification")
public class GeneraterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		
		Random ran = new Random();
		int otp = ran.nextInt(1000,9999);
		
		EmailSender.send(email, "For OTP Verification Purpose.", "Your OTP is : "+otp);
		
		ServletContext con = getServletContext();
		
		con.setAttribute("GeneratedOtp", otp);
		
		req.getRequestDispatcher("verify.jsp").forward(req, resp);
		
		
	}
	
}
