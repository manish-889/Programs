package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import com.Model.UserModel;





public class UserDao {
	private Connection conn;

	public UserDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}
	
	public int insertUser(UserModel user) throws SQLException {
		int status = 0;
		
		String sql = "INSERT INTO user (name, email, contact, password) VALUES (?, ?, ?, ?)";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, user.getName());
		ps.setString(2, user.getEmail());
		ps.setString(3, user.getContact());
		ps.setString(4, user.getPassword());
		
		status = ps.executeUpdate();
		
		return status; 
	}
	
	public ArrayList<UserModel> getUserList() {

		ArrayList<UserModel> userList = new ArrayList<UserModel>();

		try {

			String sql = "SELECT * FROM user";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				UserModel user = new UserModel();
				user.setId(rs.getInt("id"));
				user.setName(rs.getString("name"));
				user.setEmail(rs.getString("email"));
				user.setContact(rs.getString("contact"));
				user.setPassword(rs.getString("password"));

				userList.add(user);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return userList;

	}
	
	public int deleteRecords(int id) throws ClassNotFoundException, SQLException {
		
		String sql = "delete from user where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		return stmt.executeUpdate();
	}
	
	public HashMap< String, Object> editRecord(int id) throws ClassNotFoundException, SQLException{
		HashMap<String, Object> map = new HashMap<String, Object>();
		
		String sql = "Select * from user where id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, id);
		
		ResultSet rs = stmt.executeQuery();
		
		if(rs.next()) {
			map.put("id", rs.getInt("id"));
			map.put("name", rs.getString("name"));
			map.put("email", rs.getString("email"));
			map.put("contact", rs.getString("contact"));
			map.put("password", rs.getString("password"));
		}else {
			System.out.println("no");
		}
		
		return map;
	}
	
	public int updateRecord(UserModel um) throws ClassNotFoundException, SQLException {
	
		String sql = "UPDATE user SET name = ?, email = ?, contact = ?, password = ? WHERE id = ?";
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, um.getName());
		stmt.setString(2, um.getEmail());
		stmt.setString(3, um.getContact());
		stmt.setString(4, um.getPassword());
		stmt.setInt(5, um.getId());
		
		return stmt.executeUpdate();
	}
}
