package Controller;

import java.io.IOException;

import Dao.UserDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/register")
public class RegisterController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String uid = req.getParameter("id");
		int id =0;
		if(!uid.equals("")) {
			id= Integer.parseInt(uid);
		}
		
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		
		User u = new User();
		u.setId(id);
		u.setUname(uname);
		u.setEmail(email);
		
		UserDao dao = new UserDao();
		int i = dao.addUser(u);
		
		if(i>0) {
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
	
}
