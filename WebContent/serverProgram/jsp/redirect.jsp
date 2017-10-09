<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	System.out.println("redirect.jsp class parameter : " + request.getParameter("class"));
	request.setAttribute("test", "test");
	response.sendRedirect("./redirectTarget.jsp");
%>