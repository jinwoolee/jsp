<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" 	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>deferred.jsp</title>
</head>
<body>
	<%
		Calendar now = Calendar.getInstance();
		request.setAttribute("now", now);
	%>
	<c:set var="elNow" value="${now.time }" />
	<c:set var="deferredELNow" value="#{now.time }" />
	<%
		now.set(2000, 10, 2);
	%>
	EL : ${elNow } , 값을 설정한 시점에 값
	<br /> DeferredEL : ${deferredELNow }, 값을 표현하는 시점의 값
	  
</body>
</html>