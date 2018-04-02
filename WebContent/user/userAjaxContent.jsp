<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="user.model.UserVo"%>
<%@page import="java.util.List"%>
<div class="row">
	<div class="col-sm-8 blog-main">
		<h2 class="sub-header">사용자</h2>
		<div class="table-responsive">
			<table class="table table-striped table-hover">
				<thead>
					<tr>
						<th>사용자 아이디</th>
						<th>사용자 이름</th>
						<th>사용자 별명</th>
						<th>등록일시</th>
					</tr>
				</thead>
				<tbody id="userList">
				</tbody>
			</table>
		</div>

		<a id="regUserBtn" class="btn btn-default pull-right">사용자 등록</a>
	
	
		<div class="text-center">
			<ul class="pagination">
			</ul>
		</div>
	</div>
</div>