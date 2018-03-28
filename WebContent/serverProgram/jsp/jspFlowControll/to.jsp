<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
to jsp

request.getParameter("fromParameterValue") : <%= request.getParameter("fromParameterValue") %> <br/>
request.getAttribute("fromParameterValue") : <%= request.getAttribute("fromParameterValue") %> <br/>

<jsp:forward page="to2.jsp"/>
</body>
</html>