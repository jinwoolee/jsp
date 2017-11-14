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
		<% for(int i=1; i <= 8; i++){ %>
			<tr>
				<th><%= "factorial : " + i + "! : "%></th>
				<td><%=loopFactorial(i) %></td>
			</tr>
			<%} %>
	</table>
</body>
</html>