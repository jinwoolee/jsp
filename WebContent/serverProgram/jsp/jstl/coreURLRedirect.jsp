<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, mvc.model.BoardVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
redirect
 <c:redirect url="주소" [context] >
    <c:param name="파라미터명" value="값" />
</c:redire>
 --%>

<c:redirect url="coreURL_target.jsp" >
    <c:param name="userId" value="cony" />
</c:redirect>

<%-- 
<c:redirect url="/coreURL_target.jsp" context="/jsp">
http://localhost:8080/jsp/coreURL_target.jsp?userId=cony
--%>
</body>
</html>