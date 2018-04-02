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
	pageContext.setAttribute("pageAttr", "");
	request.setAttribute("requestAttr", "");
	session.setAttribute("sessionAttr", "");
	application.setAttribute("applicationAttr", "");
%>
</body>
</html>