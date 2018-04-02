<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.model.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
session.jsp  입니다 <br/>

<%
	HttpSession httpSession = request.getSession();
	UserVo userVo = (UserVo)session.getAttribute("userVo");
	
%>
<%--별명 : <%= userVo.getUserAlias() %> <br/>
사용자 아이디 : <%= userVo.getUserId() %> <br/>
사용자 이름 : <%= userVo.getUserNm() %> <br/>
 --%>

<%--
	세션 객체  
	
 --%>
<br/><br/><br/><br/>

<!-- session.getMaxInactiveInterval() : 단위 초, 기본 설정 1800초 : 30분 -->
session.getMaxInactiveInterval(); <%= session.getMaxInactiveInterval()%> <br/>
<%
session.setMaxInactiveInterval(120 * 60);
%>
session.getMaxInactiveInterval(); <%= session.getMaxInactiveInterval()%> <br/>

<%
//session.invalidate();
%>

creation time : <%=new java.util.Date(session.getCreationTime()) %> <br/>
last access time : <%=new java.util.Date(session.getLastAccessedTime()) %> <br/>

session id : <%= session.getId() %>



</body>
</html>





