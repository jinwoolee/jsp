package day19;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import util.PartsUtil;

/**
 * Servlet implementation class FileUploadServlet
 */
@WebServlet("/fileUploadServlet")
@MultipartConfig(maxFileSize=1024*1024*2, maxRequestSize=1024*1024*5)
//단위 : byte, 1024btye = 1k, 1k * 1024 = 1M

/*
@MultipartConfig 설정전
testParam : null 
testFileParam : null

@MultipartConfig 설정후
testParam : testParamValue 
testFileParam : null

@MulitipartConfig를 설정후, form enctype="multipart/form=data"로 전송을 하면
    일반적인 텍스트 파라미터는 requeset.getParamert로 파라미터 접근이 가능
    
   file은 request.getParts 정보를 통해 접근이 가능
*/ 

public class FileUploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public FileUploadServlet() {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		
		//testParam, testFileParam 파라미터를 request객체에서 받아 out 객체로 출력
		String testParam		=	request.getParameter("testParam");
		String testFileParam	=	request.getParameter("testFileParam");
		
		/* 파일에 대해서는 getParameter가 동작하지 않음(multipart/form-data)
			Map<String, String> fileMap = request.getParameter("testFileParam");
			
			fileMap.get("content-type") // "image/png"
			fileMap.get("filename") 	// "moon.png"
			
			//option(할수있는 분들만)
			fileMap.get("fileSize")		//실제 파일 사이즈(byte)
		*/
		
		
		PrintWriter pw = response.getWriter();
		pw.println("testParam : " + testParam +" <br/>");
		pw.println("testFileParam : " + testFileParam +" <br/>");
		
		System.out.println("testParam : " + testParam +" <br/>");
		System.out.println("testFileParam : " + testFileParam +" <br/>");
		
		pw.println("<br/><br/><br/>");
		
		printPartsHeaders(request, pw);
		
		//part 이름 : testFileParam
		//file 이름 : part.getHeader("content-disposition")
		
		
		
		
		//inputStream으로 요청 데이터 읽기
		/*InputStream is = request.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		char[] buff = new char[512];
		int len = -1;
		
		while((len = br.read(buff)) != -1){
			pw.println(buff);
		}*/
		
	}

	private void printPartsHeaders(HttpServletRequest request, PrintWriter pw)
			throws IOException, ServletException {
		//parts 정보출력
		Collection<Part> partCollection = request.getParts();
		for(Part part : partCollection){
			Collection<String> headerCollection = part.getHeaderNames();
			for(String header : headerCollection){
				pw.println(part.getName() + "- header : " + header + " ::"
						 + part.getHeader(header) + ":: </br>");
			}
		}
	}
}






