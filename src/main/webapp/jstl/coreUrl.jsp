<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

https://search.naver.com/search.naver?sm=top_hty&fbm=0&ie=utf8&query=html
<c:import url="https://search.naver.com/search.naver">
	<c:param name="query" value="html"/>
</c:import>

${result }

<%-- <c:import url="/userpaginglist"> --%>
<%-- 	<c:param name="page" value="5"/> --%>
<%-- </c:import> --%>

</body>
</html>



