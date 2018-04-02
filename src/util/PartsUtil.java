package util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.Part;

public class PartsUtil {

	public static String getFileName(String contentDisposition) {
		//"form-data; name=\"testFileParam\"; filename=\"brown.png\"";
		String[] disposition =contentDisposition.split("; ");
		String fileName = "";
		for(String str : disposition){
			if(str.startsWith("filename")){
				fileName = str.substring("filename=".length()).replaceAll("\"", "");		//filename="brown.png"				
			}
		}		
		return fileName;
	}
	
	/**
	 * 파트정보의 파일을 파라미터의 경로에 업로드 한다.
	 * @param filePart
	 * @param filePath
	 * @throws IOException
	 */
	public static void  uploadFile(Part filePart, String filePath) throws IOException {
		String fileName = PartsUtil.getFileName(filePart.getHeader("content-disposition"));
		filePart.write(filePath + File.separator + fileName);
		filePart.delete();
	}
}



