<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>
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
</head>
<body>
<canvas id="myCanvas" width="400" height="400" style="border:1px solid #d3d3d3;"></canvas>

<script src="/js/jquery/jquery-1.12.4.js"></script>
<script>
$(document).ready(function(){
	var c = document.getElementById("myCanvas");
	var ctx = c.getContext("2d");
	ctx.beginPath();
	ctx.arc(200, 200, 100, 0, 2*Math.PI);
	ctx.stroke();
	
	ctx.font = "90px Arial";
	
	var lottoNum = <%= new Random().nextInt(15)+1%>;
	
	var startX = lottoNum > 9 ? 155 : 180;
	var startY = 230;
	ctx.fillText(lottoNum, startX, startY);
});

</script>

</body>
</html>