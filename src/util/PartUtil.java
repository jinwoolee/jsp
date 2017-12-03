package util;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.Part;

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
		//content-disposition : form-data; name="picture"; filename="샐리.jpeg"
		
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
}
