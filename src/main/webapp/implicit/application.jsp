<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%	//application.setAttribute(name, object);
		//application.getAttribute(name);
	
		application.getServerInfo();
		application.getServletContextName();
		application.getContextPath();
		application.getMajorVersion();
		application.getMinorVersion();
		application.getInitParameter("ADMIN");
	%>
	application.getServerInfo():                 <%=application.getServerInfo()%>
	application.getServletContextName():         <%=application.getServletContextName()%>
	application.getContextPath():                <%=application.getContextPath()%>
	application.getMajorVersion():               <%=application.getMajorVersion()%>
	application.getMinorVersion():               <%=application.getMinorVersion()%>
	application.getInitParameter("ADMIN"):       <%=application.getInitParameter("ADMIN")%>
	
</body>
</html>







