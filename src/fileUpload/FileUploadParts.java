package fileUpload;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class FileUploadServletTest
 */
/**
fileSizeThreshold : 서버로 파일을 저장할때 파일의 임시 저장 사이즈
maxFileSize : 1개의 파일이 최대 사이즈
maxRequestSize : 서버로 전송 되는 request 의 최대 사이즈 ( 파일 + formData)
*/
@WebServlet("/fileUploadParts")
@MultipartConfig(maxFileSize=1024*1024*15, maxRequestSize=1024*1024*10 )
public class FileUploadParts extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadParts() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String contentType = request.getContentType();
		PrintWriter pw = response.getWriter();
		
		System.out.println("contentType : " + contentType + "<br/>");
		System.out.println("userId : " + request.getParameter("userId"));
		System.out.println("file : " + request.getParameter("file"));
		
		if(contentType.contains("multipart")) {
			Collection<Part> collection = request.getParts();
			for(Part part : collection) {
				System.out.println(part.getName()); 
				
			}
		}
		
		Part userIdPart = request.getPart("userId");
		Part filePart = request.getPart("file");
		
		System.out.println("userIdPart.getHeader(\"Content-Disposition\") : "  + userIdPart.getHeader("Content-Disposition"));
		System.out.println("filePart.getHeader(\"Content-Disposition\") : " + filePart.getHeader("Content-Disposition"));
		

		String fileName = "";
		String fileContentDisposition = filePart.getHeader("Content-Disposition");
		String[] contentDisposition = fileContentDisposition.split(";");
		
		for(String str : contentDisposition) {
			if(str.startsWith(" filename")) {
				fileName = str.substring(str.indexOf("=")+1).replace("\"", "");
			}
		}
		System.out.println("fileName : " + fileName);
		
		
		String pictureFilePath = getServletContext().getRealPath("/uploadPicture") + "/" + fileName;
		if (filePart.getSize() > 0) {
			try {
				filePart.write(pictureFilePath);
				filePart.delete();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
