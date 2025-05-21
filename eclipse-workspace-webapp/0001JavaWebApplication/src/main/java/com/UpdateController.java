package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String contact = req.getParameter("contact");
		String password = req.getParameter("password");

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletPage", "root",
					"manishgiri");

			String sql = "UPDATE user SET name = ?,  email = ?, contact = ?, password = ? WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, name);
			stmt.setString(2, email);
			stmt.setString(3, contact);
			stmt.setString(4, password);
			stmt.setInt(5, id);

			int result = stmt.executeUpdate();

			if (result > 0) {
//				RequestDispatcher dispatcher = req.getRequestDispatcher("home.jsp");
//				dispatcher.forward(req, resp);
				resp.sendRedirect("home.jsp");			} 
			else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
