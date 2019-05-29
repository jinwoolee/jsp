<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/sumCalculation" method="post">
		start : <input type="text" name="start" value="1"/> <br>
		end : <input type="text" name="end" value="10"/> <br>
		<button>계산</button>
	</form>
</body>
</html>