<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>

<%
	RequestDispatcher rdp = request.getRequestDispatcher("header.jsp");
	rdp.include(request, response);
%>

main 영역입니다.