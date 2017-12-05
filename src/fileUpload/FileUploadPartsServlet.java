package fileUpload;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadPartsServlet")
public class FileUploadPartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadPartsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String paramText	=	request.getParameter("paramText");
		String paramFile	=	request.getParameter("paramFile");
		
		pw.println("param = " + paramText);
		pw.println("file = " + paramFile);
	}
}
