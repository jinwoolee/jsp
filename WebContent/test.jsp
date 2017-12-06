<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.dao.*"%>
<%@ page import="user.model.UserVo" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
	int number = 10000000;
	pageContext.setAttribute("number", number);
%>
<fmt:bundle basename="resource.message">
	<fmt:message key="GREETING" /> <br/>
	<fmt:message key="VISITOR" >
		<fmt:param value="brown"/> <br/> 
	</fmt:message>
</fmt:bundle>
<br/><br/><br/>	

<fmt:setLocale value="ko_kr"/>

<fmt:bundle basename="resource.message">
	<fmt:message key="GREETING" /> <br/>
	<fmt:message key="VISITOR" >
		<fmt:param value="brown"/> <br/> 
	</fmt:message>
</fmt:bundle>