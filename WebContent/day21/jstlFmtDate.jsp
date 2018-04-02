<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--EL 객체명(param, paramValues, header, headerValues, coookie)을 표현하지 않으면
      속성에 값을 가져온다.
      속성의 영역 4가지 : pageContext, request, session, application 
                  --->       --->      --->    --->  
      --%>
      
<%--formatDate 예제--%> 
<%
	java.util.Date date = new Date();
	out.println("date = " + date + "<br/>");
%>

<c:set var="date" value="<%= date%>" scope="request"/> 


Expression : <%=date %> <br/>
\${date}  : ${date} <br/>

<%-- formatDate : date 속성의 객체를 포맷팅하여 출력
	value : 표현하고자 하는 date 객체
	type : default(date), both, date, time
	dateStyle : FULL, LONG, MEDIUM, SHORT, DEFAULT(MEIDUM) (java.text.DateFormat 참고)
	timeZone : 시간대설정
 --%>

<br/><br/><br/>
<fmt:setLocale value="en"/>
date : <fmt:formatDate value="${date }" /> <br/>
date : <fmt:formatDate value="${date }" type="date"/> <br/>
date : <fmt:formatDate value="${date }" type="time"/> <br/>
date : <fmt:formatDate value="${date }" type="both" /> <br/>

<br/>
date : <fmt:formatDate value="${date }" type="both" dateStyle="FULL"/> <br/>
date : <fmt:formatDate value="${date }" type="both" dateStyle="LONG"/> <br/>
date : <fmt:formatDate value="${date }" type="both" dateStyle="MEDIUM"/> <br/>
date : <fmt:formatDate value="${date }" type="both" dateStyle="SHORT"/> <br/>
date : <fmt:formatDate value="${date }" type="both" dateStyle="DEFAULT"/> <br/>

date : <fmt:formatDate value="${date }" type="both" dateStyle="FULL" timeZone="HongKong"/> <br/>
date : <fmt:formatDate value="${date }" type="both" dateStyle="FULL" timeZone="Canada/Pacific"/> <br/>

<br/>
date : <fmt:formatDate value="${date }" type="date" pattern="yyyy-MM-dd"/> <br/>
date : <fmt:formatDate value="${date }" type="date" pattern="yyyy/MM/dd" /> <br/>

<%--parseDate : string -> Date --%>
<%
	String dateStr = "2017.12.15 17:20";
	request.setAttribute("dateStr", dateStr);
%>

dateStr : <fmt:parseDate var="varDateStr" value="${dateStr}" pattern="yyyy.MM.dd HH:mm" /> <br/>
${varDateStr} <br/>


<br/>
<%
	//사용 가능한 timezone ID 출력
	for(String str : java.util.TimeZone.getAvailableIDs())
		out.println(str + "<br/>");
%>













