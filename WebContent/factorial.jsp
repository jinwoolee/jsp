<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%!
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
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<% for(int i = 1; i <8; i++ ){ %>
	<%= "loopFactorial(" + i + ") : " + loopFactorial(i) %> <br/>
<%} %>

<!--
for loop
factorial(1) : 1
factorial(2) : 2
factorial(3) : 6
factorial(4) : 24
factorial(5) : 120
factorial(6) : 720
factorial(7) : 5040
factorial(8) : 40320

 -->
</body>
</html>
