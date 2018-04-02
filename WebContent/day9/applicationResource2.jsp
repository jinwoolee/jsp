<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.InputStreamReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.InputStream" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- applicationResource.jsp : application 내장객체를 통해서 특정 url에 위치한 리소스(ex : txt)를 
      접근하는 테스트
 -->

<%
	/* /day9/notice.txt */
	//String	path	=	"/day9/notice.txt";
	String	path	=	"/WEB-INF/web-info_notice.txt";
	InputStream is = application.getResourceAsStream(path);
	InputStreamReader isr = new InputStreamReader(is);
	BufferedReader br = new BufferedReader(isr);
	
	char[] ch = new char[512];
	int len = -1;
	
	out.println("==============================");
	while( (len = br.read(ch)) != -1){
		out.println(ch);	
	}
	out.println("==============================");
%> 
</body>
</html>