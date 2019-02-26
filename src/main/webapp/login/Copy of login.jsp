<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<!-- <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> -->
<title>Insert title here</title>
<!-- 합쳐지고 최소화된 최신 CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

<!-- 부가적인 테마 -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap-theme.min.css">

<!-- 합쳐지고 최소화된 최신 자바스크립트 -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
</head>
<body>
<!-- 어디로 전송할지??? : form tag action-->
<!-- 전송 메소드 : form tag method (default : get)-->
<!-- 전송 파라미터 : input, select, textarea name이 속성이 존재 해야함-->

<form action="${cp}/login/loginRequest.jsp" method="post">
	사용자 id : <input type="text" name="userId" value="brown">
			  <input type="text" name="userId" value="브라운"><br>
	비밀번호 : <input type="password" name="password" value="pass1234"><br>
	<input type="submit" value="로그인">
</form>

 
</body>
</html>



