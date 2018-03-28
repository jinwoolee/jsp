<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	에러가 발생했을때 나타나는 페이지에요
	<br/>
	<%
	//에러 페이지에서는 exception 객체를 사용할수 있다.
	out.println("<br/>==========error=======<br/>");
	out.println(exception.getCause() + "<br/>");
	out.println(exception.toString() + "<br/>");
	out.println(exception.getMessage() + "<br/>");
	out.println("<br/>==========error=======<br/>");
	%>
</body>
</html>