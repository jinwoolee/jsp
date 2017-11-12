<%@ tag language="java" pageEncoding="UTF-8" body-content="empty"%>

<%-- 동적 속성추가 예시 --%>
<%@ tag dynamic-attributes="map"%>


<font color="${map.color}">
<%
	java.util.Map map = (java.util.Map)jspContext.getAttribute("map");
	//int lineSize = Integer.parseInt((String)map.getOrDefault("lineSize", "10"));
	int lineSize = Integer.parseInt((String)map.get("lineSize"));
	
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