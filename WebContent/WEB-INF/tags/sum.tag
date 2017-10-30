<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ attribute name="begin" required="true" type="java.lang.Integer" %>
<%@ attribute name="end" required="true" type="java.lang.Integer" %>

<%@ variable name-given="sum_" variable-class="java.lang.Integer" scope="NESTED" %>
<%--
name-given : 이 태그를 호출한 페이지에 추가될 변수 이름
variable-class : 추가될 변수의 타입

scope
AT_BEGIN : 태그파일의 시작태그 시점부터 태그 파일에서 추가한 변수를 사용할 수 있다.
NESTED   : 태그 파일의 시작 태그와 끝 태그 사이에서 추가한 변수를 사용할 수 있다. 
AT_END   : 태그 파일의 끝 내그 이후부터 변수를 사용 할 수 있다.
--%>

<c:set var="sum_" value="0" />
<c:forEach var="num" begin="${begin}" end="${end}">
	<c:set var="sum_" value="${sum_ + num}" />
</c:forEach>
<jsp:doBody />