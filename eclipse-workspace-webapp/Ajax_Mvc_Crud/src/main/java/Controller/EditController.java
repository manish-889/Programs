package Controller;

import java.io.IOException;
import java.io.PrintWriter;

import com.google.gson.Gson;

import Dao.UserDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));
		String action = req.getParameter("action");

		UserDao dao = new UserDao();

		if (action.equals("delete")) {
			int i = dao.deleteUser(id);
		}else if(action.equals("update")) {
			User u = dao.getUserById(id);
			
			Gson json = new Gson();
			
			PrintWriter out = resp.getWriter();
			out.append(json.toJson(u));
		}

	}

}
