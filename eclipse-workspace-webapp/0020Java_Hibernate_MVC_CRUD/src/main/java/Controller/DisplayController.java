package Controller;

import java.io.IOException;
import java.util.List;

import Dao.UserDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		UserDao dao = new UserDao();
		
		List<User> list = dao.viewAllUsers();
		
		req.setAttribute("userList", list);
		req.getRequestDispatcher("display.jsp").forward(req, resp);
	}
	
}
