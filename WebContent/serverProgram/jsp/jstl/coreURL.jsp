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
url : url 생성http://marketplace.eclipse.org/marketplace-client-intro?mpc_install=7117
<c:url value="URL" [var="변수명“] [scope="영역”]>
    <c:param name="파라미터명“ value="파라미터값” />
</c:u 
 --%>
<c:url value="coreURL_target.jsp"/>
<br/><br/><br/>

<c:url value="coreURL_target.jsp">
	<c:param name="userId" value="brown"/>
</c:url>
<c:out value="${brown }" />
<br/><br/><br/>
 

<c:url value="coreURL_target.jsp" var="coreUrl_target"/> <br/>
<a href="${coreUrl_target}"> coreUrl_target </a>

<%--scope 속성 설정시 value, context는 반드시 /로 시작해야 한다.  --%>
<c:url var="sessionUrlVar" value="/hello.jsp" context="/jsp2" scope="session" />
${sessionUrlVar}<br/>

<c:import url="coreURL_target.jsp" var="var">
	<c:param name="userId" value="brown"/>
</c:import>
${var}<br/><br/>


<%-- 네이버 검색결과 가져오기  --%>
<c:import var="inputHiddenVar" url="https://search.naver.com/search.naver" >
	<c:param name="where" value="nexearch"/>
	<c:param name="sm" value="top_hty"/>
	<c:param name="fbm" value="1"/>
	<c:param name="ie" value="utf8"/>
	<c:param name="query" value="input hidden"/>
</c:import>
${inputHiddenVar }<br/>

<%--google 검색결과를 받아올 수 없다. --%>
<%--
<c:import var="inputHiddenVar" url="https://www.google.co.kr/search">
	<c:param name="q" value="site:okky.kr input hidden"/>
</c:import>
${inputHiddenVar }<br/>
--%>


 
</body>
</html>