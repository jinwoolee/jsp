<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--내장객체(implicit)
	request, response, session, application, out,
	pageContext 
--%>

<%-- out, request, response, session, page, application --%> 

out.equals(pageContext.getOut()) : <%=out.equals(pageContext.getOut()) %>
request.equals(pageContext.getRequest()) : <%=request.equals(pageContext.getRequest()) %>
response.equals(pageContext.getResponse()) : <%=response.equals(pageContext.getResponse()) %>
session.equals(pageContext.getSession()) : <%=session.equals(pageContext.getSession()) %>
page.equals(pageContext.getPage()) : <%=page.equals(pageContext.getPage()) %>
application.equals(pageContext.getServletContext()) : 
	<%=application.equals(pageContext.getServletContext()) %>


</body>
</html>









