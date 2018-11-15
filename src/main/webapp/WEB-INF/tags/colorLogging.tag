<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="length" type="Integer" required="false"%>
<%@ attribute name="color" type="String" required="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:set var="length" value="${length == null ? 20 : length }" />

<%-- length 속성이 없을경우 length 기본값 20으로 표현 --%>
<font color="${color}">

<c:forEach begin="1" end="${length }">=</c:forEach>
logging
<c:forEach begin="1" end="${length }">=</c:forEach>

</font>