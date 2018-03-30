<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--locale 설정에 따라 표현 변경 --%>
<%--<fmt:setLocale value="en_us" scope="request" />
<fmt:setLocale value="en" scope="request" /> --%>
<fmt:setLocale value="ko_kr" scope="request" />

<c:set var="price" value="10000" />

<fmt:formatNumber value="${price}" type="number" var="numberType" /><br>
숫자: ${numberType} <br>

통화: <fmt:formatNumber value="${price}" type="currency" /><br>
퍼센트: <fmt:formatNumber value="${price}" type="percent" groupingUsed="false" /><br>
패턴: <fmt:formatNumber value="${price}" pattern="00000000.00"/><br><br>

<%--문자형을 숫자형으로 --%>
parseNumber<br>
<fmt:parseNumber value="1,100.12"/><br>
<fmt:parseNumber value="1,100.12" pattern="0,000.00" var="num"/>
num : ${num}
</body>
</html>