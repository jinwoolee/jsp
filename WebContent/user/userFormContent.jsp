<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
	JSTL : Jsp Standard tag libray
	--> 스클립틀릿, 표현식으로 간략한 태그형태로 표현
	---> jsp 파일에서 자바코드 형태가 남아있지 않게됨 
--%>
	
<style>
.container {
	padding-top: 30px;
}
</style>
</head>


<form id="userForm" method="post" action="${pageContext.request.contextPath}/userForm.do"
		class="form-horizontal" role="form" enctype="multipart/form-data">
	<input type="hidden" name="method" value="${method}"/>
	
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
					<img src="${pageContext.request.contextPath}/${userVo.picturePath}" width="150" height="150" />
				</c:when>
				<c:otherwise>
					등록된 사진이 없습니다.
				</c:otherwise>	
			</c:choose>
			<input type="file" name="profilePicture" />
		</div>
	</div>
	
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
		
			<c:choose>
				<%--insert --%>
				<c:when test="${method == 'insert'}">
					<input type="text" class="form-control" id="userId" name="userId"
							placeholder="사용자 아이디" value="${userVo.userId}" >
				</c:when>	
				<%-- update --%>	
				<c:when test="${method == 'update'}">
					<label class="control-label">${userVo.userId}</label>
					<input type="hidden" id="userId" name="userId" value="${userVo.userId}">
				</c:when>
			</c:choose>
		</div>
	</div>

	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userNm" name="userNm"
				placeholder="사용자 이름" value="${userVo.userNm}">
		</div>
	</div>
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<input type="text" class="form-control" id="userAlias"
				name="userAlias" placeholder="별명" value="${userVo.userAlias}">
		</div>
	</div>
	<div class="form-group">
		<label for="pass" class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<input type="password" class="form-control" id="pass" name="pass"
				placeholder="Password" value="${userVo.pass}">
		</div>
	</div>

	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<c:choose>
				<%--insert --%>
				<c:when test="${method == 'insert'}">
					<button id="userInsertBtn" type="button" class="btn btn-default">사용자 등록</button>
				</c:when>	
				<%-- update --%>	
				<c:when test="${method == 'update'}">
					<button id="userUpdateBtn" type="button" class="btn btn-default">사용자 수정</button>
				</c:when>
			</c:choose>
		</div>
	</div>
</form>
