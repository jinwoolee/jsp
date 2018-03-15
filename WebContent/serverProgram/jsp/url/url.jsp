<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="<%=request.getContextPath()%>/serverProgram/jsp/url/sameContext.jsp">동일 컨텍스트</a> <br/>
<a href="relativePath.jsp">상대경로로 이동</a> <br/>
<a href="relative/relativePath.jsp">상대경로로 이동2</a> <br/>
<a href="http://localhost:8080/serverProgram/jsp/url/absolute/absolutePath.jsp">절대경로 이동</a> <br/>
<a href="http://localhost:8080/jsp2/jsp2Index.jsp">다른 컨텍스 절대경로</a> <br/>
<a href="/jsp2/jsp2Index.jsp">다른 컨텍스</a> <br/>
</body>
</html>