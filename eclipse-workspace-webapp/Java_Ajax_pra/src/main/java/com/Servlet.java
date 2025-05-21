package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/postData")
public class Servlet extends HttpServlet{
	
	private static final String URL = "jdbc:mysql://localhost:3306/ajax";
	private static final String username = "root";
	private static final String pass ="manishgiri";

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("value");

		PrintWriter pw = resp.getWriter();
		
		String str= "";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(URL, username, pass);
			
			String sql = "SELECT * FROM listProduct WHERE productName like '"+name+"%' ";
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			str += "<ul>";
			while(rs.next()) {
				System.out.println(rs.getString(2));
				
				str += "<li>"+rs.getString(2)+"</li>";
			}
			str += "</ul>";
			
			pw.append(str);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
		
	}
	
}
