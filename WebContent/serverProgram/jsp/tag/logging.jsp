<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

body 안에서 실행되는 로직<br/>

<tags:logging/>
<%
for(int i = 0; i < 10; i++)
	out.print(i + "<br/>");
%>
<tags:logging/>

</body>
</html>