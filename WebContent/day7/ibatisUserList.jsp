<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="user.dao.*, user.model.UserVo" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	IUserDao userDao = new UserDao();
	List<UserVo> userList = userDao.getUserList();
	
	for(UserVo vo : userList)
		out.println(vo + "<br/>");
%>
</body>
</html>