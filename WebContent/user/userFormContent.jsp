<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
.container {
	padding-top: 30px;
}
</style>
</head>

<%-- ${method} / <%=request.getAttribute("method") %> --%>
<form id="userFormFrm" method="post" action="${pageContext.request.contextPath}/user/userForm" class="form-horizontal" role="form">
	<div class="form-group">
		<label for="userNm" class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<input type="hidden" id="method" name="method" value="${method}" />
			 
			<%--스크립틀릿 / 표현식 
			<% 	String disabled = "";
				if("insert".equals(request.getAttribute("method")))
					disabled = "";
				else
					disabled = "disabled"; %>--%>			
			<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디" <%--<%=disabled %>--%>  value="${userVo.userId}" ${userIdDisabled}>
			
			
			<%-- jstl / EL --%>
			<%--
			<<c:set var="disabledEl" value = "disabled"/>
			<c:if test="${method == \"insert\"}">
				<c:set var="disabledEl" value = ""/>
			</c:if>
			<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디" ${disabledEl}> --%>
			
			<%--controller / EL --%>
			<%--<input type="text" class="form-control" id="userId" name="userId" placeholder="사용자 아이디" ${userIdDisabled}>
			
			** ${disabled} / ${disabledEl} / ${userIdDisabled} ** --%> 
			
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
			<% if("insert".equals(request.getAttribute("method"))){ %>
				<button id="insertUser" type="button" class="btn btn-default">사용자 등록</button>
			<%}else if("update".equals(request.getAttribute("method"))){ %>
				<button id="updateUser" type="button" class="btn btn-default">사용자 수정</button>
			<%} %>
			
			
		</div>
	</div>
</form>
