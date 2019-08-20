<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- 속성 설정 -->
<%--
	request.setAttribute("속성명", 속성값);
	session.setAttribute("속성명", 속성값);
	application.setAttribute("속성명", 속성값);
 --%>
<h2>core : set</h2>
<%--
	var : 속성명
	value : 속성값
	scope : 속성을 지정할 영역(값을 생략하면 page scope가 적용)
	
	pageContext.setAttribute("userId", "brown") 
--%>
<c:set var="userId" value="brown" />
userId : ${userId } <br>

page : <%=pageContext.getAttribute("userId") %> / ${pageScope.userId} <br>
request : <%=request.getAttribute("userId") %> / ${requestScope.userId }<br>
session : <%=session.getAttribute("userId") %> / ${sessionScope.userId}<br>
application : <%=application.getAttribute("userId") %> / ${applicationScope.userId} <br>


</body>
</html>










