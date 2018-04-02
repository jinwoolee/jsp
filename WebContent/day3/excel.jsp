<%@ page language="java" contentType="application/vnd.ms-excel;charset=UTF-8" pageEncoding="UTF-8"%>
<%
    response.setHeader("Content-Disposition","attachment;filename=boardList.xls");    //디폴트 파일명 지정
    response.setHeader("Content-Description", "JSP Generated Data");
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<th>게시글 번호</th>
		<th>제목</th>
		<th>내용</th>
		<th>등록자</th>
		<th>등록일시</th>
	</tr>
	<tr>
		<td>1</th>
		<td>제목1</th>
		<td>내용1</th>
		<td>등록자1</th>
		<td>등록일시1</th>
	</tr>
	<tr>
		<td>2</th>
		<td>제목2</th>
		<td>내용2</th>
		<td>등록자2</th>
		<td>등록일시2</th>
	</tr>
</table>
</body>
</html>