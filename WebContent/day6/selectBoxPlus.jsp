<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- 서버로 파라미터 전송
*****select box option 생성시 스클립틀릿을 사용하는 예제****

1. input --> select box (id, name=arg1, agr2,) 2개를 생성
1-1. select box의 option 값은 1~100까지 선택 가능
1-2. select box의 option 값은 하드 코딩이 아닌 스클립틀릿을 통해 for loop를 이용하여 생성

2. form action = CalculateServlet 
3. CalculateServlet에서는  jsp에서 전송한 파라미터 2개를 받는다
4. 파라미터 2개의 값을 더하여 화면에 출력(out 객체 사용)
 --%>
<form method="post" action="/Day6CalculateServlet">
	숫자1 : <select name="number1">
			<% for(int i = 1; i <= 100; i++){
				out.println("<option value=\"" + i + "\" >" + i + "</option>" );
			}%>
		   </select>
	
	 <br/>
	숫자2 : <select name="number2">
			<% for(int i = 1; i <= 100; i++){
				out.println("<option value=\"" + i + "\" >" + i + "</option>" );
			}%>
		   </select> 
    <br/>
	<input type="submit" value="전송"/>
</form> 
 
</body>
</html>