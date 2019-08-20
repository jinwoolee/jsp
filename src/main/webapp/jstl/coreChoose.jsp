<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--일반적인 프로그래밍 언어의 if - else if - else --%>
	<h2>core choose</h2>
	<c:set var="code" value="02"/>
	
	<c:choose>
		<c:when test="${code == '01' }">
			code is 01
		</c:when>
		<c:when test="${code == '02' }">
			code is 02
		</c:when>
		<c:otherwise>
			code is undefined
		</c:otherwise>
	</c:choose>
</body>
</html>










