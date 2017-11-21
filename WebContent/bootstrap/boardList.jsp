<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
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
</head>
<body>
	
<div class="container">	
	<h2 class="sub-header">게시판</h2>
	<div class="table-responsive">
		<table class="table table-striped">
			<tr>
				<th>글번호</th>
				<th>제목</th>
				<th>글쓴이</th>
				<th>작성일시</th>
			</tr>
			<tr>
				<td>1</td>
				<td>안녕하세요</td>
				<td>브라운</td>
				<td>2017.10.09</td>
			</tr>
			<tr>
				<td>2</td>
				<td>안녕하세요</td>
				<td>코니</td>
				<td>2017.10.08</td>
			</tr>
		</table>
	</div>
	
	<a class="btn btn-default pull-right">글쓰기</a>
	
	<div class="text-center">
		<ul class="pagination">
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
		</ul>
	</div>
</div>
</body>
</html>