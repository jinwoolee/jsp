<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="javax.servlet.http.*" %> 

<%
	//request 객체
	out.println("=====request======<br/>");
	out.println("request.getParameter(\"userId\") : " + request.getParameter("userId") +"<br/>");
	out.println("reuqesAttribute_userId : " + request.getAttribute("reuqesAttribute_userId")+"<br/>");
	request.setAttribute("reuqesAttribute_userId", request.getParameter("userId")+"<br/>");
	out.println("<br/>");
	
	//response 객체
	out.println("=====response======+<br/>");
	response.setHeader("content-Type", "text/html; charset=UTF-8");		//page directive 주석처리후 비교
	out.println("<br/>");
	
	//session 객체
	out.println("=====session======<br/>");
	//HttpSession session = request.getSession();		//session 변수 중복 선언으로 문제가 된다.
	//session 기본객체(내장객체)가 reqeust를 통해 얻은 session 객체와 동일한지 체크
	out.println("session.equals(request.getSession()) : " + session.equals(request.getSession()) + "<br/>");
	out.println("sessionAttribute_userId : " + session.getAttribute("sessionAttribute_userId") +"<br/>");
	session.setAttribute("sessionAttribute_userId", request.getParameter("userId") +"<br/>");
	out.println("<br/>");
	
	//out객체
	out.println("=====out======<br/>");
	//jsp implicit 객체는 response.getWriter()롤 통해 얻어지는 printWriter의 buffer기능 지원 버전
	out.println("out.equals(response.getWriter()) : " + out.equals(response.getWriter()) + "<br/>");
	out.println("<br/>");
	
	//application
	out.println("=====application======<br/>");
	out.println("application.getContextPath() : " + application.getContextPath() + "<br/");
	
	//config
	out.println("=====config======<br/>");
	out.println("config.getInitParameter(\"adminUser\") : " + config.getInitParameter("adminUser") + "<br/");
	
	
	//application 속성 설정후 implicitApplication.jsp페이지를 통해 속성값을 조회할수 있는지 확인하자
	application.setAttribute("applicationAttribute_userId", request.getParameter("userId") +"<br/>");
	out.println("<br/>");
	
	//pageContext
	//종합정보
	out.println("=====pageContext=====<br/>");
	out.println("application.equals(pageContext.getServletContext()) : " + application.equals(pageContext.getServletContext()) +"<br/>");
	out.println("request.equals(pageContext.getRequest()) : " + request.equals(pageContext.getRequest()) +"<br/>");
	out.println("response.equals(pageContext.getResponse()) : " + response.equals(pageContext.getResponse()) +"<br/>");
	out.println("session.equals(pageContext.getSession()) : " + session.equals(pageContext.getSession()) +"<br/>");
	out.println("request.getSession().equals(pageContext.getSession()) : " + request.getSession().equals(pageContext.getSession()) +"<br/>");
	out.println("out.equals(pageContext.getOut()) : " + out.equals(pageContext.getOut()) +"<br/>");
	
	
	/*pageContext.getServletContext();		//application
	pageContext.getServletConfig();			//config
	pageContext.getException();				//exception
	pageContext.getPage();					//page
	pageContext.getOut();					//out
	pageContext.getRequest();				//request
	pageContext.getResponse();				//response
	pageContext.getSession();				//session*/
	out.println("<br/>");
	
	//page
	out.println("=====page=====<br/>");
	//jsp 객체 자신을 나타내는 this
	
	//exception
	out.println("=====exception=====<br/>");
	//에러 페이지에서만 사용가능
%>