package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import com.doa.StateDao;
import com.model.StateModel;
import com.util.DbConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/state")
public class StateServlet extends HttpServlet {
	private StateDao dao;

	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		dao = new StateDao(con);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int cid = Integer.parseInt(req.getParameter("cid"));

		PrintWriter out = resp.getWriter();

		try {
			List<StateModel> state = dao.getState(cid);
			
			String res = "<option>-- Select State --</option>";
			
			for (StateModel stateModel : state) {
				res += "<option value='"+stateModel.getId()+"'>"+stateModel.getName()+" </option>";
				
			}
			
			out.append(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
