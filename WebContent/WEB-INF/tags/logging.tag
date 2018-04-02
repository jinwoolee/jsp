<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="size" %>
<%@ attribute name="color" required="true"%>

\${size } : ${size } <br/>

<%--size 속성만큼만 "="을 출력 --%>
<!-- for(int = 0; i < 10; i++) -->

<font color="${color }">
<c:forEach begin="1" end="${size }"><% out.print("="); %></c:forEach>
</font>