<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.HashMap, java.util.List, java.util.ArrayList, mvc.model.BoardVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<% 
	String code = "05";
	request.setAttribute("code", code);
%>

<%--
<c:if test="검사조건"> 
java if 구문, else가 없기 때문에 제한적으로 사용
--%>
<c:if test="${code} == '05'">
	code ${code}
</c:if>

<%--
<c:choose>, <c:when>, <c:otherwise> java 의 if else 
--%>
<c:choose>
	<c:when test="${code}=='01'"> choose when code 01 </c:when>
	<c:when test="${code}=='02'"> choose when code 02 </c:when>
	<c:when test="${code}=='03'"> choose when code 03 </c:when>
	<c:when test="${code}=='04'"> choose when code 04 </c:when>
	<c:when test="${code}=='05'"> choose when code 05 </c:when>
	<c:otherwise> choose other wise code ${code}</c:otherwise>
</c:choose>
<br/><br/><br/>

<%-- foreach
<c:forEach var="블럭변수" items=“집합객체" varStatus="상태객체변수">
   반복 구문
</c:forEach>     

<c:forEach var="블럭변수" begin="시작값" end="종료값“ step="증가치">
   반복 구문
</c:forEach>  
 --%>
<%
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
List<BoardVo> boardList = new ArrayList<BoardVo>();
for(int i = 1; i <= 10; i++)
	boardList.add(new BoardVo(i, "게시글 제목" + i, "게시글내용입니다", "userId", sdf.format(new Date())));
request.setAttribute("boardList", boardList); 
%>
<c:forEach items="${boardList}" var="vo" varStatus="status"> 
	${vo.seq} / 	${vo.title} / ${vo.reg_id} / ${vo.reg_dt} / ${status.index} <br/>
</c:forEach>
<br/><br/><br/>

<c:forEach var="i" begin="1" end="10">
	${i}&nbsp;
</c:forEach>
<br/><br/><br/>

<c:forEach var="i" begin="1" end="10" step="4">
	${i}&nbsp;
</c:forEach>
<br/><br/><br/>

<%--varStatus
index : 루프 실행에서 현재 인덱스
count : 루프 실행 횟수
begin : begin속성 값
end   : end 속성 값
step  : step 속성 값
first : 현재 실행이 첫 번째 실행인 경우 true
last  : 현재 실행이 루프의 마지막 실행인 경우 true
current : 컬렉션 중 현재 루프에서 사용할 객체
 --%>
 
<c:forEach items="${boardList}" var="vo" begin="0" end="6" step="2" varStatus="status">
	${vo.seq} / 	${vo.title} / ${vo.reg_id} / ${vo.reg_dt} / ${status.index} <br/>
</c:forEach>
<br/><br/><br/>

<%--map --%>
<%
	Map<String, Object> map = new HashMap<String, Object>();
	map.put("userId", "brown");
	map.put("birthDate", "2011-11-01");
	map.put("home", "daejeon");
	request.setAttribute("map", map);
%>
<c:forEach items="${map}" var="m">
	${m.key} / ${m.value}
</c:forEach>
<br/><br/><br/>

<%-- forTokens : java의 StringTokenizer --%>
<% request.setAttribute("lineRangers", "brown,cony,sally,james,jesica"); %>
LineRangers
<c:forTokens items="${lineRangers}" delims="," var="i">
	${i}&nbsp;
</c:forTokens>

</body>
</html>