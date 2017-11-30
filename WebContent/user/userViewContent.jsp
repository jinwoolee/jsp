<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<style>
.container {
	padding-top: 30px;
}
</style>
</head>

<form id="frm" method="post" action="${pageContext.request.contextPath}/user/deleteUser" class="form-horizontal" role="form">
	<div class="form-group">
		<label class="col-sm-2 control-label">사용자 아이디</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.userId}</label>
		</div>
	</div>

	<div class="form-group">
		<label class="col-sm-2 control-label">사용자 이름</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.userNm}</label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">별명</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.userAlias}</label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">Password</label>
		<div class="col-sm-10">
			<label class="control-label">*******</label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">등록자</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.reg_id}</label>
		</div>
	</div>
	<div class="form-group">
		<label class="col-sm-2 control-label">등록일시</label>
		<div class="col-sm-10">
			<label class="control-label">${userVo.reg_dt}</label>
		</div>
	</div>
	
	<div class="form-group">
		<div class="col-sm-offset-2 col-sm-10">
			<input type="hidden" name="userId" value="${userVo.userId}" />
			<input type="hidden" name="method" value="update" />
			<button id="deleteUserBtn" type="button" class="btn btn-default">사용자 삭제</button>
			<button id="updateUserBtn" type="button" class="btn btn-default">사용자 수정</button>
		</div>
	</div>
</form>
