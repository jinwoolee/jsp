<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<!DOCTYPE html >
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert title here</title>
</head>
<body>
<!-- 선언부 ==> class 변수, method -->
<%!
public String getName(){
	return "brown";
}
%>
	
<!-- 스크립틀릿 ==> doXXX / service  -->
<% Date date = new Date(); %>
현재시간은 <%=date%> 입니다 <br/>
</body>
</html>