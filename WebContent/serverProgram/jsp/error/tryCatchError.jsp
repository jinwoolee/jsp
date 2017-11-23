<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true" errorPage="errorPage.jsp"%>

<%
	try{
		throw new Exception();
	}catch(Exception e){
		//이동하고자 하는 path의 page는 jsp page 지시자의 isErrorPage="true"가 아닌 보통의 jsp 페이지여야한다. 
		RequestDispatcher rd = request.getRequestDispatcher("errorPage_no.jsp");
		rd.forward(request, response);
	}
%>