package Controller;

import java.io.IOException;

import Dao.UserDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		
		User u = new User();
		u.setId(id);
		u.setUname(uname);
		u.setEmail(email);
		
		UserDao dao = new UserDao();
		int i = dao.addUser(u);
		
	}
	
}
