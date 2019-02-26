<%@ page language="java" contentType="application/vnd.ms-excel; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%	//jsp 기본 객체 : request, response
	response.setHeader("Content-Disposition", 
					   "attachment; filename=excel.xls"); %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table>
	<tr>
		<td>사용자이름</td>
		<td>사용자아이디</td>
	</tr>
	<tr>
		<td>브라운</td>
		<td>brown</td>
	</tr>
	<tr>
		<td>코니</td>
		<td>cony</td>
	</tr>
</table>

</body>
</html>