<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="day4.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	
	List<UserVo> userList = new ArrayList<UserVo>();
	userList.add(new UserVo("brown", "브라운", "brownpass", "system"));
	userList.add(new UserVo("cony", "코니", "conypass", "system"));
	userList.add(new UserVo("sally", "샐리", "sallypass", "system"));
%>

<table>
	<tr>
		<th>ID</th>
		<th>이름</th>
		<th>pass</th>
		<th>등록자</th>
	</tr>
	
	<% for(int i = 0; i < userList.size(); i++){
		UserVo vo = userList.get(i);%>
	<tr>
		<td><%= vo.getUserId() %></td>
		<td><%= vo.getUserNm() %></td>
		<td><%= vo.getPass() %></td>
		<td><%= vo.getReg_id() %></td>
	</tr>
	<%} %>
	
	<% for(UserVo vo : userList){%>
	<tr>
		<td><%= vo.getUserId() %></td>
		<td><%= vo.getUserNm() %></td>
		<td><%= vo.getPass() %></td>
		<td><%= vo.getReg_id() %></td>
	</tr>
	<%} %>
	
</table>
</body>
</html>