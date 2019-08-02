<%@page import="kr.or.ddit.user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="kr.or.ddit.user.repository.UserDao"%>
<%@page import="kr.or.ddit.user.repository.IUserDao"%>
<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	response.setHeader("Content-Disposition", "attahchement; filename=line.xls");
	IUserDao userDao = new UserDao();
	List<UserVo> userList = userDao.getUserList();
%>
<table>
	<tr>
		<th>이름</th>
		<th>나이</th>
	</tr>
	<%for(UserVo userVo : userList){ %>
		<tr>
			<td><%=userVo.getUserName() %></td>
			<td></td>
		</tr>
	<%} %>
	
</table>
</body>
</html>




