<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
	지금까지 배운 내장객체
	response
	request
	out
	session
	
	application
	
--%>
application.getServerInfo() : <%=application.getServerInfo() %> <br/>
application.getServletContextName() : <%= application.getServletContextName() %> <br/>
application.getMajorVersion() : <%= application.getMajorVersion() %> <br/>
application.getMinorVersion() : <%= application.getMinorVersion() %> <br/>

<%--
web.xml에 context-param에 설정한 값을 가져온다.
추후 spring에서 초기화 클래스, 혹은 초기화에 필요한 리소스(xml)들을 설정할때 사용--%>
initParameter : <%= application.getInitParameter("adminUser") %>

<%
	//request.setAttribute("request", "request");
	session.setAttribute("session", "session");
	application.setAttribute("application", "application");
%>
</body>
</html>







