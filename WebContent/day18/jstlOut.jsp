<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:out> : 화면출력 --%>
<%
	String code="01";
	pageContext.setAttribute("code", code);		
%>
\${code} : ${code}<br/>
<c:out value="${code }"/> <br/>
<c:out value="${code2 }" default="05"/> <br/>