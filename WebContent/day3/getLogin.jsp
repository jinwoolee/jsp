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
	var userId2 = document.getElementsByName("userId")[1];
	var password = document.getElementsByName("password")[0];
	
	var userIdDesc1 = document.getElementById("userIdDesc1");
	var userIdDesc2 = document.getElementById("userIdDesc2");
	var passwordDesc = document.getElementById("passwordDesc");
	userIdDesc1.innerText ="";
	userIdDesc2.innerText ="";
	passwordDesc.innerText ="";
	
	//userId1이 5글자 미만인지 체크
	if(userId1.value.length < 5){		
		userIdDesc1.innerText="아이디는 다섯글자 이상이어야 합니다";
		userId1.focus();
		return false;
	}
	
	//userId2이 5글자 미만인지 체크
	if(userId2.value.length < 5){
		userIdDesc2.innerText="아이디는 다섯글자 이상이어야 합니다";
		userId2.focus();
		return false;
	}
	
	//password가 7글자 미만인지
	if(password.value.length < 7){
		passwordDesc.innerText="비밀번호는 7글자 이상이어야 합니다";
		password.focus();
		return false;
	}
	
	return true;
}
</script>
</head>
<body>

<%--
http://localhost:8090/day3/getLogin.jsp
 --%>
 
<form method="get" action="getLoginResult.jsp" onsubmit="return validate();">
user id : <input type="text" name="userId" /> <span id="userIdDesc1"></span><br/>
user id : <input type="text" name="userId" /> <span id="userIdDesc2"></span> <br/>
password : <input type="password" name="password" /> <span id="passwordDesc"></span> <br/>

<input type="submit" value="전송"/> <br/>
</form>

</body>
</html>