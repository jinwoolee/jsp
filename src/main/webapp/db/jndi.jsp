<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
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
		InitialContext context = new InitialContext();
		DataSource ds = (DataSource)context.lookup("java:comp/env/jdbc/oracleDB");
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 20; i++){
			Connection conn = ds.getConnection();
			conn.close();
		}
		
		long endTime = System.currentTimeMillis();
		
		out.println("<h3> endTime - startTime : " + (endTime-startTime) +" ms </h3>");
	%>
</body>
</html>







