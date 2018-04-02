<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.model.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
main.jsp  입니다 <br/>

<!--
logoutProcess.jsp 구현

사용자가 하단의 링크(logout)을 클릭하면
logoutProcess.jsp에서 session을 invaldate 시키고
login.jsp로 이동 
-->

<a href="/logoutProcess.jsp"> logout</a>

<%
	HttpSession httpSession = request.getSession();
	UserVo userVo = (UserVo)session.getAttribute("userVo");
%>
<br/><br/>
별명 : <%= userVo.getUserAlias() %>
사용자 아이디 : <%= userVo.getUserId() %>
사용자 이름 : <%= userVo.getUserNm() %>

<br/><br/>
request.getAttribute("loginResult") : <%= request.getAttribute("loginResult")%>
applciation : <%= application.getAttribute("application") %>
</body>
</html>