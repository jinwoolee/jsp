<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="now" value="<%=new Date() %>"/>
format date : <fmt:formatDate value="${now }" type="both"/> <br>

<fmt:timeZone value="Asia/Bangkok">
format date : <fmt:formatDate value="${now }" type="both"/> <br>
</fmt:timeZone>

</body>
</html>









