<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

body 안에서 실행되는 로직<br>

<tags:colorLogging color="red" lineSize="5"/>
<%
for(int i = 0; i < 10; i++)
	out.print(i + "<br>");
%>
<tags:colorLogging color="blue"/>
<br><br>

<tags:bodyColorLogging color="red" lineSize="5"/>
<%
for(int i = 0; i < 10; i++)
	out.print(i + "<br>");
%>
<tags:bodyColorLogging color="blue"/>

<br><br>
<tags:bodyColorLogging color="red" lineSize="5">
<c:forEach var="i" begin="0" end="10">
	<c:out value="${i}"/><br>
</c:forEach>
</tags:bodyColorLogging >
</body>
</html>