<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
to2 jsp <br/>

request.getParameter("fromParameterValue") : <%= request.getParameter("fromParameterValue") %> <br/>
request.getAttribute("fromParameterValue") : <%= request.getAttribute("fromParameterValue") %> <br/>
</body>
</html>