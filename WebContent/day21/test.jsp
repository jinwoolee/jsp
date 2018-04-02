<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="userId" value="${param.userId == null ? 'brown' : param.userId}"/>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.2.1.js"></script>
<script>
$(function(){
	$("input[name=userId]").val("${userId}");
	$("input[name=pass]").val("${param.pass}");
});
</script>
</head>
<body>


login 화면 개발
<form mehtod="get" action="test.jsp">
	사용자 아이디 : <input type="text" name="userId"  /> <br/>
	비밀번호 : <input type="password" name="pass" /> <br/>
	<input type="submit" value="전송"> <br/>
</form>
</body>
</html>