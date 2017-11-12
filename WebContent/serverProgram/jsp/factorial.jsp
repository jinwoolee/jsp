<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.math.BigDecimal"%>

<%!private BigDecimal factorial(int num) {
		if (num < 0) { // 음수 팩토리얼의 경우 예외 발생
			throw new ArithmeticException("음수 팩토리얼");
		} else if (num > 1) {
			return new BigDecimal(num).multiply(factorial(num - 1));
		} else {
			return new BigDecimal(num);
		}
	}%>

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
			<td><%= factorial(5)%></td>
		</tr>
		<tr>
			<th>6!</th>
			<td><%= factorial(6)%></td>
		</tr>
		<tr>
			<th>7!</th>
			<td><%= factorial(7) %></td>
		</tr>
	</table>
</body>
</html>