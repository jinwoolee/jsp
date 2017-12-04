<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
isNew():<%= session.isNew()%><br/>
getCreationTime(): <%= new java.util.Date(session.getCreationTime()) %><br/>
getLastAccessedTime(): <%= new java.util.Date(session.getLastAccessedTime()) %><br/>
getId()[세션 ID]: <%= session.getId() %><br/>
getMaxInactiveInterval() <%= session.getMaxInactiveInterval() %> 초 <br/>

session.getAttribute("testStrSession") : <%= session.getAttribute("testStrSession") %><br/>
session.getAttribute("testStrSession") : ${testStrSession}<br/>

</body>
</html>