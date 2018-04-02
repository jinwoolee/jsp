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
	response.setHeader("Pragma", "no-cache");			//http 1.0 버전의 헤더 설정
	response.setHeader("Cache-Control", "no-cache");	//http 1.1 버전의 Cache-Control 설정
	response.addHeader("Cache-Control", "no-store");	//http 1.1 버전의 Cache-Control 설정 : firefox
	response.setDateHeader("Expires", 1L);
%>

responseHeader.jsp
</body>
</html>