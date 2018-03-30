<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--application객체이 있는 sessionMap 정보를 출력한다 --%>
<c:forEach var="entry" items="${sessionMap }">
	 ${entry.value } <br>
</c:forEach>
</body>
</html>