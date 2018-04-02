<%@page import="user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- <c:catch> : java의 try catch의 간략 버전 
      : 예외처리 --%>

\${3*5} : ${3*5} <br/>

<c:catch var="exception"> 
<%
	UserVo userVo = (UserVo)request.getAttribute("userVo");
	userVo.getUserNm();
%>
</c:catch>

\${exception} : ${exception}<br/>