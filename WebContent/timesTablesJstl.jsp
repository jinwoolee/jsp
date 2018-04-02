<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {border : 1px solid black;
	    padding : 10px;}
	
</style>
</head>
<body>

<table >
<% for(int i = 1; i <= 9; i++ ){%>
	<tr>
		<% for(int j = 2; j <= 9; j++ ){ %>
			<td><%=j %> <%= "*" %> <%=i %> <%= "=" %> <%=i*j %> </td>	
		<% } %>
	</tr>
<% }%>

</table>
<table>
<c:forEach var="i" begin="1" end="9">
	<tr>
	<c:forEach var="j" begin="2" end="9">
		<td> ${j } * ${i } = ${j * i }
	</c:forEach>
	</tr>
</c:forEach>
</table>

<!-- <table>
	<tr>
		<td>2*1=2</td>
		<td>3*1=3</td>
		<td>4*1=4</td>
	</tr>
	<tr>
		<td>2*2=4</td>
		<td>3*2=6</td>
		<td>4*2=8</td>
	</tr>
	<tr>
		<td>2*3=6</td>
		<td>3*3=9</td>
		<td>4*3=12</td>
	</tr>
</table> -->

<%--
2*1 = 2  3*1 = 3 ......... 9*1 = 9
2*2 = 4  3*2 = 6 ......... 9*2 = 18
.
.
.
.
.
2*9 = 18  3*9 = 27 ......... 9*9 = 91
 --%>
</body>
</html>