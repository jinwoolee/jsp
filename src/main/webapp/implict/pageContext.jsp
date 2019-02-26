<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%	//pageContext : 해당 jsp 페이지의 정보를 담고 있고
	//				다른 기본 객체를 얻어 올 수 있다

%>
pageContext.getOut().equals(out) : <%=pageContext.getOut().equals(out)%> <br>
pageContext.getRequest().equals(request) : <%=pageContext.getRequest().equals(request)%> <br>
pageContext.getResponse().equals(response) : <%=pageContext.getResponse().equals(response)%> <br>
pageContext.getSession().equals(session) : <%=pageContext.getSession().equals(session)%> <br>
pageContext.getServletContext().equals(application) : <%=pageContext.getServletContext().equals(application) %> <br>

</body>
</html>