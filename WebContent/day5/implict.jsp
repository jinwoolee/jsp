<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
public void jspInit(){
	System.out.println("jspInit");
}

public void jspDestroy(){
	System.out.println("jspDestroy");
}
%>

<%
	
	//request 객체  : 클라이언트의 요청정보가 담겨있다. 중요
	//session 객체  : 클라이언트 접속시 서버에 생성되는 저장공간. 중요
	//response 객체 : 클라이언트로 보낼 응답정보를 작성 / 전송. 중요
	
	//pageContext 객체  : jsp페이지에 대한 정보를 갖고있는 객체 . 로직 개발자가 사용할 일은 많지 않음
	//application 객체  : 웹 어플리케이션에 대한 전반적인 정보를 갖고있는 객체 . 로직 개발자가 사용할 일은 많지 않음.

	
	
	//out 객체 : 실무에서 사용할 일이 드물다.
	//page 객체 == jsp (this)
	//config 객체
	//exception 객체
	
%>
day5/implict.jsp 



</body>
</html>