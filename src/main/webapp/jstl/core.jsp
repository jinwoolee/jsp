<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="kr.or.ddit.rangers.service.RangersService"%>
<%@page import="kr.or.ddit.rangers.model.RangerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<%--
	jstl을 사용 하기 위한 준비 : jsp 디렉티브(taglib)를 이용하여 사용하고자 하는 라이브러리 선언
						   prefix = "임의로 작성 가능하나 일반적으로 사용하는 이름 권장"
						             core : c, format : fmt, function : fn 
						   uri = "자동완성기능"
 --%>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- url : localhost/jstl/core.jsp --%>


<h2>core : set</h2>
<%-- 특정 scope(page, request, session, application)에 속성을 생성
	 기본 scope : page --%>

<%--
	pageContext.setAttribute("userId", "brown");
	session.setAttribute("userId", "brown");
 --%>
 
<%
	RangerVo rangerVo = new RangerVo("brown", "브라운", 8);
	session.setAttribute("ranger", rangerVo);
%> 
<c:set var="userId" value="brown" scope="session"/>

userId(표현식-page) : <%=pageContext.getAttribute("userId") %> <br>
userId(표현식-session) : <%=session.getAttribute("userId") %> <br>
userId(el) : ${userId } <br><br>
===================================== <br>

<c:set target="${ranger }" property="age" value="10"/>
ranger - 나이 변경 : ${ranger } <br>

<%--
	pageContext.setAttribute("test", new RangerVo("brown", "브라운", 15)); 
 --%>
객체생성 <c:set var="test" value="<%=new RangerVo(\"brown\", \"브라운\", 15) %>" />
test : ${test } <br>

<%--
	pageContext.removeAttribute("test"); 
--%>
<c:remove var="test"/>
test : ${test } <br>

<h2>core - if</h2>
<%--pageContext에 code 속성 추가 --%>
<c:set var="code" value="01" />

<c:if test="${code == '00' }">
	<span>code가 00 값입니다</span>
</c:if>

<c:if test="${code == '01' }">
	<span>code가 01 값입니다</span>
</c:if>

<h2>core - choose</h2>
<%-- request.setAttribute("code", "03") --%>
<c:remove var="code"/>
<c:set var="code" value="03" scope="request"/>
<c:choose>
	<c:when test="${code == '00' }"> code가 ${code} 00 입니다</c:when>
	<c:when test="${code == '01' }"> code가 ${code} 01 입니다</c:when>
	<c:when test="${code == '02' }"> code가 ${code} 02 입니다</c:when>
	<c:when test="${code == '03' }"> code가 ${code} 03 입니다</c:when>
	<c:when test="${code == '04' }"> code가 ${code} 04 입니다</c:when>
	<c:otherwise>code가 ${code} else 입니다</c:otherwise>
</c:choose>

<h2>core - forEach</h2>
<%
	RangersService rangersService = new RangersService();
	request.setAttribute("rangersList", rangersService.getRangerVoAll());
%>
<h3>향상 for 문</h3>
<c:forEach items="${rangersList }" var="ranger">
	${ranger.name } / ${ranger.alias } / ${ranger.age } <br> 
</c:forEach>

<h3>일반 for 문</h3>
<%-- for(int i = 0; i <= 10; i+=2)
 	 for(int i = 10; i >= 0; i--)  --%>
<c:forEach begin="0" end="10" varStatus="staus" step="1" >
	<span> test ${staus.index }</span><br> 
</c:forEach>

<%--
	for(int i = 0; i < rangerList.size(); i++)
		System.out.println(rangerList.get(i).name);
 --%>
<c:forEach var="i" begin="0" end="${rangersList.size()-1 }">
	${rangersList.get(i).name } / ${rangersList.get(i).alias } / ${rangersList.get(i).age } <br>
</c:forEach>


<h2>core - forEach (map)</h2>
<%
	Map<String, String> map = new HashMap<String, String>();
	map.put("ranger1", "brown");
	map.put("ranger2", "cony");
	map.put("ranger3", "sally");
	pageContext.setAttribute("map", map);
%>
<c:forEach items="${map }" var="entry">
	${entry.key } / ${entry.value } <br>
</c:forEach>

<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>
<br>	
</body>
</html>












