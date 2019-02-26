<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- pageContext.setAttribute("num", 1000000); --%>
<c:set var="num" value="1000000"/>

<%-- number --> foramtted string --%>
<h2>ko</h2>
<fmt:setLocale value="ko_kr"/>
<%-- type : number, percent, currency --%>
ko number : <fmt:formatNumber value="${num }" type="number"/> <br> 
ko percent : <fmt:formatNumber value="1" type="percent"/> <br>
ko currency : <fmt:formatNumber value="${num }" type="currency"/> <br>


<h2>de</h2>
<fmt:setLocale value="de_de"/>
de number : <fmt:formatNumber value="${num }" type="number"/> <br>
de percent : <fmt:formatNumber value="1" type="percent"/> <br>
de currency : <fmt:formatNumber value="${num }" type="currency"/> <br>


<%-- formatted string --> number : parsing --%>
<h2>formatted string -- number</h2>
<fmt:setLocale value="ko_kr"/>
parseNumber : <fmt:parseNumber value="1,000,000"/>
</body>
</html>














