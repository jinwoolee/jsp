package kr.or.ddit.file.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(maxFileSize=1024*1024*5, maxRequestSize=1024*1024*5*5)
@WebServlet("/fileUpload")
public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	//fileUpload.jsp 전달
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/fileupload/fileUpload.jsp").
							forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//request.geth
		request.setCharacterEncoding("utf-8");
		
		//일반 text 파라미터 : request.getParameter("파라미터명");
		//파일 : request.getPart("파라미터명");
		
		System.out.println(request.getContentType());
		System.out.println("userId : " + request.getParameter("userId"));
		//System.out.println("profile : " + request.getParameter("profile"));
		
		//profile part
		Part profilePart = request.getPart("profile");
		System.out.println("profile part : " + profilePart.getContentType());

		//Content-disposition 헤더 정보
		//파일과 관련된 부가정보
		System.out.println("Content-disposition : " +
				profilePart.getHeader("Content-disposition"));
		//"form-data; name=\"profile\"; filename=\"brown.png\"";
		
		String contentDisposition = 
				profilePart.getHeader("Content-disposition");
		
		String fileName = "";
		
		String[] splits = contentDisposition.split("; ");
		for(String str : splits){
			if(str.indexOf("filename=") >= 0)
				fileName = str.substring(10, str.lastIndexOf("\""));
		}
		
		
		//파일 쓰기
		profilePart.write("D:\\A_TeachingMaterial\\6.JspSpring\\upload\\" +
		
				new String(fileName.getBytes(), "utf-8"));
		
		profilePart.delete();		//파일업로드 과정에서 사용한 디스크 임시 영역을 정리
		
		
		
	}

}












