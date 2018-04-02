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
	request.setCharacterEncoding("utf-8");
%>

request.getLocalAddr() : <%=request.getLocalAddr()%> <br/>
request.getRemoteAddr() : <%=request.getRemoteAddr() %> <br/>
request.getContextPath() : <%= request.getContextPath() %> <br/>
request.getServerName() : <%= request.getServerName() %> <br/>
request.getServerPort() : <%= request.getServerPort() %> <br/>
request.getRequestURL() : <%= request.getRequestURL() %> <br/>
request.getRequestURI() : <%= request.getRequestURI() %> <br/>
request.getMethod() : <%= request.getMethod() %><br/>
request.getContentType() : <%= request.getContentType()%><br>
request.getContentLength() : <%=request.getContentLength() %> <br/>
request.getCharacterEncoding() : <%=request.getCharacterEncoding() %>
request.getCookies() : <%= request.getCookies() %> <br/>


</body>
</html>