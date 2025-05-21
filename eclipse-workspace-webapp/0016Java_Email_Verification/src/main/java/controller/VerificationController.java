package controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/verifyOtp")
public class VerificationController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int inputOtp = Integer.parseInt(req.getParameter("inOtp"));
		
		Integer generatedOtp = (Integer) getServletContext().getAttribute("GeneratedOtp");
		
		if(inputOtp==generatedOtp) {
			req.getRequestDispatcher("home.jsp").forward(req, resp);
		}else {
			req.setAttribute("Invaild Otp, Please Check It...", "errMsg");
			req.getRequestDispatcher("verify.jsp").forward(req, resp);
		}
		
	}
	
}
