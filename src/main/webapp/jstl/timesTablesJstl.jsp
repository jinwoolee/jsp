<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
	td {	border : 1px solid pink;
	}
</style>
</head>
<body>
	<table>
		<c:forEach begin="1" end="9" var="j">
			<tr>
				<c:forEach begin="2" end="${param.number }" var="i">
					<td>${i } * ${j }=${i*j } </td>
				</c:forEach>
			</tr>		
		</c:forEach>
	</table>
</body>
</html>





