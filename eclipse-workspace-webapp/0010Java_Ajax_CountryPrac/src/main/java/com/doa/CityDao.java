package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.CityModel;



public class CityDao {
	private Connection conn;

	public CityDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CityDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<CityModel> getCity(int sid) throws SQLException {
		List<CityModel> list = new ArrayList<CityModel>();

		String sql = "SELECT * FROM city where sid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, sid);
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			CityModel city = new CityModel();

			city.setId(rs.getInt("id"));
			city.setName(rs.getString("name"));

			list.add(city);
		}
		return list;
	}
}
