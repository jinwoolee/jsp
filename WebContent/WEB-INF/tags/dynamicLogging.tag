<%@ tag language="java" pageEncoding="UTF-8"%>
<%--동적 속성 선언 --%>
<%@ tag dynamic-attributes="map"%>
<%--정적 속성 선언 
<%@ attribute name= "from"%>
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

\${map.size} : ${map.size} <br/>    
\${map.color} : ${map.color} <br/>
\${map.font} : ${map.font} <br/>

<font size="${map.font}" color="${map.color}">
<c:forEach begin="1" end="${map.size}"> <% out.print("="); %></c:forEach><br/>
</font>