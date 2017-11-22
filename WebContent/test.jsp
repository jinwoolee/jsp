<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
isNew():<%= session.isNew()%><BR>
getCreationTime(): <%= new java.util.Date(session.getCreationTime()) %><BR>
getLastAccessedTime(): <%= new java.util.Date(session.getLastAccessedTime()) %><BR>
getId()[세션 ID]: <%= session.getId() %><BR>
getMaxInactiveInterval() <%= session.getMaxInactiveInterval() %> 초 <BR>

</body>
</html>