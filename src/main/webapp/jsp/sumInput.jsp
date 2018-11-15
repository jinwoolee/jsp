<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7/jquery.min.js"></script>

</head>
<body>
<form action="/sumCalculation" method="post">
	start : <input type="text" name="start"><br>
	end : <input type="text" name="end"><br>
	<input type="submit" value="두수 사이의 합 구하기">
	
</form>
</body>
</html>