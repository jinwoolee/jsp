<%@ page language="java" contentType="text/html; charset=euc-kr" pageEncoding="UTF-8"%>
<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");		//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");		//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정

%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>헤더 설정</title>
</head>
<body>
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정 <br/> 
response.setHeader("Cache-Control", "no-cache");		//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정 <br/>
response.addHeader("Cache-Control", "no-store");		//파이어 폭스 no-cache bug <br/>
response.setDateHeader("Expires", 1L);				//만료일자 설정 <br/>
한글 한
<%="response.getLocale() : " + response.getLocale() %>
</body>
</html>