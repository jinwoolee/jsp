<%-- body-content
scriptless : EL, 텍스트 사용가능 (스크립틀릿, 표현식 사용 불가) :
tagdependent : body-content 를 텍스트로 처리
empty : body-content 없음. 있을경우 에러
 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--<%@ tag language="java" pageEncoding="UTF-8" body-content="tagdependent"%>-->
<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>


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
</font><br>

<%-- tagedependent 
<jsp:doBody var="bodyText"/>
bodyText : <c:out value="${bodyText }" escapeXml="true"/>
--%>

<!-- scriptless -->
<jsp:doBody />

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
</font><br>