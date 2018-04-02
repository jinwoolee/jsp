<%@page import="user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	UserVo userVo = new UserVo();
	userVo.setUserNm("brown");
	
	//page영역에 속성으로 설정
	pageContext.setAttribute("userVo", userVo);
%>

<%--EL에서는 속성명만 적어준다. --%>
<%--EL은 page, reuqest, session, application의 속성값을 가져온다 --%>
userVo.userNm : ${userVo.userNm}<br/>
userVo.getUserNm() : ${userVo.getUserNm()}<br/>
userVo.getUserNmDeco() : ${userVo.getUserNmDeco()}<br/>
userVo.userNmDeco : ${userVo.userNmDeco}<br/>

<%--수치연산 --%>
2+3 : ${ 2+3}