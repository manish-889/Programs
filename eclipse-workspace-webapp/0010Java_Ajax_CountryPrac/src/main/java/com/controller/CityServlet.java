package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import com.doa.CityDao;
import com.doa.StateDao;
import com.model.CityModel;
import com.model.StateModel;
import com.util.DbConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/city")
public class CityServlet extends HttpServlet{
	private CityDao dao;
	
	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		dao = new CityDao(con);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int sid = Integer.parseInt(req.getParameter("sid"));

		PrintWriter out = resp.getWriter();

		try {
			List<CityModel> city = dao.getCity(sid);
			
			String res = "<option>-- Select State --</option>";
			
			for (CityModel cityModel : city) {
				res += "<option value='"+cityModel.getId()+"'>"+cityModel.getName()+" </option>";
				
			}
			
			out.append(res);
		} catch (Exception e) {
			e.printStackTrace();
		}
	
	}
}
