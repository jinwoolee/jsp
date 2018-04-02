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
	session.invalidate();
	/*response.sendRedirect("/jsp/login.jsp");
	response.sendRedirect("login.jsp");*/
	
	response.sendRedirect(request.getContextPath() + "/login.jsp");
	
	//request.getContextPath() : ""
	//request.getContextPath() : "/jsp"
%>

</body>
</html>