<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.dao.*"%>
<%@ page import="user.model.UserVo" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ include file="/commonJsp/jquery.jsp" %>

<c:set var="lang" value="${param.langSelect == '' ? 'ko' : param.langSelect}" />

<script>
$(function(){
	$("#langSelect").on("change", function(){
		$("#frm").submit();
	});
	
	$("#langSelect").val("${lang}");
});
</script>

response.getLocale() : <%=response.getLocale() %> <br/>
\${lang} : ${lang} <br/>


<%
	int number = 10000000;
	pageContext.setAttribute("number", number);
	response.setLocale(new Locale("ko"));
	
%>


<fmt:setLocale value="ja"/>
<fmt:bundle basename="resource.message" >
	<fmt:message key="GREETING" /> <br/>
	<fmt:message key="VISITOR" >
		<fmt:param value="brown"/> <br/> 
	</fmt:message>
</fmt:bundle>

<fmt:setBundle basename="resource.message" var="bundle"/>
<fmt:message bundle="${bundle}" key="GREETING" var="greeting" />



<br/><br/><br/>	


<fmt:setLocale value="ja"/>
response.getLocale() : <%=response.getLocale() %> <br/>

<fmt:bundle basename="resource.message">
	<fmt:message key="GREETING" /> <br/>
	<fmt:message key="VISITOR" >
		<fmt:param value="brown"/> <br/> 
	</fmt:message>
</fmt:bundle>

<form id="frm" action="${pageContext.request.contextPath}/test.jsp" >
	<select id="langSelect" name="langSelect" >
		<option value="ko">한국어</option>
		<option value="en">english</option>
		<option value="ja">日本語</option>
	</select>
</form>

<br/> <br/>
date <br/>

<%
	Date date = new Date(1511913808000L);
	//Date date = new Date();
	SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
	
	pageContext.setAttribute("date", date);
%>
sdf.format(date) : <%= sdf.format(date)%> <br/>


<fmt:formatDate value="${date }" type="date" dateStyle="full" var="test"/> <br/>
${test}<br/>
dateStyle full : <fmt:formatDate value="${date }" type="date" dateStyle="full" /> <br/>
dateStyle both- full : <fmt:formatDate value="${date }" type="both" dateStyle="full" /> <br/>





