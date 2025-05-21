package com.controller;

import java.io.IOException;

import com.dao.UploadingDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/delete")
public class DeleteImageServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		UploadingDao dao = new UploadingDao();

		try {
			int r = dao.deleteImg(id);
			
			if(r > 0) {
				resp.sendRedirect("index.jsp");
			}else {
				System.out.println("Somthing Went Wrong!!!");
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
