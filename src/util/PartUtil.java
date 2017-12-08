package util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilterWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {
	private static Logger logger = LoggerFactory.getLogger(PartUtil.class);
	
	/** 
	 * Method   : readParameterValue
	 * 최초작성일  : 2017. 12. 1. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param part
	 * @return
	 * @throws IOException 
	 * Method 설명 : part의 string parameter 조회
	 */
	public static String readParameterValue(Part part) throws IOException {
		InputStreamReader reader =  new InputStreamReader(part.getInputStream(), "utf-8");
		char[] data = new char[512];
		int len = -1;
		StringBuilder builder = new StringBuilder();
		while ((len = reader.read(data)) != -1) {
			builder.append(data, 0, len);
		}
		return builder.toString();
	}
	
	/**
	  * @FileName : PartUtil.java
	  * @Project : jsp
	  * @Date : 2017. 12. 2.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param part
	  * @return
	  * @프로그램 설명 : 파일명을 part에서 추출
	  */
	public static String getFileName(Part part) {
		//content-type : image/jpeg
		//content-disposition : form-data; name="picture"; filename="sally.png"
		
		String[] contentDiposition = part.getHeader("Content-Disposition").split(";"); 
		for (String cd : contentDiposition) {
			if (cd.trim().startsWith("filename")) {
				return cd.substring(cd.indexOf('=') + 1).trim()
						.replace("\"", "");
			}
		}
		return null;
	}

	/**
	  * @FileName : PartUtil.java
	  * @Project : jsp
	  * @Date : 2017. 12. 2.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param pictureFilePath
	  * @param picturePart
	  * @프로그램 설명 : 파일 업로드
	  */
	public static void uploadFile(String pictureFilePath, Part picturePart) {
		if (picturePart.getSize() > 0) {
			try {
				picturePart.write(pictureFilePath);
				picturePart.delete();
			} catch (IOException e) {
				logger.error("can't upload file {}", picturePart.getName());
			}
		}
	}
	
	/*
	public static void uploadFile(String pictureFilePath, InputStream is) {
		File file = new File(pictureFilePath);
		FileWriter fw = null;
		
		try {
			char[] cuff = new char[512];
			byte[] buff = new byte[512];
			int len = -1;
			InputStreamReader isr = new InputStreamReader(is);
			fw = new FileWriter(file);
			
			while( (len = isr.read(cuff)) != -1) {
				fw.write(cuff);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				fw.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	*/
	
	public static void uploadFile(String pictureFilePath, InputStream is) {
		logger.debug("pisctureFilePath : {} ", pictureFilePath );
		File uploadFile = null;
		OutputStream os = null;
		
	  try {
			byte[] buff = new byte[is.available()];
			is.read(buff);
			
			uploadFile = new File(pictureFilePath);
			os = new FileOutputStream(uploadFile);
			os.write(buff);
			
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				os.close();} catch (IOException e) {e.printStackTrace();}
		}
	}
	
	public static void uploadFile(String uploadPath, HttpServletRequest request) {
		
		//파일 업로드 임시 영역 설
		String tempUploadPath = request.getServletContext().getRealPath("/tmp");
		File temporaryDir  = new File(tempUploadPath);
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory(1024*1024*1, temporaryDir);
		
		//파일 업로드 설정
		ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);                               
		upload.setSizeMax(1024 * 1024 * 2);           		  //최대 파일 크기(2M)
		try {
			List<FileItem> items = upload.parseRequest(request);
			for(FileItem fileItem : items) {
				//일반 form - text
				if(fileItem.isFormField())
					;
				//file
				else {				
					logger.debug("file info : {}, size : {}, contentType : {}",
								  fileItem.getName(), fileItem.getSize(), fileItem.getContentType() );
					 File uploadedFile=new File(uploadPath.replace(fileItem.getName(), ""), fileItem.getName());                                                   //실제 디렉토리에 fileName으로 카피 된다.
					 fileItem.write(uploadedFile);
					 //fileItem.delete();                         
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
