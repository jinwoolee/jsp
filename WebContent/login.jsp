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
		</form>
	</div>
	<!-- /container -->
</body>
</html>