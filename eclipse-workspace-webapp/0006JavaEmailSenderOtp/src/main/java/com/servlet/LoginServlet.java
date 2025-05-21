package com.servlet;

import java.io.IOException;
import java.util.Random;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.User;
import com.util.EmailSender;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		SessionFactory factory = new Configuration().configure().buildSessionFactory();
		
		Session session = factory.openSession();
		
		String query = "from User where email =:x and password =: y";
		Query q = session.createQuery(query);
		
		q.setParameter("x", email);
		q.setParameter("y", password);
		
		User user = (User) q.uniqueResult();
				
		if(user!=null) {
			Random rand = new Random();
			int otp = 10000 + rand.nextInt(999999);
			
			ServletContext context = req.getServletContext();
			context.setAttribute("otp", otp+"");
			
			try {
				boolean status = EmailSender.sendMail("mg7623136@gmail.com", "For Testing Purpose", "Hello User this is your OTP : "+otp);
				if(status) {
					req.getRequestDispatcher("otp.jsp").forward(req, resp);;
				}else {
					req.getRequestDispatcher("login.jsp").forward(req, resp);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		session.close();
	}
	
}
