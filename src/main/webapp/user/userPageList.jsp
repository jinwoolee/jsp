<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>	

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

<title>Jsp</title>
<%@ include file="/common/basicLib.jsp"%>

<style>
	.userClick {
		cursor : pointer;
	}
</style>

<script>
$(document).ready(function(){
	console.log("document.ready");
	
	//tr에 select (class="userClick")
	$(".userClick").on("click", function(){
		console.log("userClick");
		var userId = $(this).children()[1].innerHTML;
		
		$("#userId").val(userId);
		$("#frm").submit();
	});
});
</script>
</head>

<form id="frm" action="/userDetail" method="get">
	<input type="hidden" id="userId" name="userId"/>
</form>

<body>
	<%--header --%>
	<%@ include file="/common/header.jsp"%>

	<div class="container-fluid">
		<div class="row">

			<%--left --%>
			<%@ include file="/common/left.jsp"%>

			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<div class="row">
					<div class="col-sm-8 blog-main">
						<h2 class="sub-header">사용자</h2>
						<div class="table-responsive">
							<table class="table table-striped table-hover">
								<tr>
									<th>번호</th>
									<th>사용자 아이디</th>
									<th>사용자 이름</th>
									<th>생일</th>
								</tr>
								
								<!-- userList loop 이용하여 출력 -->
								<c:forEach items="${userList }" var="vo">
									<tr class="userClick">
										<td>${vo.rnum}</td>
										<td>${vo.userId}</td>
										<td>${vo.name}</td>
										<td><fmt:formatDate value="${vo.birth }" pattern="yyyy-MM-dd"/></td>
									</tr>
								</c:forEach>
								
								
							</table>
						</div>

						<a class="btn btn-default pull-right"
							href="/userForm">사용자 등록</a>

						<div class="text-center">
							<ul class="pagination">
								<li>
							      <a href="/userPageList?page=1&pageSize=10" aria-label="Previous">
							        <span aria-hidden="true">&laquo;</span>
							      </a>
							    </li>
								<c:forEach begin="1" end="${pageCnt }" var="p">	
									<li><a href="/userPageList?page=${p }&pageSize=10">${p }</a></li>
								</c:forEach>
								<li>
							      <a href="/userPageList?page=${pageCnt }&pageSize=10" aria-label="Next">
							        <span aria-hidden="true">&raquo;</span>
							      </a>
							    </li>
							</ul>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
