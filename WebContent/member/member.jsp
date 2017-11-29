<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
%>

<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
<meta name="description" content="">
<meta name="author" content="">
<link rel="icon" href="../../favicon.ico">

<title>Dashboard Template for Bootstrap</title>

<%@ include file="/commonJsp/jquery.jsp"%>
<%@ include file="/commonJsp/bootstrap.jsp"%>

<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
</head>

<body>

	<%--header --%>
	<jsp:include page="/commonJsp/header.jsp"/>

	<div>
		<div class="row">
			<%--left menu --%>
			<jsp:include page="/commonJsp/leftMenu.jsp"/>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<jsp:include page="/member/memberContent.jsp"/>
			</div>
		</div>
	</div>
</body>
</html>
