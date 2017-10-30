<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, java.util.Map, mvc.model.BoardVo" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>작성일</th>
		</tr>
	</thead>
	<tbody>
	<% List<BoardVo> boardList = (List<BoardVo>)request.getAttribute("boardList");
		for(BoardVo vo : boardList){
	 %>
	 <tr>
	 	<td><%=vo.getSeq() %></td>
	 	<td><%=vo.getTitle() %></td>
	 	<td><%=vo.getReg_id() %></td>
	 	<td><%=vo.getReg_dt() %></td>
	 </tr>
	 <%} %>
	 </tbody>
</table>
</body>
</html>