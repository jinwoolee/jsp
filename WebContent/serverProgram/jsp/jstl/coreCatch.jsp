<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
catch
<c:catch var="exceptionObj">
    예외 발생 가능 코드
</c:catch>

${exceptionObj}
 --%>

<c:catch var="exception">
<% 
	String userId = request.getParameter("userId");
	boolean userIdChekck = userId.equals("brown");		//parameter를 호출하지 않아 nullpointer예외 발생
%>

</c:catch>
${exception}
</body>
</html>