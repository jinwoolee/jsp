<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	public String msg(){
		return "hello, world";
	}

	//factorial method 선언
	public int factorial(int number){
		int result = 0;
		
		if(number == 1){
			result = 1;
		}else{
			result = number*factorial(number-1);
		}
		
		return result;
	}
%>
	<%=msg() %>
	<br>
	<%--factorail method 호출 ( loop를 통해 factorial 8까지 호출)--%>
	<%for(int i = 1; i <= 8; i++ ){ %>
		factorial(<%=i %>) = <%=factorial(i) %> <br>
	<%} %>
	
</body>
</html>







