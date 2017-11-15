<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Enumeration" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	out.println("application.getServerInfo() : " + application.getServerInfo() + "<br/>");
	out.println("application.getServletContextName() : " + application.getServletContextName() + "<br/>");
	out.println("application.getContextPath() :" + application.getContextPath() + "<br/>");
	out.println("application.getMajorVersion() :" + application.getMajorVersion() + "<br/>");
	out.println("application.getMinorVersion() :" + application.getMinorVersion() + "<br/>");
	
	out.println("application.getMinorVersion() : <br/>");
    Enumeration enumeration =   application.getInitParameterNames();
    while(enumeration.hasMoreElements()){
    		String initParamName = (String)enumeration.nextElement();
    		out.println(initParamName + " : " +  application.getInitParameter(initParamName) + "<br/>");
    }  
%>
</body>
</html>