<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="log" tagdir="/WEB-INF/tags" %>
<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
%>

<%
	pageContext.setAttribute("testString", "testString");
%>

test <br/>
<log:bodyTest>
	test : ${testString }<br/>
	var from tag : ${varFromTag } <br/>

	
</log:bodyTest>

<br/>
after end tag : ${varFromTag } <br/><br/>

<c:if test="true">
	<%=pageContext.getAttribute("testString") %>
</c:if>



