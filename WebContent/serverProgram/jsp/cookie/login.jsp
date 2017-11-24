<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Insert title here</title>
<!-- css -->
<link href="/css/signin.css" rel="stylesheet">
<%@include file="/commonJsp/jquery.jsp"%>
<%@include file="/commonJsp/bootstrap.jsp"%>	<%--정적 include : page가 삽입되어 하나의 jsp파일로 컴파일된다. --%>
<%--<jsp:include page="/jsp/common/uppermenu.jsp" flush="true"/> --%> <%--동적 include : page가 삽입되어 하나의 jsp파일로 컴파일된다. --%>

<script src="/js/jqueryCookie/js.cookie.js"></script>
<script src="/js/jqueryCookie/jquery.cookie.js"></script>


<script>
$(document).ready(function(){
	//페이지 로딩시 inputEmail cookie check 설정
	var cookieValue	= getCookieValue("remember-me");
	if(cookieValue != ""){
		$("#inputEmail").val(cookieValue);
		$("#remember-me").prop("checked", true);
	}
	
	//remember-me 체크 이벤트 리스너
	$("#remember-me").on("click", function(){
		if($(this).prop("checked") == true){
			setCookieValue("remember-me", $("#inputEmail").val(), 30);
			console.log(getCookieValue("remember-me"));
		}
		else
			deleteCookieValue("remember-me");
	});
	
	//사용자 계정 입력시마다
	$("#inputEmail").on("keyup", function(){
		if($("#remember-me").prop("checked") == true)
			setCookieValue("remember-me", $(this).val(), 30);
	});
});

//cookie 값 조회
function getCookieValue(cookieName){
	var cookieStartIndex	=	document.cookie.indexOf(cookieName);
	if(cookieStartIndex == -1)
		return "";
	else{
		var cookieValueStartIndex	=	document.cookie.indexOf(cookieName) + cookieName.length;
		var cookieValueEndIndex		=	document.cookie.indexOf(";", cookieValueStartIndex);
		if(cookieValueEndIndex == -1)	cookieValueEndIndex	=	document.cookie.length;
		var cookieValue				=	unescape(document.cookie.substring(cookieValueStartIndex+1, cookieValueEndIndex));
		return cookieValue;
	}
}

//cookie 값 설정
function setCookieValue(cookieName, cookieValue, expires){
	var today = new Date();
	today.setDate( today.getDate() + parseInt(expires) );
	document.cookie = cookieName + "=" +  escape(cookieValue) + "; path=/; expires=" + today.toGMTString() + ";";
}

//cookie 값 삭제
function deleteCookieValue(cookieName){
	var expireDate = new Date();
	expireDate.setDate( expireDate.getDate() -1 );
	document.cookie = cookieName + "=; path=/; expires=" + expireDate.toGMTString() + ";";
}
</script>    
</head>
<body>
	<div class="container">
		<form class="form-signin">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="email" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" required>
			<div class="checkbox">
				<label> <input type="checkbox" id="remember-me" value="remember-me">
					Remember me
				</label>
			</div>
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
		</form>
	</div>
	<!-- /container -->
</body>
</html>