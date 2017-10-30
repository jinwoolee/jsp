<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>
<%--속성추가 예시 --%>
<%@ attribute name="color" type="java.lang.String" required="true"%>
<%@ attribute name="lineSize" type="java.lang.Integer" required="false"%>

<font color="${color}">
<%
	lineSize = lineSize == null ? 10 : lineSize;
for(int i=0; i < lineSize; i++)
	out.print("=");
%>
logging
<%
for(int i=0; i < lineSize; i++)
	out.print("=");
%>
</font>
<br/>