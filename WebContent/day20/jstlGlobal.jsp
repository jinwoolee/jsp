<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="loc" value="${param.locale == null ? 'ko' : param.locale }"/>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.2.1.js"></script>
<script>
$(function(){
	//locale selectbox change event
	//select box 변경시 해당 로케일을 파라미터로 전송
	$("#localeSelBox").on("change", function(){
		$("form").submit();
	});		
	
	//locale selectbox에 로케일 값 설정
	$("#localeSelBox").val("${loc}");
});
</script>
</head>
<body>
<%	
	session.setAttribute("userNm", "sally");
%>
\${locale} : ${locale} <br/>
\${param.locale} : ${param.locale} <br/>





<%--
1.select box 이벤트 등록 : jquery사용 
2.form 태그 선언
3.locale 파라미터 존재여부 확인하고.
<c:set var="loc" value="${param.locale == '' : "ko" : param.locale }"/>
   3-1 있으면 해당파라미터로 : <fmt:setLocale value="${loc}"/>
 --%>

<%--기본설정 --%>

<fmt:setLocale value="${param.locale }"/>
<fmt:bundle basename="resource.message" >
	<fmt:message key="HELLO"/> <br/><br/>
</fmt:bundle>


<%--setBundel : 매번 message태그를 감싸지 않고, 한번 호출하는 것으로 fmt:bundle 설정없이 message 사용가능--%>
<fmt:setBundle basename="resource.message" />
<fmt:message key="GREETING">
	<fmt:param value="${userNm }"/> <br/><br/>
</fmt:message>

<br/>
<form action="jstlGlobal.jsp">
	<select id="localeSelBox" name="locale">
		<option value="ko">한국어</option>
		<option value="en">English</option>
		<option value="ja">日本語</option>
	</select>
</form>	


<br/><br/>



<fmt:setLocale value="ja"/>
<fmt:bundle basename="resource.message" >
	<fmt:message key="HELLO"/> <br/><br/>
</fmt:bundle>

<fmt:setLocale value="en"/>
<fmt:bundle basename="resource.message" >
	<fmt:message key="HELLO"/> <br/>
</fmt:bundle>



<fmt:setLocale value="ko"/>
<fmt:bundle basename="resource.message" >
	<fmt:message key="GREETING">
		<fmt:param value="${userNm }"/>
	</fmt:message>
</fmt:bundle>

<br/><br/>

<%--setBundel : 매번 message태그를 감싸지 않고, 한번 호출하는 것으로 fmt:bundle 설정없이 message 사용가능--%>
<fmt:setBundle basename="resource.message" />
<fmt:message key="GREETING">
		<fmt:param value="${userNm }"/>
	</fmt:message>
</body>









</html>