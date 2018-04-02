<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%--
<%
	String str1	= "test string";
	pageContext.setAttribute("str1", str1);
%>
 %><c:set var="str1" value="<%=str1 %>"/>
  --%>
  
<c:set var="str1" value="test string"/>

<%--fn 함수 적용
length(obj) : 
toUpperCase(str)
toLowerCase(str)
substring(str, idx1, idx2)
substringAfter(str1, str2)
substringBefore(str1, str2)
trim(str)
replace(str, src, dest)
indexOf(str1, str2)
startsWith(str1, str2)
endsWith(str1, str2)
contains(str1, str2)
containsIgnoreCase(str1, str2)
split(str1, str2)
join(array, str2)
escapeXml(str)
 
--%>
\${str1} : ${str1} <br/>
\${fn:length(str1)} : ${fn:length(str1)} <br/>
\${fn:toUpperCase(str1)} : ${fn:toUpperCase(str1)} <br/>
\${fn:toLowerCase(str1)} : ${fn:toLowerCase(str1)} <br/>
\${fn:contains(str1, 'test')} : ${fn:contains(str1, 'test')}












