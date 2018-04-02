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
	session.setAttribute("sessionAttr", "setSessionSetApp-SESSION");
	application.setAttribute("applicationAttr", "setSessionSetApp-APPLICATION");
	
	RequestDispatcher rd = request.getRequestDispatcher("/day5/pageContextAttrResult.jsp");
	rd.forward(request, response);
%>
</body>
</html>