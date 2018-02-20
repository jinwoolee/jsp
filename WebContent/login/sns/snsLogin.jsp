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
<%@include file="/commonJsp/jquery.jsp" %>
<%@include file="/commonJsp/bootstrap.jsp"%>	<%--정적 include : page가 삽입되어 하나의 jsp파일로 컴파일된다. --%>
<script type="text/javascript" src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js" charset="utf-8"></script>
<script type="text/javascript" src="https://developers.kakao.com/sdk/js/kakao.min.js" charset="utf-8"></script>

<%--<jsp:include page="/jsp/common/uppermenu.jsp" flush="true"/> --%> <%--동적 include : page가 삽입되어 하나의 jsp파일로 컴파일된다. --%>

<script>
$(document).ready(function(){
	initEvent();
});

function initEvent(){
	//naver login
	$("#naverLoginBtn").on("click", function(){
		var naverClientId = "gYkqeVAb7MK9Xnd7bgHh";
		var serviceDomain = "http://localhost:8080";
		var redirectUri = "http://localhost:8080/login/sns/naverLoginCallback.jsp";
		var naverIdLogin = new naver_id_login(naverClientId, redirectUri);
		var state = naverIdLogin.getUniqState();
		
	    /*naverIdLogin.setDomain(serviceDomain);
	    naverIdLogin.setState(state);
	    naverIdLogin.setPopup();
	    naverIdLogin.init_naver_id_login();*/
	    
		var url = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		url += "&client_id=" + naverClientId;
		url += "&redirect_uri=" + redirectUri;
		url += "&state=" + state;
		
		document.location = url;
	});
	
	//kakao login
	$("#kakaoLoginBtn").on("click", function(){
		// 사용할 앱의 JavaScript 키를 설정해 주세요.
        Kakao.init('f018e639d99853988c758a70c16c56ea');
		Kakao.Auth.loginForm({
            success : function(authObj) {
                console.log(authObj);
                
                Kakao.API.request({
                    url : '/v1/user/me',
                    success : function(res) {
                        $("#memo").html(res);
                    },
                    fail : function(error) {
                        alert(JSON.stringify(err));
                    }
                });
            },
            fail : function(err) {
                console.log(err)
            }
        });
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
            <span id="memo"></span>
		</form>
	</div>
	<!-- /container -->
</body>
</html>