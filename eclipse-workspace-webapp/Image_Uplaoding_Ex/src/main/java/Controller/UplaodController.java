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

@WebServlet("/upload")
@MultipartConfig
public class UplaodController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name = req.getParameter("uname");
		Part part = req.getPart("file");
	
		//get File name
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		
		//set Unique name
		String fileToStore = System.currentTimeMillis()+"_"+fileName;
		
		String path = req.getServletContext().getRealPath("")+File.separator +"img";
		
		File file = new File(path);
		
		if(!file.exists()) {
			file.mkdir();
		}
		
		part.write(path+File.separator+fileToStore);
		
		Image img = new Image();
		img.setName(name);
		img.setImgName(fileToStore);
		
		ImageDao dao = new ImageDao();
		
		int i = dao.addImage(img);
		if(i>0) {
			System.out.println("Data inserted");
			req.getRequestDispatcher("Index.jsp").forward(req, resp);
		}
		
	}
	
}
