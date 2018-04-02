<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<c:set var="number" value="123456789" /> 
<c:set var="number2" value="1000" />
<c:set var="number2" value="1000" />

number : <fmt:formatNumber value="${number }"/> <br/>
number : <fmt:formatNumber value="${number }" groupingUsed="false"/> <br/>
number : <fmt:formatNumber value="${number }" groupingUsed="false" maxIntegerDigits="5"/> <br/>
<br/>
number : <fmt:formatNumber value="${number2 }" type="number" /> <br/>
number : <fmt:formatNumber value="${number2 }" type="currency" currencySymbol="\\" /> <br/>
number : <fmt:formatNumber value="${number2 }" type="currency" currencyCode="KRW" /> <br/>
number : <fmt:formatNumber value="${1 }" type="percent" /> <br/>


<%-- parseNumber : 스트링 숫자 문자열 --> 숫자타입으로 변환 --%>
<%
	String stringNumber = "123,456,789";
	pageContext.setAttribute("stringNumber", stringNumber);
%>
<br/><br/>
\${stringNumber } ${stringNumber } : <fmt:parseNumber value="${stringNumber }"/> <br/>



<br/>
<fmt:setLocale value="de"/>
number : <fmt:formatNumber value="${number }" type="currency"  /> <br/>
number : <fmt:formatNumber value="${number }" type="currency"  /> <br/>





