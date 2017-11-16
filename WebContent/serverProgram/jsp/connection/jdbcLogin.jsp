<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function setAttribute(){
	var userId	=	document.getElementById("userId");
	var pass	=	document.getElementById("pass");
	
	if(userId.value.length > 0)
		pass.focus();
}
</script>
</head>
<body onload="javascript:setAttribute();">
<% 
String userId = request.getParameter("userId");
userId = (userId == null || userId.equals("")) ? "" : userId;
String msg = (String)request.getAttribute("msg");
%>

<% if(msg != null){ %>
	<%= msg%>
<%} %>

<form method="post" action="/JdbcLogin">
	사용자 아이디 : <input type="text" id="userId" name="userId" value="<%= userId%>"/> <br/>
	비밀번호 : <input type="password" id="pass" name="pass"/> <br/>
	<input type="submit" value="전송"/> <br/>
</form>
</body>
</html>
