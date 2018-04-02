<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- 호출부로 전달될 변수명 --%>

<%--scope
NESTED : 호출하는 태그 안쪽(시작태그-종료태그)
AT_BEGIN : 호출하는 태그부터 -
AT_END : 종료료 태그부터

 --%>


<%@ attribute name= "from"%>
<%@ attribute name= "to"%>

<%@ variable name-given="result" variable-class="java.lang.Integer" scope="NESTED"%>

<c:set var="sum" value="${0}"/>
<c:set var="i" value="${from}"/>

<c:forEach begin="${from}" end="${to}">
	<c:set var="sum" value="${sum + i}"/>
	<c:set var="i" value="${i+1 }"></c:set>
</c:forEach>

<c:set var="result" value="${sum }"/>

<jsp:doBody/>

<%--
tag 파일에서 출력을 한겁니다. --> 변수를 호출부로 전달을
${sum } --%>








