<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<script src="/js/jquery-3.2.1.min.js"></script>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
$(function(){ 
})

function validate(){
	$("#gbDesc").text("");
	
	if($("#gb").val() == ""){
		$("#gbDesc").text("구분 값을 선택하지 않았습니다.");
		return false;
	}
	
	return true;
}
</script>
</head>
<body>

<form method="post" action="/RedirectDispatchForm" onsubmit="javascript: return validate();">
<span id="gbDesc"></span><br/>
구분	<select id="gb" name="gb">
		<option value="">선택하세요</option>
		<option value="01">redirect</option>
		<option value="02">dispatch</option>
	</select>
	<input type="submit" value="전송"/>
</form>
</body>
</html>