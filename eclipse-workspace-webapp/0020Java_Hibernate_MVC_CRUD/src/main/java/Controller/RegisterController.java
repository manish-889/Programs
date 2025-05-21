package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import Dao.UserDao;
import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/reg")
@MultipartConfig
public class RegisterController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		int uid = 0;
		if(!id.equals("")) {
			 uid = Integer.parseInt(id);
		}
		
		String uname = req.getParameter("uname");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String gender = req.getParameter("gender");
		String country = req.getParameter("country");
		String[] lang = req.getParameterValues("lang");
		Part file = req.getPart("file");
		
		String fileName = Paths.get(file.getSubmittedFileName()).getFileName().toString();
		
		String fileNameToStore = System.currentTimeMillis()+"_"+fileName;
		String path = req.getServletContext().getRealPath("")+File.separator+"img";
		
		File f = new File(path);
		if(!f.exists())
		{
			f.mkdir();
		}
		
		file.write(path+File.separator+fileNameToStore);
		
		String row = "";
		for (String s : lang) {
			row += s+",";
		}
		
		User u = new User(uname, email, phone, gender, country, row, fileNameToStore);
		u.setId(uid);
		
		UserDao dao = new UserDao();
		
		int i = dao.addUser(u);
		
		if (i>0) {
			req.setAttribute("doneMsg", "User Registration Successfully..." );
			req.getRequestDispatcher("index.jsp").forward(req, resp);
		}
		
	}
	
}
