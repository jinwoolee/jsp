<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 서버로 파라미터 전송
1. input (id, name=arg1, agr2,) 2개를 생성
1-1. 사용자는 input에 숫자를 입력합니다.
2. form action = CalculateServlet 
3. CalculateServlet에서는  jsp에서 전송한 파라미터 2개를 받는다
4. 파라미터 2개의 값을 더하여 화면에 출력(out 객체 사용)
 --%>

<form method="post" action="/Day6CalculateServlet">
	숫자1 : <input type="text" name="number1" /> <br/>
	숫자2 : <input type="text" name="number2" /> <br/>
	<input type="submit" value="전송"/>
</form>
</body>
</html>