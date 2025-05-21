package com;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uplaod")
@MultipartConfig
public class UploadingServlet  extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uname = req.getParameter("uname");
		Part file = req.getPart("file");
		
		String filename = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		String filenameToStore = System.currentTimeMillis()+"_"+filename;
		
		String path = req.getServletContext().getRealPath("")+File.separator+"img";
		
		System.out.println(path);
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		
		file.write(path+File.separator+filenameToStore);
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/uploadimage","root","manishgiri");
			
			PreparedStatement ps = con.prepareStatement("INSERT INTO img VALUES(?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, uname);
			ps.setString(3, filenameToStore);
			
			int i = ps.executeUpdate();
			
			if(i>0) {
				System.out.println("data inserted..");
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
