<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	out.println("pageContext.getAttribute(\"pageContext_Scope\") : " + pageContext.getAttribute("pageContext_Scope") + "<br/>");
	out.println("request.getAttribute(\"request_Scope\") : " + request.getAttribute("request_Scope") + "<br/>");
	out.println("session.getAttribute(\"session_Scope\") : " + session.getAttribute("session_Scope") + "<br/>");
	out.println("application.getAttribute(\"application_Scope\") : " + application.getAttribute("application_Scope") + "<br/>");
%>