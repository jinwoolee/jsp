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

<%--locale 설정에 따라 표현 변경 --%>
<fmt:setLocale value="en" scope="request" />

<c:set var="now" value="<%= new java.util.Date() %>" />
dateStyle full : <fmt:formatDate value="${now}" type="date" dateStyle="full" /> <br/>
dateStyle short : <fmt:formatDate value="${now}" type="date" dateStyle="short" /> <br/>
dateStyle default :  <fmt:formatDate value="${now}" type="time" /> <br/>
dateStyle / timeStyle : <fmt:formatDate value="${now}" type="both" dateStyle="full" timeStyle="full" /> <br/>
pattern <fmt:formatDate value="${now}" pattern="z a h:mm" /> <br/><br/>

<%--문자열을 date형으로 변환 --%>
<fmt:parseDate value="2017-10-30 15:00:00" pattern="yyyy-MM-dd HH:mm:ss" var="date" />
${date}

</body>
</html>