<%@page import="user.model.UserVo"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Calendar cal = Calendar.getInstance();
	
	
	pageContext.setAttribute("cal", cal);
	String str = "new string";
	pageContext.setAttribute("str", str);
	
	UserVo userVo = new UserVo();
	userVo.setUserNm("usrNm");
	request.setAttribute("userVo", userVo);
%>

<c:set var="str1" value="${str}"/>
<c:set var="str2" value="#{str}"/>

<% 
	str = "modified string";
	pageContext.setAttribute("str", str);
	
%>

str1 : ${str1} <br/>
str2 : ${str2} <br/>

userVo : ${userVo} <br/>
userVo.userNm : ${userVo.userNm} <br/>
userVo.getUserNm() : ${userVo.getUserNm()} <br/>
userVo.getUserNm_fm() : ${userVo.getUserNm_fm()}<br/>
userVo.userNm_fm : ${userVo.userNm_fm}<br/>

<br/>
${userVo.setUserNm("====")}
userVo.userNm : ${userVo.userNm} <br/>


cookie.JESEEIONID : ${cookie.JSESSIONID.value}<br/>
cookie.rememberme : ${cookie.rememberme.value}<br/>
cookie.cookie: ${cookie.cookie.value}<br/>

<br/>
initParam.adminUser : ${initParam.adminUser} <br/>

<c:set var="testStrSession" value="sessionString" scope="session"/>
<c:set var="testStr" value="string" scope="request"/>

str : ${testStr} <br/>

pageContext.getAttribute("testStr") : <%= pageContext.getAttribute("testStr") %> <br/>

<%--값의 적용 시점 테스트 --%>


${cSetDate} <br/>

=============================================== <br/>
<c:set var="cSetDate" value="${cal.time}"/>
<c:set var="cSetDate2" value="#{cal.time}"/>


<%
	cal.set(2017, 5, 11);
%>

${cSetDate} <br/>
${cSetDate2} <br/>

<br/>
1 ==2 ${1 ==2 } <br/>
"string" == "string2" ${"string" == "string2" } <br/>
"string" == "string" ${"string" == "string" } <br/>

"string" == "string" ? "t" : "f" ${"string" == "string" ? "t" : "f"} <br/>

<c:set var="newString" value="${cSetDate}${testStr}"/>
${newString} </br>


<c:set target="${userVo}" property="userNm" value="csetUsernm"/>
<br/> usrVo.userNm : ${userVo.userNm} <br/>

<%--
<c:set var="elDate" value="${date}" />
<c:set var="defferedEldate" value="#{date}" />

<%
	//date.setTime(System.currentTimeMillis() -500000000);
%>
스크립틀릿 : <%= date %> <br/>
EL : ${elDate} <br/>
deffered EL ${defferedEldate} <br/>
 --%>
</body>
</html>