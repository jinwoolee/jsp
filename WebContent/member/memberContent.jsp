<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "no-cache"); //http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
	response.setHeader("Cache-Control", "no-cache"); //http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
	response.addHeader("Cache-Control", "no-store"); //파이어 폭스 no-cache bug
	response.setDateHeader("Expires", 1L); //만료일자 설정
%>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped">
				<tr>
					<th>사용자 아이디</th>
					<th>사용자 이름</th>
					<th>사용자 별명</th>
					<th>등록일시</th>
				</tr>
				<tr>
					<td>brown</td>
					<td>브라운</td>
					<td>br</td>
					<td>2017.10.09</td>
				</tr>
				<tr>
					<td>cony</td>
					<td>코니</td>
					<td>con</td>
					<td>2017.10.08</td>
				</tr>
			</table>
		</div>

		<a class="btn btn-default pull-right">사용자 등록</a>

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
</div>
