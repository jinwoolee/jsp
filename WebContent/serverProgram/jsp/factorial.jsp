<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.math.BigDecimal"%>

<%!
private BigDecimal factorial(int num) {
	if (num < 0) { // 음수 팩토리얼의 경우 예외 발생
		throw new ArithmeticException("음수 팩토리얼");
	} else if (num > 1) {
		return new BigDecimal(num).multiply(factorial(num - 1));
	} else {
		return new BigDecimal(num);
	}
}

private int loopFactorial(int num){
	int result = 0;
	
	if(num < 1)
		result =  0;
	else{
		int tmp = 1;
		for(int i = 1; i <= num; i++)
			tmp = i * tmp;
				
		result = tmp;
	}
	
	return result;
}
	
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>factorial</title>
</head>
<body>
	<h4>Factorial 구하기</h4>
	<table>
		<tr>
			<th>5!</th>
			<td><%= factorial(5)%> / <%=loopFactorial(5) %></td>
		</tr>
		<tr>
			<th>6!</th>
			<td><%= factorial(6)%> / <%=loopFactorial(6)%> </td>
		</tr>
		<tr>
			<th>7!</th>
			<td><%= factorial(7)%> / <%=loopFactorial(7)%></td>
		</tr>
		<tr>
			<th>8!</th>
			<td><%= factorial(8)%> / <%=loopFactorial(8)%></td>
		</tr>
		<tr>
			<th>9!</th>
			<% int factorial = 9; %>
			<td><%= factorial(factorial)%> / <%=loopFactorial(factorial)%></td>
		</tr>
	</table>
</body>
</html>