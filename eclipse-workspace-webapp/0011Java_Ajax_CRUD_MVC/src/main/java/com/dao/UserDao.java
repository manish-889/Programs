package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.model.User;
import com.util.DbConnection;

public class UserDao {

	Connection con =null;
	public UserDao() {
		con = DbConnection.getConnection();
	}
	
	//this method for display user 
	public ArrayList<User> diplayUser() {
		ArrayList<User> al = new ArrayList<User>();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user");
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				User u = new User();
				
				u.setId(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPhone(rs.getString(4));
				
				al.add(u);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return al;
	}

	
	//this method for insert user into database
	public int insertUser(User user) {
		
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("INSERT INTO user VALUES (?,?,?,?)");
			ps.setInt(1, 0);
			ps.setString(2, user.getUname());
			ps.setString(3, user.getEmail());
			ps.setString(4, user.getPhone());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}

	
	//this method for delete user
	public int deleteUser(int uId) {
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("DELETE FROM user WHERE id = ?");
			ps.setInt(1, uId);
			
			i = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		return i;
	}

	
	//this is for getting the user details by id for updation of user
	public User getUserById(int uId) {
		
		User user = new User();
		
		try {
			PreparedStatement ps = con.prepareStatement("SELECT * FROM user WHERE id = ?");
			ps.setInt(1, uId);
			
			ResultSet rs  = ps.executeQuery();
			
			while(rs.next()) {
				user.setId(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setEmail(rs.getString(3));
				user.setPhone(rs.getString(4));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return user;
	}

	public int updateUser(User user) {
		int i = 0;
		
		try {
			PreparedStatement ps = con.prepareStatement("UPDATE user SET uname =?, email =?, phone =? WHERE id =?");
			ps.setString(1, user.getUname());
			ps.setString(2, user.getEmail());
			ps.setString(3, user.getPhone());
			ps.setInt(4, user.getId());
			
			i = ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return i;
	}
	
	
	
	
	
}
