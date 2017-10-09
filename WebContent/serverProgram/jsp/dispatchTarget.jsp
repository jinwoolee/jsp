<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
dispatch 된 페이지
class parameter : <%= request.getParameter("class") %> <br/>
test attribute <%= request.getAttribute("test") %>
</body>
</html>