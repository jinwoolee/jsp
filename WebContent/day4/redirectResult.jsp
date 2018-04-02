<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
GB : <%= request.getParameter("gb") %> <br/>

receivedGb : <%= request.getAttribute("receivedGb")%> <br/>

sessionGb : <%=  request.getSession().getAttribute("sessionGb")%><br/>

sessionGb : <%=  session.getAttribute("sessionGb")%><br/>
</body>
</html>