<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
pageContext

<%
	
	//해당 jsp 페이지에 대한 정보를 갖고있는 객체 . 로직 개발자가 사용할 일은 많지 않음
	/*if(application == pageContext.getServletContext())
		out.print("application == pageContext.getServletContext() is true <br/>");
	else
		out.print("application == pageContext.getServletContext() is false <br/>");

	if(session == pageContext.getSession())
		out.print("session == pageContext.getSession() is true <br/>");
	else
		out.print("session == pageContext.getSession() is false <br/>");
	
	if(request == pageContext.getRequest())
		out.print("request == pageContext.getRequest() is true <br/>");
	else
		out.print("session == pageContext.getRequest() is false <br/>");*/
	
	/*
	page --> pageContext
	reqeust
	session
	application
	*/
	//request.setAttribute
	
	pageContext.setAttribute("pageAttr", "PAGEATTR");
	request.setAttribute("requestAttr", "REQUESTATTR");
	session.setAttribute("sessionAttr", "SESSIONATTR");
	application.setAttribute("applicationAttr", "APPLICATIONATTR");
	
	//response.sendRedirect("/day5/pageContextAttrResult.jsp");
	
	RequestDispatcher rd = request.getRequestDispatcher("/day5/pageContextAttrResult.jsp");
	rd.forward(request, response);
			
	
	
%>
</body>
</html>