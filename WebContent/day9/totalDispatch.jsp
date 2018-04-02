<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
	동적으로 페이지를 include 하는 예제 2번째 방법
	RequestDispatcher 객체를 이용
	(지금까지는 RequestDispatcher의 fowrard만 이용)
	
	테스트 방법 : http://localhost:8090/day9/totalDispatch.jsp 접속시
	          스크립틀릿 안에 있는 코드처럼 header.jsp가 include가 되는지 확인
 --%>
total dispatch page 시작 <br/>

<%
	out.flush();
	RequestDispatcher rd = request.getRequestDispatcher("header.jsp");
	rd.include(request, response);
%>
total dispatch page 종료 <br/>
</body>
</html>



