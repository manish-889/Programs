package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.util.DbConnector;

public class AjaxDao {
	private Connection con;
	
	public AjaxDao() {
		super();
		// TODO Auto-generated constructor stub
	}


	public AjaxDao(Connection con) {
		super();
		this.con = con;
	}
	
	//dao for get name from database
	public int getName(String value) throws SQLException {
		
		String sql = "SELECT * FROM name WHERE name LIKE '"+value+"%'";
		Statement st = con.createStatement();
		
		return st.executeUpdate(sql);	
	}
}
