<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- day17/elImplictObject.jsp --%>

<%--
	jsp 내장객체
	
	out
	pageContext (page영역)
	request
	session
	application
	response
	config
	page
	excpetion
	
	
	el 내장객체 
--%>

<%--
	//테스트 방법
	//http://localhost:8090/day17/elImplictObject.jsp?page=10
	request.getParameter("page");
	${param.page}
	
	//http://localhost:8090/day17/elImplictObject.jsp?page=10userId=brown&userIdn=cony
	request.getParameterValues("userId");
	${paramValues.userId}
	
	/*request.getHeader("headerName")
	${header.headerName}
	
	request.getHeaders("headerName");
	${headerValues.headerName}*/
	
	request.getCookies()
	${cookie}
	
	
	application.getInitParameter("adminUser")
	${initParam.adminUser}
--%>

<%--http://localhost:8090/day17/elImplictObject.jsp?page=10 --%>
param.page : ${param.page} <br/><br/>

<%--http://localhost:8090/day17/elImplictObject.jsp?page=10&userId=brown&userId=cony --%>
paramValues.userId : ${paramValues.userId}<br/>  <%-- string 배열 : 객체 주소값 출력 --%>
paramValues.userId : ${paramValues.userId[0]}<br/>
paramValues.userId : ${paramValues.userId[1]}<br/>


cookie.JSESSIONID.getValue() : ${cookie.JSESSIONID.getValue()} <br/>
cookie.JSESSIONID.value : ${cookie.JSESSIONID.value} <br/>

initParam.adminUser : ${initParam.adminUser} <br/>

pageContext.request.contextPath : ${pageContext.request.contextPath}

<%--
	request.getCookies()[0].getName()
--%>

