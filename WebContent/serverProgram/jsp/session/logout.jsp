<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//logout시 사용자 id를 세션에서 삭제한다.
	session.removeAttribute("userId");
	out.println("userId : " + session.getAttribute("userId") + "<br/>");
%>