<%@page import="java.sql.Connection"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		BasicDataSource bd = (BasicDataSource)application.getAttribute("bd");
	
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 20; i++){
			Connection conn = bd.getConnection();
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		out.println("<h3> endTime - startTime : " + (endTime-startTime) +" ms </h3>");
	%>
</body>
</html>




