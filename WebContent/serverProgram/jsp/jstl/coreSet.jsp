<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, mvc.model.BoardVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%--
<c:set>
EL 변수의 프로퍼티 값지정
<c:set var="변수명" value="" scope="" />
var : 값을 지정한 EL변수
value : 변수의 값, 표현식, EL, 텍스트
scope : 변수를 저장한 영역(page, request, session, application)
--%>

<c:set var="userId" value="user_id" scope="request"/> 
${userId} <br/>
<%=request.getAttribute("userId")%> <br/>


<%--
<c:set target="대상객체" property="프로퍼티명" value="값“ />
target에 변수명만 표시하는것이 아니라 el혀앹로 설정
--%>
<%
BoardVo vo = new BoardVo(0, "게시글 제목" , "게시글내용입니다", "userId", "2017-10-18");
request.setAttribute("vo", vo);
%>

${vo}<br/>

<%-- <c:set target="<%=vo%>" property="seq" value="100" />--%>
<c:set target="${vo}" property="seq" value="105" />
${vo}<br/>


<%--remove --%>
<c:remove var="vo"/>
remove : ${vo}<br/>
</body>
</html>