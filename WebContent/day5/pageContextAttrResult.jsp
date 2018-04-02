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
	//out 내장객체를 이용하여 각 영역 객체의  getAttribute 메소드를 통해 속성값을 화면에 출력하는 로직 작성
	out.println("pageContext : " + pageContext.getAttribute("pageAttr") + "<br/>");
	out.println("request : " + request.getAttribute("requestAttr") + "<br/>");
	out.println("session : " + session.getAttribute("sessionAttr") + "<br/>");
	out.println("application : " + application.getAttribute("applicationAttr") + "<br/>");
	
%>
</body>
</html>