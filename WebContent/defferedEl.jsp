<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Date date = new Date();
	out.println("date : " + date + "<br/>");
	
	String str = "new string";
%>
<c:set var="testStr" value="string" />
str : ${testStr} <br/>

pageContext.getAttribute("testStr") : <%= pageContext.getAttribute("testStr") %>


<%--
<c:set var="elDate" value="${date}" />
<c:set var="defferedEldate" value="#{date}" />

<%
	//date.setTime(System.currentTimeMillis() -500000000);
%>
스크립틀릿 : <%= date %> <br/>
EL : ${elDate} <br/>
deffered EL ${defferedEldate} <br/>
 --%>
</body>
</html>