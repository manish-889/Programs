package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.dao.AjaxDao;
import com.util.DbConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {

	private static final String USER = "root";
	private static final String PASS = "manishgiri";
	private static final String URL = "jdbc:mysql://localhost:3306/nameDb";

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("value");

		PrintWriter out = resp.getWriter();
		// out.append("<b>"+name+"</b>");

//		if(name.equalsIgnoreCase("Electronic")) {
//			out.append("<ul><li>Fan</li><li>Light</li><li>A.C</li><li>Computer</li><li>Phone</li></ul>");
//		}else if(name.equalsIgnoreCase("Food")) {
//			out.append("<ul><li>Vada Pav</li><li>Samosa</li><li>Ice-Cream</li><li>Cake</li><li>Lassi</li></ul>");
//		}

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(URL, USER, PASS);

			String sql = "SELECT * FROM name WHERE name LIKE '" + name + "%'";
			Statement st = conn.createStatement();

			ResultSet rs = st.executeQuery(sql);
			String res = "<ul>";

			while (rs.next()) {
				res += "<li>" + rs.getString("name") + "</li>";
			}
			res += "</ul>";

			out.append(res);

		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
