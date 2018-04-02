<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	
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
				
				<%--하단 코드는 디자이너로 부터 받은 하드 코딩 내용.
				    해당 부분은 UserController로 부터 받은 userList 객체를 화면에 출력 --%>
				<tbody id="userList">
					<%-- 
					<%
						List<UserVo> userList = (List<UserVo>)request.getAttribute("userList");
						for(UserVo vo : userList){
							out.println("<tr data-userid=\"" + vo.getUserId() + "\">");	
							out.println("	<td>" + vo.getUserId() + "</td>");
							out.println("	<td>" + vo.getUserNm() + "</td>");
							out.println("	<td>" + vo.getUserAlias() + "</td>");
							out.println("	<td>" + vo.getReg_dt() + "</td>");
							out.println("</tr>");
						}
					%>
					--%>
					
					<%-- 상단의 스크립틀릿과 동일한 결과가 나오도록, jstl이용해서 구현한다. --%>
					<%-- 이부분에 구현해주세요 --%>
					
					<c:forEach var="userVo" items="${userList}">
						<tr data-userid="${userVo.userId}" >	
							<td>${userVo.userId}</td>
							<td>${userVo.userNm}</td>
							<td>${userVo.userAlias}</td>
							<td><fmt:formatDate value="${userVo.reg_dt}" pattern="yyyy-MM-dd"/> </td>
						</tr>
					</c:forEach>
					
				</tbody>
			</table>
		</div>

		<a id="regUserBtn" class="btn btn-default pull-right">사용자 등록</a>
	
	
		<div class="text-center">
			<ul class="pagination">
				<%--하단의 페이지 네비게이션 생성 로직을 controller로 이관
				    controller 에서 페이지 네비게이션 html을 생성  
				    request.setAttribute("pageNav", "생성된 HTML");
				    
				    userContent.jsp에서는 request.getAttribute("pageNav");
				      을 이용하여 화면에 출력%
				 --%>
				<%= request.getAttribute("pageNav")%>
			</ul>
		</div>
	</div>
</div>