package filter;

import java.io.IOException;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import utils.AppUtils;

@WebFilter("/register")
public class RegisterFilter extends HttpFilter{
	@Override
	protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String name = request.getParameter("uname");
		String email = request.getParameter("email");
		String contact = request.getParameter("contact");
		String password = request.getParameter("password");
		String cpassword = request.getParameter("cpassword");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerFilterPage.jsp");
		
		if(name == null || name.isEmpty()) {
			request.setAttribute("nameErr", "Fill the Name Field");
			dispatcher.forward(request, response);
			return;
		}else if (!AppUtils.nameValidation(name)) {
			request.setAttribute("nameErr", "Name field cann't Number!!!");
			dispatcher.forward(request, response);
			return;
		}
		if(email == null || email.isEmpty()) {
			request.setAttribute("emailErr", "Fill the Email Field");
			dispatcher.forward(request, response);
			return;
		}else if (!AppUtils.emailValidation(email)) {
			request.setAttribute("emailErr", "Invalid email address");
			dispatcher.forward(request, response);
			return;
		}
		if(contact == null || contact.isEmpty()) {
			request.setAttribute("contactErr", "Fill the Contact Field");
			dispatcher.forward(request, response);
			return;
		}else if (!AppUtils.contactValidation(contact)) {
			request.setAttribute("contactErr", "Contact should be of 10 digits");
			dispatcher.forward(request, response);
			return;
		}
		if(password == null || password.isEmpty()) {
			request.setAttribute("passwordErr", "Fill the password Field");
			dispatcher.forward(request, response);
			return;
		}else if (!AppUtils.passwordValidation(password)) {
			request.setAttribute("passwordErr", "Must contains atleast one uppercase, lowercase, digit and length up to 16 characters");
			dispatcher.forward(request, response);
			return;
		}
		if(!password.equals(cpassword)) {
			request.setAttribute("cpasswordErr", "Password mismatch.");
			dispatcher.forward(request, response);
			return;
		}
		
		chain.doFilter(request, response);
	}
}
