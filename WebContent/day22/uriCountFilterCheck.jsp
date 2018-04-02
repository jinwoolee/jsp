<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--el : 별도를 표기 하지 않는경우 -> 속성
    속성의 4가지영역 (pageContext, request, sessioin, applicatioin)중
    범위가 작은곳 부터 범위가 넓은 순으로 순차적으로 속성을 탐색
    pageContext --> application
 --%>
<%--
application에 속성으로 존재하는 uriCountMap 객체를 jstl forEach를 사용하여
라인 단위로 출력 --%>

<%
	Map<String,Integer> uriCountMap = (Map<String,Integer>)application.getAttribute("uriCountMap");
%>
${uriCountMap.keys} 

<br/><br/><br/>

<c:forEach var="entry" items="${uriCountMap}"> 
${entry.key } : ${entry.value } <br/>
</c:forEach>
</body>
</html>






