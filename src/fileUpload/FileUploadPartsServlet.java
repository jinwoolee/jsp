package fileUpload;


import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadPartsServlet")
@MultipartConfig(maxFileSize=1024*1024*15, maxRequestSize=1024*1024*10 )
public class FileUploadPartsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadPartsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter pw = response.getWriter();
		
		String contentType = request.getContentType();
		pw.println("contentType : " + contentType + "<br/>");
		
		if(contentType.startsWith("multipart")) {
			String paramText	=	request.getParameter("paramText");
			String paramFile	=	request.getParameter("paramFile");
			pw.println("paramText = " + paramText + "<br/>");
			pw.println("paramFile = " + paramFile + "<br/>");
			
			//multipartConfig 설정전 사용 가능
			pw.println("request.getInputStream() <br/>");
			InputStreamReader isr = new InputStreamReader(request.getInputStream());
			char[] buff = new char[512];
			int len = -1;
			while( (len = isr.read(buff)) != -1)
				pw.println(buff);
			pw.println("request.getInputStream() <br/>");
			
			Collection<Part> collection = request.getParts();
			for(Part part : collection) {
				pw.println( part.getName() + "<br/>");
			}
			
			pw.println("<br/><br/>");
			pw.println("paramFile <br/>");
			Part paramFilePart = request.getPart("paramFile");
			//컨텐트 분석
			pw.println(paramFilePart.getHeader("Content-Disposition") + "<br/>");
			String[] contentDisposition = paramFilePart.getHeader("Content-Disposition").split(";");
			String fileName = "";
			for(String str : contentDisposition) {
				if(str.startsWith(" filename")) {
					pw.println(str.substring(str.indexOf("=")+1) + "<br/>");
					fileName = str.substring(str.indexOf("=")+1).replace("\"", "");
				}
			}
			pw.println("fileName : " + fileName);
			
			pw.println("<br/><br/>");
			//paramTextPart
			pw.println(paramFilePart.getName() + " : ");
			isr = new InputStreamReader(paramFilePart.getInputStream());
			buff = new char[512];
			len = -1;
			while( (len = isr.read(buff)) != -1 ) {
				pw.println(buff);
			}
			
			String pictureFilePath = getServletContext().getRealPath("/uploadPicture") + "/" + fileName;
			//printHeader(paramFilePart);
			
			
		
			
			if (paramFilePart.getSize() > 0) {
				try {
					paramFilePart.write(pictureFilePath);
					paramFilePart.delete();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
			
		}
		else {
			String paramText	=	request.getParameter("paramText");
			String paramFile	=	request.getParameter("paramFile");
			pw.println("paramText = " + paramText + "<br/>");
			pw.println("paramFile = " + paramFile + "<br/>");
		}
	}
	
	private void printHeader(Part picturePart) {
		Collection collection = picturePart.getHeaderNames();
		Iterator iterator = collection.iterator();
		while(iterator.hasNext()) {
			String headerName = (String)iterator.next();
			System.out.println(headerName + " : " + picturePart.getHeader(headerName)); 
		}
	}
}
