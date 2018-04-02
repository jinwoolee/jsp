<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.model.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
day8 main.jsp  입니다 <br/>

<%
	HttpSession httpSession = request.getSession();
	UserVo userVo = (UserVo)session.getAttribute("userVo");
	
%>
별명 : <%= userVo.getUserAlias() %> <br/>
사용자 아이디 : <%= userVo.getUserId() %> <br/>
사용자 이름 : <%= userVo.getUserNm() %> <br/>
session.getMaxInactiveInterval(); <%= session.getMaxInactiveInterval()%> <br/>

<br/><br/>
request.getAttribute("loginResult") : <%= request.getAttribute("loginResult")%>
applciation : <%= application.getAttribute("application") %>
</body>
</html>