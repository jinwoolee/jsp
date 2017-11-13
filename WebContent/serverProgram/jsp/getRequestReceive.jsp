<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@page import="java.util.Enumeration,java.util.Map,java.util.Set,java.util.Iterator"%>

<!-- pageEncoding : jsp 파일 작성에 대한 인코딩 -->
<!-- charset : jsp 파일 출력시의 인코딩 / contentType 헤더 설정값 -->

<!-- html charset 결정순서 
 1. Content-Type 헤더
 2. META http-equiv  Content-Type과 charset 속성
 3. charset 속성
 -->

<!DOCTYPE html>
<html>
<head>
<!--  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">-->
<meta charset="utf-8"> 
<title>Insert title here</title>

</head>
<body>
<!-- web.xml 의 setCharacterEncodingFilter 활성화 -->

userId : <%= request.getParameter("userId") %> <br/>
password : <%= request.getParameter("password") %> <br/>

<h4>reuqest parameter</h4>
request.getParameter("userId") <%= request.getParameter("userId") %> <br/>
request.getParameterValues("userId")
<% for(String str : request.getParameterValues("userId")){%>
		<%= str%>
<%}%>		
<br/>

request.getParameterNames() 
<% Enumeration enumeration = request.getParameterNames();
	while(enumeration.hasMoreElements()){ %>
		<%= enumeration.nextElement()%>
<%}%>
<br/>

request.getParameterMap()
<% Map map = request.getParameterMap();
	Set set = map.keySet();
	Iterator iterator = set.iterator();
	while(iterator.hasNext()){ 
		String key = (String)iterator.next();%>
		<%=key + " : " + map.get(key) %>
	<% }%>
<br/>

<h4>request header</h4>
request.getHeader("Accept") : <%= request.getHeader("Accept") %> <br/>
request.getHeaderNames() : 
<% Enumeration enumerationHeaders = request.getHeaderNames();
	while(enumerationHeaders.hasMoreElements()){ %>
		<%= (String)enumerationHeaders.nextElement()%> /
<%}%>


</body>
</html>