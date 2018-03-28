<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	pageContext.setAttribute("pageContext_Scope", request.getParameter("page"));
	request.setAttribute("request_Scope", request.getParameter("request"));
	session.setAttribute("session_Scope", request.getParameter("session"));
	application.setAttribute("application_Scope", request.getParameter("application"));
	
	RequestDispatcher rdp = request.getRequestDispatcher("scopePrint.jsp");
	rdp.forward(request, response);
%>