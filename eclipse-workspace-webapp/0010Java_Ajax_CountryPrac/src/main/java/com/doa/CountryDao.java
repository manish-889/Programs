package com.doa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.model.CountryModel;

public class CountryDao {
	private Connection conn;

	public CountryDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CountryDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<CountryModel> getCountry() throws SQLException {
		List<CountryModel> list = new ArrayList<CountryModel>();

		String sql = "SELECT * FROM country";
		Statement st = conn.createStatement();

		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			CountryModel country = new CountryModel();

			country.setId(rs.getInt("id"));
			country.setName(rs.getString("name"));

			list.add(country);
		}
		return list;
	}
}
