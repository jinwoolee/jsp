<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:url> url을 작성해주는 jstl --%>
<c:url value="/login.jsp?userId=brown" /> <br/>

<%-- var 속성을 넣을경우 화면에 출력되지 않음 --%>
<c:url value="/login.jsp" var="loginURL" scope="page">
	<c:param name="userId" value="brown"/>
</c:url>
${loginURL } <br/>
표현식으로 : <%= pageContext.getAttribute("loginURL")%> <br/> 

<br/>

<%-- <c:redirect> --%>
<c:redirect url="/login.jsp"/>