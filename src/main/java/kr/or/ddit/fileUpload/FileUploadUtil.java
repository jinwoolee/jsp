package kr.or.ddit.fileUpload;

public class FileUploadUtil {
	
	//form-data; name="img"; filename="sally.png"
	//filename="sally.png; form-data; name="img";"
	//==> sally.png
	
	//FileUploadUtilTest
	public static String getFilename(String contentDisposition) {
		String[] attrs = contentDisposition.split("; ");
		for(String attr : attrs) {
			String[] attrArray =  attr.split("=");
			if(attrArray[0].equals("filename")) {
				return attrArray[1].replaceAll("\"", "");		//더블 쿼테이션 제거
			}
		}
		return "";
	}
}

