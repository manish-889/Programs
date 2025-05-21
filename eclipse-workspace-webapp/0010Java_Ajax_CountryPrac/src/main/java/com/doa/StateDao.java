package com.doa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.model.StateModel;

public class StateDao {
	private Connection conn;

	public StateDao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StateDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public List<StateModel> getState(int cid) throws SQLException {
		List<StateModel> list = new ArrayList<StateModel>();

		String sql = "SELECT * FROM states where cid = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setInt(1, cid);
		
		ResultSet rs = ps.executeQuery();

		while (rs.next()) {
			StateModel state = new StateModel();

			state.setId(rs.getInt("id"));
			state.setName(rs.getString("name"));

			list.add(state);
		}
		return list;
	}
}
