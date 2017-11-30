<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

<%@ include file="/commonJsp/jquery.jsp" %>
<%@ include file="/commonJsp/bootstrap.jsp" %>

<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script>
$(document).ready(function(){
	//사용자 신규 저장
	$("#insertUser").on("click", function(){
		if(userFormValidate == true)
			$("#userFormFrm").submit();
	});
	
	//사용자 수정
	$("#updateUser").on("click", function(){
		if(userFormValidate == true)
			$("#userFormFrm").submit();
	});
});
//사용자 정보 검증
function validateUserForm(){
	if($("#userId").val().length < 5 ){
		alert("사용자 아이디의 길이가 적당하지 않습니다.");
		return false;
	}
	
	if($("#userNm").val().length < 5 ){
		alert("사용자 이름 길이가 적당하지 않습니다.");
		return false;
	}
	
	if($("#userAlias").val().length < 5 ){
		alert("사용자 별칭 길이가 적당하지 않습니다.");
		return false;
	}
	
	if($("#pass").val().length < 5 ){
		alert("패스워드 길이가 적당하지 않습니다.");
		return false;
	}	
	
	//여기까지 정상적으로 진행되면 검증 완료
	return true;
}
</script>
</head>

<body>
	<jsp:include page="/commonJsp/header.jsp" />
	<div class="container-fluid">
		<div class="row">
			<div class="col-sm-3 col-md-2 sidebar">
				<jsp:include page="/commonJsp/leftMenu.jsp" />
			</div>
			
			<div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
				<jsp:include page="/user/userFormContent.jsp" />
			</div>
		</div>			
	</div>	
</body>
</html>