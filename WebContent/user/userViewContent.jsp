<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>	
<%@page import="user.model.UserVo"%>
<%@page import="java.util.List"%>

<%
	UserVo userVo = (UserVo)request.getAttribute("userVo");
%>

<%-- 
 <% %>  : 스크립틀릿
 <%= %> : 표현식 (expression)
 ${}    : 표현언어(expression language) EL 
--%>

<%--<form method="post" action="<%= request.getContextPath() %>/userDelete.do" "form-horizontal" role="form"> --%>
<form id="deleteUserFrm" method="post" action="${pageContext.request.contextPath}/userDelete.do" class="form-horizontal" role="form">
	<%-- input type hidden 속성은 화면에 보이지 않는다. --%>
	<input type="hidden" id="userId" name="userId" value="${userVo.userId}">
	
	<%--
		속성을 담을수 있는 공간 : 4곳
		pageContext.setAttribute("", ""); // 잘사용하지 않음
		reqeust.setAttribute("userList", userList);
		session.setAttribute("userVo", userVo);
		application.setAttriute
	 --%>
	
	<%--
	 	EL 속성을 담을수 있는 영역에 접근하여, 속성값을 가져온다.
	 	단 범위를 지정하지 않으면 : 
	 --%>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">사진</label>
		<div class="col-sm-10">
		
		<%--
			화면 : 사용자 상세 정보 조회 화면 : userViewContent.jsp
			요구사항 : 사진정보가 존재 -> 해당 사진파일을 img 태그를 이용하여 화면에 표시
			            사진정보가 미존재 -> 등록된 사진이 없다고 화면에 텍스트 출력     
		 --%>
		<c:choose>
			<c:when test="${userVo.picturePath != null }" >
				<%--/fileDownloadServlet?fileName=brown.png
				${userVo.picturePath} : uploadPicture/brown.png
				--%>
				
				<img src="${pageContext.request.contextPath}/${userVo.picturePath}" width="150" height="150" />
				<%--<img src="${pageContext.request.contextPath}/fileDownloadServlet?fileName=${fn:replace(userVo.picturePath, 'uploadPicture\\', '')}" width="150" height="150" /> --%>
			</c:when>
			<c:otherwise>
				등록된 사진이 없습니다.
			</c:otherwise>	
		</c:choose>
			
			<%-- ${userVo.picturePath} == uploadPicture/brown.png --%>
			<%--<label class="control-label">${userVo.userId}</label> --%>
		</div>
	</div>
	
	<div class="form-group">
		<label class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<%--<label class="control-label"><%=userVo.getUserId() %></label> --%>
			<label class="control-label">${userVo.userId}</label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<%--<label class="control-label"> <%=userVo.getUserNm() %></label> --%>
			<label class="control-label"> ${userVo.userNm}</label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<%--<label class="control-label"> <%=userVo.getUserAlias() %></label> --%>
			<label class="control-label">${userVo.userAlias}</label>
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<label class="control-label"> ****** </label>
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<button id="updateUserBtn" type="button" class="btn btn-default">사용자 수정</button>
			<button id="deleteUserBtn" type="button" class="btn btn-default">사용자 삭제</button>
		</div>
	</div>
</form>