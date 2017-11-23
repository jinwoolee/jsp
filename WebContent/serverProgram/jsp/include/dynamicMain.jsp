<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@page import="java.net.URLEncoder"%>

<%--
<jsp:include page="header.jsp">
	<jsp:param value="fromDmValue" name="fromDmValue"/>
</jsp:include>
 --%>
 
<br/>
test

<br/><br/><br/>
url encoded
<%

	
	//String encodeUrl = URLEncoder.encode("?fromDmValue=fromDmValue");
	//RequestDispatcher rd = request.getRequestDispatcher("header.jsp" + encodeUrl);
	
	out.flush();
	RequestDispatcher rd = request.getRequestDispatcher("header.jsp?fromDmValue=fromDmValue");
	rd.include(request, response);
%>

<br/><br/>
dynamicMain.jsp request.getParameter("fromDmValue") : <%= request.getParameter("fromDmValue")%> <br/>


main 영역입니다.