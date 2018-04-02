<%@page import="user.model.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- jstl 을 사용하기 위해서는 taglib 지시자를 이용한 선언이 필요
	prefix, uri 선언 필요
	prefix : 태그 라이브러리 호출시 사용하는 이름
	uri : 해당 jstl 라이브러리의 uri
	
	core jstl의 경우 prefix를 c로 설정(일반적 설정) 
--%>

<%--
 <c:set> 의 역할 : 1.jstl 변수 생성
 				2.특정 객체의 값을 변경할때 사용
 var : 생성하고자  하는 변수 이름
 value : 변수에 넣고자 하는 값
 scope : jstl 변수의 영역 (page, request, session, application) default : page
 
 target : 변경하고자 하는 대상 객체 (EL, 표현식)
 property : 변경하고자 하는 객체의 속성
--%>

<%-- 영역에 변수를 설정하는 예제 --%>
<%--다음 두 문장은 동일 --%>
<%
	String code = "05";
	pageContext.setAttribute("code", code);
%>

<c:set var="code" value="05" /> 

pageContext.getAttribute("code") : <%= pageContext.getAttribute("code") %> <br/>
EL : ${pageScope.code}<br/>
EL : ${code}<br/>

<br/><br/><br/>


<%--2.특정 객체의 값을 변경할때 사용 (사용빈도 낮음) --%>
<%
	UserVo userVo = new UserVo();
	userVo.setUserNm("brown");
	pageContext.setAttribute("userVo", userVo);
%>


<%-- 하단의 스크립틀릿과  c:set은 동일한 코드 --%>
<%
	userVo = (UserVo)pageContext.getAttribute("userVo");
	userVo.setUserNm("cony");
%>

\${userVo.userNm } : ${userVo.userNm } <br/>
<c:set target="${userVo }" property="userNm" value="cony"/>
\${userVo.userNm } : ${userVo.userNm } <br/>
<br/><br/><br/>

<%--remove
	속성객체(pageContext, request, session, application 에서 속성을 삭제한다.
	
	var : 삭제하고자 하는 속성이 이름
	scope : 삭제하고자 하는 영역 (default : all)
 --%>

<%-- 
<%
	pageContext.removeAttribute("code");
%>  --%>
 
<c:remove var="code" scope="session"/>

jstl \${code} : ${code}
 
 
<br/><br/><br/><br/>
<%--
		 EL : ${} 
deffered EL : #{}   : <c:set >
용도 :  #{}이 읽히는 시점의 값으로 출력
--%>

<%	
	String name = "brown";
	pageContext.setAttribute("name", name);
%> 

<c:set var="orgName" value="${name }" />
<c:set var="defferedName" value="#{name }" />

<%	
	name = (String)pageContext.getAttribute("name");
	name = "cony";
	pageContext.setAttribute("name", name);
%> 
\${orgName } : ${orgName } <br/>
\${defferedName } : ${defferedName } <br/>







 
 
 
 
 
 
 
 



