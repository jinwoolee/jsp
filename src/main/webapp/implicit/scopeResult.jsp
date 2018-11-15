<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

requestScope : <%=request.getAttribute("requestScope") %> <br>
sessionScope : <%=session.getAttribute("sessionScope") %> <br>
applicationScope : <%=application.getAttribute("applicationScope") %> <br> 

</body>
</html>