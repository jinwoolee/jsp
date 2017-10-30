<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:doBody var="content" scope="page" />
<%
String content = (String)jspContext.getAttribute("content");
content = content.replaceAll("<", "&lt;");
content = content.replaceAll(">", "&gt;");
out.println(content);
%>