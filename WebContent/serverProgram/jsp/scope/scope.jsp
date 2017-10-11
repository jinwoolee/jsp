<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	pageContext.setAttribute("pageContext_Scope", "pageContext_Scope");
	request.setAttribute("request_Scope", "reuqest_Scope");
	session.setAttribute("session_Scope", "session_Scope");
	application.setAttribute("application_Scope", "application_Scope");
	
	RequestDispatcher rdp = request.getRequestDispatcher("scopeRequest.jsp");
	rdp.forward(request, response);
%>