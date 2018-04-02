<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="day3.BoardService, day3.BoardVo" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	BoardService boardService = new BoardService();
	List<BoardVo> boardList = boardService.getBoardList();
	
	for(int i = 0; i < boardList.size(); i++){
%>
	<%= boardList.get(i) %> <br/>
<%} %>

<br/><br/><br/><br/>
<%
	for(BoardVo boardVo : boardList){%>
	<%= boardVo %> <br/>

<%} %>
</body>
</html>






