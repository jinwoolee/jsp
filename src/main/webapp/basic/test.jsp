<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- jsp 스크립트 : 서버에서 실행됨
		 <% %>, <%=%>	
	 --%>
	 <%String str = "message"; %>
	 <%String str2 = ""; %>
	 <%String str3 = "hello"; %>
<script>

	/*서버 사이드 변수에 클라이언트 사이드 값을 대입 하는 경우 (X)
	  서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 안된다	*/
	<%=str%> = 'test';
	//<%=str2%> = 'test';
	<%--<%=str2%> = 'test'; --%>

	/* 클라이언트 사이드 변수에 서버 사이드 변수 값을 대입
	   서버 사이드 스크립트가 먼저 실행되므로 논리적으로 말이 된다	*/
	var msg = '<%=str3%>';
	
</script>	 
</head>
<body>
	
	 
	 
</body>
</html>