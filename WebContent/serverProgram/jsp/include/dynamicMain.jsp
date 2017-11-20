<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>


<jsp:include page="header.jsp">
	<jsp:param value="fromDmValue" name="fromDmValue"/>
</jsp:include>
<br/><br/>
dynamicMain.jsp request.getParameter("fromDmValue") : <%= request.getParameter("fromDmValue")%> <br/>


main 영역입니다.