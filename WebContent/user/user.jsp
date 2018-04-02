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

<style>
	#userList tr {cursor: pointer;}
</style>


<script src="/js/jquery-3.2.1.js"></script>

<link href="/bootstrap/css/bootstrap.css" rel="stylesheet">


<!-- Bootstrap core CSS -->
<script src="/bootstrap/js/bootstrap.js"></script>
<!-- Custom styles for this template -->
<link href="/css/dashboard.css" rel="stylesheet">
<link href="/css/blog.css" rel="stylesheet">

<script>
$(document).ready(function(){
	
	//사용자 클릭(tr)
	jQuery("#userList tr").on("click", function() {
		var userId= jQuery(this).data("userid");
		//document.location.href = "/userView.do?userId=" + userId;		
		$(document.location).attr("href", "/userView.do?userId=" + userId);
	});
	
	//사용자 등록버튼 클릭
	jQuery("#regUserBtn").on("click", function(){
		$(document.location).attr("href", "/userFormView.do?mehtod=inert");
	});
});
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
				<jsp:include page="/user/userContent.jsp" />
			</div>
		</div>			
	</div>	
</body>
</html>
