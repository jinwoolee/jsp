<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- pageEncoding : jsp 파일 작성에 대한 인코딩 -->
<!-- charset : jsp 파일 출력시의 인코딩 / contentType 헤더 설정값 -->

<!-- html charset 결정순서 
 1. Content-Type 헤더
 2. META http-equiv  Content-Type과 charset 속성
 3. charset 속성
 -->

<!DOCTYPE html>
<html>
<head>
<!--  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">-->
<meta charset="utf-8"> 
<title>Insert title here</title>

</head>
<body>
<!-- web.xml 의 setCharacterEncodingFilter 활성화 -->
<form method="get" action="/serverProgram/jsp/postRequestReceive.jsp">
	user id : <input type="text" name="userId"/> <br/>
	user id : <input type="text" name="userId"/> <br/>
	password : <input type="password" name="psswd"/> <br/>
	<input type="submit" value="전송"/>
</form>
</body>
</html>