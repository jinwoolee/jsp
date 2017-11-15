<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.BufferedReader,java.io.InputStream, java.io.InputStreamReader,java.io.IOException"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	BufferedReader br = null;
	String resourcePath = "/notice/notice.txt";
	
	try{
		InputStream is = application.getResourceAsStream(resourcePath);
		InputStreamReader isr = new InputStreamReader(is, "utf-8");
		System.out.println("isr.getEncoding()" + isr.getEncoding());
		
		
		br = new BufferedReader(isr);
		
		
		char[] buff = new char[512];
		int len = -1;
		while( (len = br.read(buff)) != -1)
			out.println(buff);
			//out.println(new String(buff, 0, len));
			//out.println(new String(buff, 0, len));
		
	}catch(IOException e){
		e.printStackTrace();
	}finally{
		if( br != null){
			try{
				br.close();		
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
%>
</body>
</html>