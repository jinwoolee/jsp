package fileUpload;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		
		String	param = request.getParameter("param");
		System.out.println("param : " + param);
		
		File temporaryDir = new File(getServletContext().getRealPath("/tmp"));       //업로드 된 파일의 임시 저장 폴더를 설정
		String realDir = getServletContext().getRealPath("/upload");
		DiskFileItemFactory factory = new DiskFileItemFactory(30, temporaryDir);
		
		
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			List<FileItem> fileList = upload.parseRequest(request);
			
			for(FileItem fileItem : fileList) {
				if(fileItem.isFormField())
					pw.println("fileItem.getFieldName() + fileItem.getString() : " + fileItem.getFieldName() + " / " + fileItem.getString());
				else {					
					pw.println(fileItem.getFieldName() + " / " + fileItem.getSize() + " / " + fileItem.getContentType());
					File uploadedFile = new File(realDir, fileItem.getFieldName());                                                   //실제 디렉토리에 fileName으로 카피 된다.
					fileItem.write(uploadedFile);
					fileItem.delete();
				}
			}
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(Exception e) {e.printStackTrace();}     
	}
}
