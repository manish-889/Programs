package com;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpSessionEvent;
import jakarta.servlet.http.HttpSessionListener;

public class SessionListener implements HttpSessionListener {

	int cuser = 0;
	int tuser = 0;

	@Override
	public void sessionCreated(HttpSessionEvent se) {
		cuser++;
		tuser++;

		ServletContext con = se.getSession().getServletContext();

		con.setAttribute("c", cuser);
		con.setAttribute("t", tuser);
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		cuser--;
		ServletContext con = se.getSession().getServletContext();

		con.setAttribute("c", cuser);
	}

}
