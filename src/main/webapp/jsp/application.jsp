<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.write("application.getContextPath() : " + application.getContextPath() + "<br>");
	out.write("application.getServerInfo() : " + application.getServerInfo() + "<br>");
	out.write("application.getMajorVersion() : " + application.getMajorVersion() + "<br>");
	out.write("application.getMinorVersion() : " + application.getMinorVersion() + "<br>");
	out.write("application.getInitParameter(\"ADMIN\") : "
							+ application.getInitParameter("ADMIN") + "<br>");
	
	out.write("application.getRealPath(\"/res/190522.txt\") :" 
								+ application.getRealPath("/res/190522.txt"));
	
	String filePath = application.getRealPath("/res/190522.txt");
	File file = new File(filePath);
	//http://localhost/jsp/jsp/application.jsp
	if(file.canRead()){
		InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
		
		char[] buff = new char[512];
		int len;
		while((len = isr.read(buff, 0, buff.length)) !=-1){
			out.write(buff);
		}
		isr.close();
	}
	
%>
</body>
</html>




