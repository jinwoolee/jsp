<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.Reader, java.io.IOException, java.sql.SQLException, java.util.List" %>
<%@ page import="user.model.UserVo, user.dao.*" %>
<%@ page import="com.ibatis.common.resources.Resources, com.ibatis.sqlmap.client.SqlMapClient, com.ibatis.sqlmap.client.SqlMapClientBuilder" %>

<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	UserDao userDao = new UserDaoImpl();			
	List<UserVo> userList = userDao.getUserList();
	
	for(UserVo vo : userList)
		out.print(vo.getUserId() + " / " + vo.getUserNm() + " / " + vo.getPass() + "<br/>");
		
%>

</body>
</html>