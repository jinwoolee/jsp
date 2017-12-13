<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script>
    new daum.Postcode({
        oncomplete: function(data) {
        	var result = document.getElementById("result");
        	result.innerHTML += "주소 : " + data.roadAddress + "<br/>";
        	result.innerHTML += "신 우편번호 : " + data.zonecode + "<br/>";
        }
    }).open();
</script>
</head>
<body>

//http://postcode.map.daum.net/guide
<div id="result">
	
</div>

</body>
</html>