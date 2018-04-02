<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	pageContext --> request --> session --> application
 --%>
 
elScope : ${elScope} <br/>

<%-- 영역을 제한하여 속성값을 받아오기 --%>
pageScope.elScope : ${pageScope.elScope} <br/>
requestScope.elScope : ${requestScope.elScope} <br/>
sessionScope.elScope : ${sessionScope.elScope} <br/>
applicationScope.elScope : ${applicationScope.elScope} <br/>
