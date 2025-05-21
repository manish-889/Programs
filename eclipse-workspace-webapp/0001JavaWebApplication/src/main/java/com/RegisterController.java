package com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class RegisterController
 */


public class RegisterController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("uname");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");

		// System.out.println(name);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletPage", "root",
					"manishgiri");

			String sql = "INSERT INTO user (name, email, contact, password) VALUES (?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, contact);
			stmt.setString(4, password);

			int result = stmt.executeUpdate();

			if (result > 0) {
				PrintWriter out = resp.getWriter();
				out.write("Register Servlet...");
				
				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
				dispatcher.forward(req, resp);
				
//				System.out.println("Record inserted successfully");
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
