<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "no-cache"); //http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
	response.setHeader("Cache-Control", "no-cache"); //http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
	response.addHeader("Cache-Control", "no-store"); //파이어 폭스 no-cache bug
	response.setDateHeader("Expires", 1L); //만료일자 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">
<!-- Bootstrap core CSS -->
<script src="/js/jquery/jquery-1.12.4.js"></script>
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Bootstrap core js -->
<style>
	.container {padding-top:30px;}
</style>
</head>
<body>
	<div class="container">
		<form class="form-horizontal" role="form">
			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디">
				</div>
			</div>
			
			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
				<div class="col-sm-10">
					<label class="control-label">brown</label>
				</div>
			</div>
			
			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userNm" name="userNm" placeholder="사용자 이름">
				</div>
			</div>
			<div class="form-group">
				<label for="userNm" class="col-sm-2 control-label">별명</label>
				<div class="col-sm-10">
					<input type="text" class="form-control" id="userAlias" name="userAlias" placeholder="별명">
				</div>
			</div>
			<div class="form-group">
				<label for="pass" class="col-sm-2 control-label">Password</label>
				<div class="col-sm-10">
					<input type="password" class="form-control" id="pass" name="pass" placeholder="Password">
				</div>
			</div>
			
			<div class="form-group">
				<div class="col-sm-offset-2 col-sm-10">
					<button type="submit" class="btn btn-default">사용자 등록</button>
				</div>
			</div>
		</form>
	</div>
</body>
</html>
