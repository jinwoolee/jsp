<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.ArrayList" %>
<%@ page import="day5.UserVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	//service -> dao  
	//List<UserVo> userList <--
	
	//List<UserVo> userList = service.getUserList();
	
	List<UserVo> userList = new ArrayList<UserVo>();
	userList.add(new UserVo("brown", "브라운", "brownpass", "system"));
	userList.add(new UserVo("cony", "코니", "conypass", "system"));
	userList.add(new UserVo("sally", "샐리", "sallypass", "system"));
%>

<table>
	<tr>
		<th>사용자 이름</th>
		<th>사용자 비밀번호</th>
		<th>사용자 등록자</th>
		<th>사용자 아이디</th>
	</tr>
	<!-- jsp 스크립틀릿을 이용하여 loop를 통해 userList의 값을 아래 tr/td를 이용하여 화면에 출력 -->
	
	<%
		for(UserVo vo : userList){
			out.println("<tr>");
			out.println("<td>" + vo.getUserNm() + "</td>");
			out.println("<td>" + vo.getPass() + "</td>");
			out.println("<td>" + vo.getReg_id() + "</td>");
			out.println("<td>" + vo.getUserId() + "</td>");
			out.println("</tr>");
		}
	%>
	
</table>
</body>
</html>
