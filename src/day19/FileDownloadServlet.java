package day19;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/fileDownloadServlet")
public class FileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//사진 파일명 파라미터 
		String fileName = request.getParameter("fileName");
		
		//application객체를 통해 url에 해당하는 컴퓨터상의 절대 경로를 알아낸다.
		//application == servletContext
		ServletContext sc = getServletContext();
		String filePath = sc.getRealPath("/uploadPicture");
		//String filePath = sc.getRealPath("/WEB-INF/profilePictureuploadPicture");
		
		File file = new File(filePath + File.separator + fileName);
		
		//파일 존재여부를 미리 체크
		response.setHeader("content-disposition", "attachment;filename=" + fileName);
		response.setContentType("application/octet-stream");
		
		
		FileInputStream fis = new FileInputStream(file);
		byte[] buff = new byte[512];
		int len = -1;
		ServletOutputStream sos = response.getOutputStream();
		
		while( (len = fis.read(buff)) != -1){
			sos.write(buff);
		}
		
		fis.close();
		sos.close();		
	}
}










