package com.filter;

import java.io.IOException;

import com.util.RegexUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/reg")
public class RegFilter extends HttpFilter {

	@Override
	protected void doFilter(HttpServletRequest req, HttpServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String pass = req.getParameter("pass");
		String cpass = req.getParameter("cpass");
		
		RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
		
		if(uname==null || uname.equals("")) {
			req.setAttribute("nameErr", "UserName is not blank!!");
			rd.forward(req, resp);
			return;
		}else if(!RegexUtil.nameCheck(uname)) {
			req.setAttribute("nameErr", "Only aplhabet allowed!!");
			rd.forward(req, resp);
			return;
		}
		
		if(email==null || email.equals("")) {
			req.setAttribute("emailErr", "Email is not blank!!");
			rd.forward(req, resp);
			return;
		}else if(!RegexUtil.emailCheck(email)) {
			req.setAttribute("emailErr", "Email format invalid!!");
			rd.forward(req, resp);
			return;
		}
		
		if(pass==null || pass.equals("")) {
			req.setAttribute("passErr", "Password is not blank!!");
			rd.forward(req, resp);
			return;
		}else if(!RegexUtil.passCheck(pass)) {
			req.setAttribute("passErr", "Must contains atleast one uppercase, lowercase, digit and length up to 16 characters");
			rd.forward(req, resp);
			return;
		}
		
		if(!pass.equals(cpass)) {
			req.setAttribute("cpassErr", "Password mismatch!!");
			rd.forward(req, resp);
			return;
		}
		
		chain.doFilter(req, resp);
	}
	
}
