package com.controller;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.dao.UploadingDao;
import com.util.DbConncter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

@WebServlet("/upload")
@MultipartConfig
public class UplaodServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Part filepart = req.getPart("upFile");
		String img = filepart.getSubmittedFileName();
		
		String name = req.getParameter("name");
		
		System.out.println(img + " = " +name);
		
		UploadingDao dao = new UploadingDao();
		
		int g = dao.uploadImg(img, name);
		
		HttpSession session = req.getSession();
		
		try {
			
			
			if(g >0) {
				//String path = this.getServletConfig().getServletContext().getRealPath("")+"img";
				String path = "C:\\Users\\ViP\\eclipse-workspace-webapp\\JavaFileUploading\\src\\main\\webapp\\img";
				File file = new File(path);
				filepart.write(path+file.separator+img);
				
				session.setAttribute("msg", "Upload Successfully...");
				
				resp.sendRedirect("index.jsp");
			}else {
				System.out.println("fail");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
