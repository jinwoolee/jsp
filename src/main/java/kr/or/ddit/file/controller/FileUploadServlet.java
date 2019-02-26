package kr.or.ddit.file.controller;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import kr.or.ddit.util.PartUtil;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//5MB = 5 * 1024 * 1024
//5MB = 5 * 1MB
//1MB = 1024KB
//1KB = 1024BYTE

@WebServlet("/fileUpload")
@MultipartConfig(maxFileSize=5*1024*1024, maxRequestSize=5*5*1024*1024)
public class FileUploadServlet extends HttpServlet{
	
	private static final String UPLOAD_PATH = "d:\\picture\\";
	
	private Logger logger = LoggerFactory.getLogger(FileUploadServlet.class);
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/jsp/fileUpload.jsp")
			.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		String contentType = req.getContentType();
		String userId = req.getParameter("userId");
		String uploadFile = req.getParameter("uploadFile");
		
//		System.out.println("userId : " + userId);
//		System.out.println("uploadFile : " + uploadFile);
		
		//low level ---> high level
		//하위 레벨은 상위 레벨을 포함하는 개념
		// 로깅 레벨 info : logger.info(...), logger.warn(...), logger.error(...) 
		// 로깅 레벨 error : logger.error(...)
		//trace, debug, info, warn, error
		logger.debug("contentType : " + contentType);
		logger.debug("userId : " + userId);
		logger.debug("uploadFile : " + uploadFile);
		
		
		//part 정보 확인
		//req.getPart(name);
		//req.getParts();
//		Collection<Part> parts = req.getParts();
//		for(Part part : parts){
//			logger.debug("partName : {}", part.getName() );
//			logger.debug("Content-Disposition : {}", part.getHeader("Content-Disposition"));
//		}
		
		Part uploadFilePart = req.getPart("uploadFile");
		String contentDisposition = uploadFilePart.getHeader("Content-Disposition");
		logger.debug("contentDisposition : {}", contentDisposition);
		
		//application
		//localhost /upload --> 물리적경로를 확인
		ServletContext application = getServletContext();
		String path = application.getRealPath("/upload");
		logger.debug("path : {}", path );
		
//		//InputStream is = uploadFilePart.getInputStream();
//		ServletInputStream sis = req.getInputStream();
//		InputStreamReader isr = new InputStreamReader(sis);
//		char[] buff = new char[512];
//		int len = 0;
//		
//		while( (len = isr.read(buff)) > -1){
//			for(int i = 0; i < buff.length; i++)
//				System.out.print(buff[i]);
//		}
		
		
		if(uploadFilePart.getSize() > 0){
			//첨부파일 파일명
			String filename = PartUtil.getFileNameFromPart(contentDisposition);
			String uuidFilename = UUID.randomUUID().toString();
			//uploadFilePart.write(UPLOAD_PATH + uuidFilename);
			
			uploadFilePart.write(path + File.separator + uuidFilename);
			uploadFilePart.delete();
		}
		
		doGet(req, resp);
	}
	
}














