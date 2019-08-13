<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<ul class="nav nav-sidebar">
	<!-- a tag : get method -->
	<li class="active"><a href="<%=request.getContextPath()%>/userList">사용자리스트 <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="<%=request.getContextPath()%>/userListOnlyHalf">사용자리스트(onlyHalf) <span class="sr-only">(current)</span></a></li>
	<li class="active"><a href="<%=request.getContextPath()%>/lprodList">제품그룹리스트</a></li>
</ul>