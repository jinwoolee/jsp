<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="loginTestResult.jsp" >
	<input type="text" name="userId" value="${param.userId}"/> <br/>
	<input type="password" name="pass" /> <br/>
	<input type="submit" value="전송" /> <br/>
</form>
</body>
</html>