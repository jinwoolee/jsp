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
<%@include file="/commonJsp/bootstrap.jsp"%>	<%--정적 include : page가 삽입되어 하나의 jsp파일로 컴파일된다. --%>
<%@include file="/commonJsp/jquery.jsp" %>
<%--<jsp:include page="/jsp/common/uppermenu.jsp" flush="true"/> --%> <%--동적 include : page가 삽입되어 하나의 jsp파일로 컴파일된다. --%>

<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>

<script>
$(document).ready(function(){
	initEvent();
});

function initEvent(){
	//naver login
	$("#naverLoginBtn").on("click", function(){
		var url = "https://nid.naver.com/oauth2.0/authorize?response_type=code&client_id=gYkqeVAb7MK9Xnd7bgHh&redirect_uri=/login/sns/naverLoginCallback.jsp&state=9aHU7JOJRoQUB9ur";
		console.log(url);
	});
	
	//kakao login
	$("#kakaoLoginBtn").on("click", function(){
        console.log("kakaoLoginBtn");
    });
}
</script>
</head>
<body>
	<div class="container">
		<form class="form-signin" method="post" action="loginProcess.jsp">
			<h2 class="form-signin-heading">Please sign in</h2>
			<label for="inputEmail" class="sr-only">Email address</label>
			<input type="text" id="inputEmail" class="form-control" placeholder="Email address" required autofocus>
			<label for="inputPassword" class="sr-only">Password</label>
			<input type="password" id="inputPassword" class="form-control" placeholder="Password" >
			<div class="checkbox">
				<label> <input type="checkbox" name="rememberMe" value="rememberMe">
					Remember me
				</label>
			</div>
			
			<button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
			<img id="naverLoginBtn" src="/image/snsLogin/naver/naver_login_short_Green.png" width="300" style="padding-top:3px;" >
            <img id="kakaoLoginBtn" src="/image/snsLogin/kakao/kakao_login_btn_large_ov.png" width="300" style="padding-top:3px;" >
		</form>
	</div>
	<!-- /container -->
</body>
</html>