<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="cc" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td{	border : 1px solid black;
	    padding : 10px;
	}
</style>
</head>
<body>

<table >
<cc:forEach var="i" begin="1" end="9">
	<tr>
		<cc:forEach var="j" begin="2" end="9">
			<td>${j} * ${i} = ${i*j} </td>	
		</cc:forEach>
	</tr>
</cc:forEach>

<% for(int i = 1; i <= 9; i++ ){%>
	<tr>
		<% for(int j = 2; j <= 9; j++ ){ %>
			<td><%=j %> * <%=i %> = <%=i*j %> </td>	
		<% } %>
	</tr>
<% }%>

</table>

</body>
</html>