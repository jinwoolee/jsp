<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="user.model.UserVo"%>
<%@page import="java.util.List"%>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover"">
				<tr>
					<th>글번호</th>
					<th>제목</th>
					<th>작성자 아이디</th>
					<th>작성일시</th>
				</tr>
				
				<tbody id="boardList">
				
				
					
					<tr>
						<td>1</td>
						<td>1번글 제목입니다.</td>
						<td>brown</td>
						<td>2017.12.07</td>
					</tr>
					<tr>
						<td>2</td>
						<td>2번글 제목입니다.</td>
						<td>cony</td>
						<td>2017.12.07</td>
					</tr>
					<tr>
						<td>3</td>
						<td>3번글 제목입니다.</td>
						<td>sally</td>
						<td>2017.12.07</td>
					</tr>
					<tr>
						<td>1</td>
						<td>1번글 제목입니다.</td>
						<td>brown</td>
						<td>2017.12.07</td>
					</tr>
						
				</tbody>
			</table>
		</div>

		<a id="boardInsertBtn" href="/board/boardFormView?method=insert" class="btn btn-default pull-right">게시 등록</a>
	
		<div class="text-center">
			<ul class="pagination">
				<li class="prev disabled"><span>&lt;&lt;</span></li>
				<li class="active"><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">7</a></li>
				<li><a href="#">8</a></li>
				<li><a href="#">9</a></li>
				<li><a href="#">10</a></li>
				<li class="next"><a href="#">&gt;&gt;</a></li>
			</ul>
		</div>
	</div>
</div>