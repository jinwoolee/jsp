<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:import> url 속성을 include, 혹은 var 변수에 저장 --%>

jstlImport.jsp
****************************
<%--
<c:import url="https://search.naver.com/search.naver">
	<c:param name="where" value="nexearch"/>
	<c:param name="sm" value="top_hty"/>
	<c:param name="fbm" value="1"/>
	<c:param name="ie" value="utf8"/>
	<c:param name="query" value="input hidden"/>
</c:import>
 --%> 

<c:import url="https://www.google.co.kr/search">
	<c:param name="q" value="site:okky.kr input hidden"/>
	<c:param name="gws_rd" value="cr"/>
	<c:param name="dcr" value="0"/>
	<c:param name="ei" value="n5knWpPiIMvI0AS8m4KIDw"/>
</c:import>

