package Controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

import Dao.ImageDao;
import Model.Image;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/update")
@MultipartConfig
public class UpdateController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("uname");
		Part part = req.getPart("file");
		
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		
		String fileToStore = System.currentTimeMillis()+"_"+fileName;
		
		String path = req.getServletContext().getRealPath("")+File.separator+"img";
		
		File f = new File(path);
		
		if(!f.exists()) {
			f.mkdir();
		}
		
		part.write(path+File.separator+fileToStore);
		
		Image img = new Image(id, name, fileToStore);
		
		ImageDao dao = new ImageDao();
		
		int i = dao.updateImg(img);
		
		if(i>0) {
			req.getRequestDispatcher("Index.jsp").forward(req, resp);
		}
		
		
	}
	
}
