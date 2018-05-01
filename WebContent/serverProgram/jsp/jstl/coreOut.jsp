<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, mvc.model.BoardVo" %>
<%@ page import="java.io.IOException, java.io.FileReader" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
out : jspWriter 출력
<c:out value="outValue" [escapeXml="true|false"] [default="default_value"] />
escapeXml : < > & ' " xml에서 사용할수 없는 문자열을 치환
default : 값이 없을경우 대체되는 값  
 --%>

<% 
	request.setAttribute("userId", "brown");
%>
<c:out value="${userId}" default="cony"/><br>
<c:out value="${noUserId}" default="cony"/><br>

<input type="text" value ='<c:out value="${noUserId}" default="cony"/>' >

 <%
    FileReader reader = new FileReader(getServletContext().getRealPath("serverProgram/jsp/jstl/coreURL_target.jsp"));
    FileReader reader2 = new FileReader(getServletContext().getRealPath("serverProgram/jsp/jstl/coreURL_target.jsp"));
    
    pageContext.setAttribute("reader", reader);
    pageContext.setAttribute("reader2", reader2);
%>

escape true : <br>
<%--<c:out value="<%=reader%>" escapeXml="true"/>--%>
<c:out value="${reader}" escapeXml="true"/>
<br><br>

escape false : <br>
<%--<c:out value="<%=reader2%>" escapeXml="false"/> --%>
<c:out value="${reader2}" escapeXml="false"/>

</body>
</html>