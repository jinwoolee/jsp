<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, mvc.model.BoardVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	session.setAttribute("userId", "brown");
%>

<%--
locale 설정 
value : locale의 국가코드 형식 
scope : 지정한 locale이 영향을 미치는 범위 (default : page)
웹브라우저가 송한 Accept-laguage 헤더의 값을 사용
--%>
<fmt:setLocale value="ko" scope="request" />

<%--
bundle, message
<fmt:bundle basename="kr.or.ddit.msgs.message" prefix="webBiz.">
     <fmt:message key="title">
            <fmt:param value="메시지 아규먼트값"/>
     </fmt:message>
</fmt:bundle>
--%>

  
<fmt:bundle basename="resource.message">
	<fmt:message key="GREETING"/> </br>
	<fmt:message key="VISITOR"> </br>
		<fmt:param value="${userId}"/>
	</fmt:message>
</fmt:bundle>

<fmt:setLocale value="en" scope="request" />
<fmt:bundle basename="resource.message">
	<fmt:message key="GREETING"/> </br>
	<fmt:message key="VISITOR">	</br>
		<fmt:param value="${userId}"/>
	</fmt:message>
</fmt:bundle> 
<br/><br/>


<fmt:setLocale value="ko" scope="request" />
<fmt:setBundle basename="resource.message" var="message"/>
<fmt:message bundle="${message}" key="GREETING"/>
<br/><br/>

<fmt:setLocale value="en" scope="request" />
<fmt:setBundle basename="resource.message" var="message"/>
<fmt:message bundle="${message}" key="GREETING"/>





</body>
</html>