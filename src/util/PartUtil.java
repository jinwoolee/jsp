package util;

import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.http.Part;

public class PartUtil {
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
}
