package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Image;
import Util.DbConnection;

public class ImageDao {

	Connection con = null;
	
	public ImageDao() {
		con = DbConnection.getConnection();
	}

	public int addImage(Image img) {
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO imageex (uname,img) VALUES (?,?)");
			ps.setString(1, img.getName());
			ps.setString(2, img.getImgName());
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return 1;
	}

	public int deleteImage(int id) {
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM imageex WHERE id =?");
			ps.setInt(1, id);
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	public Image getImageById(int id) {
		Image img = new Image();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM imageex WHERE id =?");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				img.setId(rs.getInt(1));
				img.setName(rs.getString(2));
				img.setImgName(rs.getString(3));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return img;
	}

	public int updateImg(Image img) {
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE imageex SET uname=?,img=? WHERE id =?");
			ps.setString(1, img.getName());
			ps.setString(2, img.getImgName());
			ps.setInt(3, img.getId());
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
}
