package ContextCongig;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet
public class Servlet1 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		out.write("This is Servlet 1....");
			
		ServletContext context = getServletContext();
		String h = context.getInitParameter("url");
		String h1 = context.getInitParameter("Driver");
		out.write(h+" "+h1);
	}
}
