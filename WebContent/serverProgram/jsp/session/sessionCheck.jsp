<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	out.println("userId : " + session.getAttribute("userId"));
%>

<br/>

<a href="logout.jsp">logout</a>