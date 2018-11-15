package kr.or.ddit.util;

public class StringUtil {
	
	/**
	* Method : getFileNameFromHeader
	* 작성자 : sem
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 :contentDisposition에서 filename을 추출
	*/
	public static String getFileNameFromHeader(String contentDisposition){
		String fileName = "";
		String[] splits = contentDisposition.split("; ");
		for(String str : splits){
			if(str.indexOf("filename=") >= 0)
				fileName = str.substring(10, str.lastIndexOf("\""));
		}
		
		return fileName;
	}

	/**
	* Method : getCookie
	* 작성자 : sem
	* 변경이력 :
	* @param cookieString
	* @param string
	* @return
	* Method 설명 : 쿠키 값 조회
	*/
	public static String getCookie(String cookieString, String cookieName) {
		//"remember=Y; userId=brown; etc=test"
		String[] cookies = cookieString.split("; ");
		
		String cookieValue = "";
		for(String str : cookies){
			if(str.startsWith(cookieName + "="))
				cookieValue = str.substring((cookieName + "=").length());
		}
		
		return cookieValue;
	}
}










