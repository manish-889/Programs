 package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.util.List;

import com.doa.CountryDao;
import com.model.CountryModel;
import com.util.DbConnector;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/country")
public class CountryServlet extends HttpServlet{
	private CountryDao countryDAO;
	
	@Override
	public void init() throws ServletException {
		Connection con = DbConnector.getCon();
		countryDAO = new CountryDao(con);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		try {
			
			List<CountryModel> country = countryDAO.getCountry();
			
			
			String res = "<option>-- Select Country --</option>";
			for (CountryModel countryModel : country) {
				res += "<option value='"+countryModel.getId()+"'>"+countryModel.getName()+" </option>";
			
			}
			
			out.append(res);
 		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
