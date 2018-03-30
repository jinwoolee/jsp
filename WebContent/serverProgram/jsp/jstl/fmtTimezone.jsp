<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:set var="now" value="<%= new java.util.Date() %>" />

<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" />

<br>
<fmt:timeZone value="Asia/Shanghai">
	<fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /><br>
</fmt:timeZone>

<br>
set timezone to US/Alaska
<fmt:setTimeZone value="US/Alaska" var="timezone"/>
timezone : ${timezone }<br>
<fmt:formatDate value="${now}" timeZone="${timezone }" type="both" dateStyle="full" timeStyle="full" />
</body>
</html>