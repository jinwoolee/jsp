<%@page import="java.util.ArrayList"%>
<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Map, java.util.List, mvc.model.BoardVo" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<style>
table, th, td {border : 1px solid black;}
table {margin-bottom : 15px;}
</style>
<title>Insert title here</title>
</head>
<body>

<%

	//map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		request.setAttribute("map", map);
		
		
		//list
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		for(int i = 1; i <= 10; i++)
			boardList.add(new BoardVo(i, "게시글 제목" + i, "게시글내용입니다", "userId", "2017-10-18"));
		request.setAttribute("boardList", boardList);
		
		//session
		session.setAttribute("sessionValue", "session-Value");
		session.setAttribute("sameValue", "sameValue-session");
		
		//request
		request.setAttribute("requestValue", "request-Value");
		request.setAttribute("sameValue", "sameValue-reuqest");
		
		request.setAttribute("totalCnt", 15);
		%>
cookie jsession id : ${JSESSIONID}
cookie jsession id : ${cookie.JSESSIONID}



<table>
	<caption>map attribute</caption>
	<thead>
		<tr>
			<th>표현식</th>
			<th>el</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td><% map = (Map)request.getAttribute("map"); %>
				<%=map.get("key") %></td>
			<td>${map.key}</td>
		</tr>
	</tbody>		
</table>		

<table>
	<caption>request</caption>
	<thead>
		<tr>
			<th>표현식</th>
			<th>el</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>	<%=request.getAttribute("requestValue")%></td>
			<td>${requestValue}</td>
		</tr>
	</tbody>
</table>

<table>
	<caption>session</caption>
	<thead>
		<tr>
			<th>표현식</th>
			<th>el</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>	<%=session.getAttribute("sessionValue")%></td>
			<td>${sessionValue}</td>
		</tr>
	</tbody>
</table>
		
<table>
	<caption>같은 EL</caption>
	<thead>
		<tr>
			<th>el</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${sameValue}</td>
		</tr>
	</tbody>		
</table>

<table>
	<caption>scope</caption>
	<thead>
		<tr>
			<th>el</th>
		</tr>
	</thead>
	<tbody>
		<tr>
			<td>${requestScope.sameValue}</td>
		</tr>
		<tr>
			<td>${sessionScope.sameValue}</td>
		</tr>
	</tbody>	
</table>

<table>
	<caption>list-표현식</caption>
	<% boardList = (List<BoardVo>)request.getAttribute("boardList");
	  for(BoardVo vo : boardList){
	%>
	 <tr>
	 	<td><%=vo.getSeq() %></td>
	 	<td><%=vo.getTitle() %></td>
	 	<td><%=vo.getReg_id() %></td>
	 	<td><%=vo.getReg_dt() %></td>
	 </tr>
	<%} %>
</table>


<table>
	<caption>list-표현식(jstl)</caption>
	<c:forEach items="${boardList}" var="vo"> 
	 <tr>
	 	<td>${vo.seq}</td>
	 	<td>${vo.title}</td>
	 	<td>${vo.reg_id}</td>
	 	<td>${vo.reg_dt}</td>
	 </tr>
	</c:forEach>
</table>

표현식 : 총 <%=request.getAttribute("totalCnt") %>건 입니다. <br/>
EL 총 ${totalCnt}건 입니다. <br/><br/>

연산 <br/>
5건 +, 총 ${totalCnt + 5} 건 입니다. <br/>
5건 -, 총 ${totalCnt - 5} 건 입니다. <br/>
5건 *, 총 ${totalCnt * 5} 건 입니다. <br/>
5건 /, 총 ${totalCnt / 5} 건 입니다. <br/>

그래서 20건입니다. true or false ? ${totalCnt==15} 
</body>
</html>