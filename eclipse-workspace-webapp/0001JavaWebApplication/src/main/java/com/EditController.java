package com;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.HashMap;

import com.mysql.cj.xdevapi.Result;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servletPage", "root",
					"manishgiri");

			String sql = "SELECT *FROM user WHERE id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);
			

			ResultSet rs = stmt.executeQuery();

			if (rs.next()) {
				HashMap<String, Object> map = new HashMap<String, Object>();
				
				map.put("id", rs.getInt("id"));
				map.put("name", rs.getString("name"));
				map.put("email", rs.getString("email"));
				map.put("contact", rs.getString("contact"));
				map.put("password", rs.getString("password"));
				
				req.setAttribute("data", map);
				
				
				req.getRequestDispatcher("update.jsp").forward(req, resp);
			} else {
				System.out.println("Something went wrong");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
