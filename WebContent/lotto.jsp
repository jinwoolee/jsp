<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="student.dao.*"%>
<%@page import="student.model.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	IStudentDao studentDao = new StudentDaoMybatis();
	StudentVo student = studentDao.getLottoStudent();
%>

<canvas id="myCanvas" width="400" height="400" style="border:1px solid #d3d3d3;">
Your browser does not support the HTML5 canvas tag.</canvas>

<script>
var c = document.getElementById("myCanvas");
var ctx = c.getContext("2d");
ctx.beginPath();
ctx.arc(200, 200, 180, 0, 2*Math.PI);
ctx.stroke();

ctx.font = "80px Arial";
ctx.fillText("<%=student.getStud_name()%>", 80, 220);		//lotto 1~45
</script> 

</body>
</html>