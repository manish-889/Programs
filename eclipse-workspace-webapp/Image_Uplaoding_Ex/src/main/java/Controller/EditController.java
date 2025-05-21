package Controller;

import java.io.IOException;

import Dao.ImageDao;
import Model.Image;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edit")
public class EditController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("uid"));
		String action = req.getParameter("action");
		
		ImageDao dao = new ImageDao();
		
		if(action.equals("delete")) {
			int i = dao.deleteImage(id);
			if(i>0) {
				req.getRequestDispatcher("Index.jsp").forward(req, resp);
			}
		}else if(action.equals("update")) {
			Image img = dao.getImageById(id);
			
			req.setAttribute("imgData", img);
			req.getRequestDispatcher("update.jsp").forward(req, resp);
		}
		
	}
	
}
