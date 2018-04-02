<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.Set, java.util.Iterator, java.util.Enumeration" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String[] userIds = request.getParameterValues("userId");	
%>

request.getParameterNames() <br/>
<%
	Enumeration<String> enumeration = request.getParameterNames();
	while(enumeration.hasMoreElements()){
		String paramName = enumeration.nextElement();%>
	<%= paramName%> <br/>
<%} %>

<br/>

request.getParameterValues()<br/>
<%
	String[] userIdArray = request.getParameterValues("userId");
	for(int i = 0; i < userIdArray.length; i++){%>
		<%= userIdArray[i] %><br/>
<%} %>
<br/>


request.getParameterMap()  <br/>
<%
	Map<String, String[]> map = request.getParameterMap();
	Set<String> keys = map.keySet();
	Iterator<String> iterator = keys.iterator();
	
	while(iterator.hasNext()){
		String key = iterator.next(); 
%>
	<%-- key : value --%>
	<%= key%> : <%= map.get(key)%> <br/>
<%} %>

<br/><br/><br/>

user id : <%=  userIds[0] %> <br/>
user id : <%=  userIds[1] %> <br/>
password : <%=  request.getParameter("password")%> / <%= map.get("password")[0]%><br/>

</body>
</html>