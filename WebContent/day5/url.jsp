<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="./list.jsp">./list.jsp</a> <br/>
<a href="list.jsp">list.jsp</a> <br/>
<a href="sub/sub.jsp">sub/sub.jsp</a> <br/>
<a href="/sub/sub.jsp">/sub/sub.jsp : 최상를 지칭 X</a> <br/>
<a href="<%=request.getContextPath()%>/day5/sub/sub.jsp">/day5/sub/sub.jsp </a> <br/>

<a href="http://localhost:8090/jsp2/jsp2Index.jsp">localhost:8090/jsp2/jsp2Index.jsp</a> <br/>
<a href="/jsp2/jsp2Index.jsp">/jsp2/jsp2Index.jsp</a> <br/>



</body>
</html>