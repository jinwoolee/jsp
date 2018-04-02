<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function validate(){
	//userID가 5글자 이상인지
	var userId1 = document.getElementsByName("userId")[0];
	var password = document.getElementsByName("pass")[0];
	
	var userIdDesc1 = document.getElementById("userIdDesc1");
	var passwordDesc = document.getElementById("passwordDesc");
	userIdDesc1.innerText ="";
	passwordDesc.innerText ="";
	
	//userId1이 5글자 미만인지 체크
	if(userId1.value.length < 5){		
		userIdDesc1.innerText="아이디는 다섯글자 이상이어야 합니다";
		userId1.focus();
		return false;
	}
	
	//password가 7글자 미만인지
	if(password.value.length < 4){
		passwordDesc.innerText="비밀번호는 4글자 이상이어야 합니다";
		password.focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<body>
 
<%
	String userId = request.getParameter("userId");
	if(userId == null)
		userId = "";
	
	String msg = (String)request.getAttribute("msg");
	if(msg == null)
		msg = "";
%>
<form method="post" action="/LoginProcessServlet" onsubmit="return validate();">

user id : <input type="text" name="userId" value="<%= request.getParameter("userId") == null ? "" : request.getParameter("userId") %>"/> <span id="userIdDesc1"></span><br/>
password : <input type="password" name="pass" /> <span id="passwordDesc"><%= msg %></span> <br/>

<input type="submit" value="전송"/> <br/>
</form>

</body>
</html>