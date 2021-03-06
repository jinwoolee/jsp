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
url : url 생성
<c:url value="URL" [var="변수명“] [scope="영역”]>
    <c:param name="파라미터명“ value="파라미터값” />
</c:u 
--%>
<c:url value="coreURL_target.jsp"/>
<br><br><br>

<c:url value="coreURL_target.jsp">
	<c:param name="userId" value="brown"/>
</c:url>
<br><br><br>

<c:url value="coreURL_target.jsp" var="coreUrl_target"/> <br>
<a href="${coreUrl_target}"> coreUrl_target </a><br/>

pageContext.getAttribute("coreUrl_target") : <%=pageContext.getAttribute("coreUrl_target") %>

<br>
<%--scope 속성 설정시 value, context는 반드시 /로 시작해야 한다.  --%>
<c:url var="sessionUrlVar" value="/hello.jsp" context="/jsp2" scope="session" />
sessionUrlVar : ${sessionUrlVar}<br>
</body>
</html>