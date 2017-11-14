<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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