<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	request.setAttribute("test", "test");
	RequestDispatcher rdp = request.getRequestDispatcher("/serverProgram/jsp/dispatchTarget.jsp");
	rdp.forward(request, response);
%>