package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import com.Model.UserModel;
import com.Util.DbConnector;
import com.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private UserDao dao;
	

	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		dao = new UserDao(con);
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));

		PrintWriter out = resp.getWriter();
		
		try {
			int res = dao.deleteRecords(id);

			if (res > 0) {
				out.append("done");
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
