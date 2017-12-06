<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<ul class="nav nav-sidebar">
	<li><a href="<%=request.getContextPath()%>/main.do">Main <span class="sr-only">(current)</span></a></li>
	<li><a href="<%=request.getContextPath()%>/user/userList">사용자 리스트</a></li>
	<li><a href="<%=request.getContextPath()%>/user/userListAjax">사용자 리스트(Ajax)</a></li>
	
	<!-- url 수정작업전 -->
	<li><a href="<%=request.getContextPath()%>/board/boardList">게시판</a></li>
	<li><a href="<%=request.getContextPath()%>/board/boardForm.jsp">게시판(작성)</a></li>
</ul>