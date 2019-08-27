package kr.or.ddit.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FileuploadUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(FileuploadUtil.class);

	/**
	* Method : getFilename
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : Content-disposition 헤더 문자열로 부터 파일이름 추출
	*/
	public static String getFilename(String contentDisposition) {
		//메소드 인자 : "form-data; filename=\"brown.png\""; name=\"file\";
		//메소드 인자 : "form-data; name=\"file\"; filename=\"brown.png\"";
		String[] attrs = contentDisposition.split("; ");
		//attrs[0] = form-data
		//attrs[1] = filename="brown.png"
			//	keyValue[0] filename
			//	keyValue[1] "brown.png"
		//attrs[2] = name="file"
		
		String filename = "";
		for(String attr : attrs) {
			if(attr.startsWith("filename")) {
				String[] keyValue = attr.split("=");
				logger.debug("keyValue[1].indexOf(\") : {}", keyValue[1].indexOf("\""));
				filename = keyValue[1].substring(keyValue[1].indexOf("\"")+1, 
												 keyValue[1].lastIndexOf("\""));
				break;
			}
		}
		
		return filename;
	}

	/**
	* Method : getFileExtension
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : Content-disposition 헤더 문자열로 부터 파일 확장자 추출
	*/
	public static String getFileExtension(String contentDisposition) {
		
		//brown.png, cony.xx.png, moon
		String filename = getFilename(contentDisposition);
		
		if(filename.lastIndexOf(".") > 0)
			return filename.substring(filename.lastIndexOf("."), filename.length());
		else
			return "";
	}

	/**
	* Method : getPath
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 파일을 업로드할 경로를 조회한다
	*/
	public static String getPath() {
		String basicPath ="d:\\upload";
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMM");
		String yyyyMM =sdf.format(new Date());	//201908
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		File yyyyDirectory = new File(basicPath + "\\" + yyyy + "\\" + mm);
		if(!yyyyDirectory.exists())
			yyyyDirectory.mkdirs();
		
			// d:\\upload\\2019\\08\\
		return basicPath + "\\" + yyyy + "\\" + mm + "\\";
	}

}





