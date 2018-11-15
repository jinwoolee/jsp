<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	requestResult.jsp
	
	<h2>parameter</h2>
	userId : <%=request.getParameter("userId") %> <br>
	name : <%=request.getParameter("name") %> <br>
	
	<h2>attribute</h2>
	<% UserVo userVo = (UserVo)session.getAttribute("userVo");%>
	userId : <%=userVo.getUserId() %>  <br>
	name : <%=userVo.getName() %> <br>
	alias : <%=userVo.getAlias() %> <br>
	birth : <%=userVo.getBirth() %> <br>
	
</body>
</html>







