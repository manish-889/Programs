package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.model.ImageModel;
import com.util.DbConncter;

public class UploadingDao {
	private Connection con;
	
	
	
	public UploadingDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UploadingDao(Connection con) {
		super();
		this.con = con;
	}

	//dao for 
	public int uploadImg(String img, String name) {
		int i = 0;
		Connection con = DbConncter.getCon();
		try {
			PreparedStatement ps = con.prepareStatement("insert into imgUpload(filename,name) values (?,?)");
			ps.setString(1, img);
			ps.setString(2, name);

			i = ps.executeUpdate();

			if (i > 0) {
				return i;
			} else {
				System.out.println("Something Went Wrong!!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deleteImg(int id) throws SQLException {
		Connection con = DbConncter.getCon();

		PreparedStatement ps = con.prepareStatement("Delete from imgUpload where id = ?");
		ps.setInt(1, id);
		
		return ps.executeUpdate();
	}

	public ImageModel getImageById(int id) throws SQLException {
		Connection con = DbConncter.getCon();
		ImageModel im = new ImageModel();
		
		PreparedStatement ps = con.prepareStatement("select * from imgUpload where id = ?");
		ps.setInt(1, id);
		
		ResultSet rs = ps.executeQuery();
		
		while(rs.next()) {
			im.setId(rs.getInt("id"));
			im.setName(rs.getString("name"));
			im.setFilename(rs.getString("filename"));
		}
		
		return im;
	}
}
