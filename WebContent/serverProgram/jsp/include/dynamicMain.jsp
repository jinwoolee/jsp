<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	RequestDispatcher rd = request.getRequestDispatcher("header.jsp?fromDmValue=fromDmValue");
	rd.include(request, response);
%>
dynamicMain.jsp request.getParameter("fromDmValue") : <%= request.getParameter("fromDmValue")%> <br>

main 영역입니다.