<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
	WEB-INF 내부에 있는 jsp로 request.forward 실행 예제
	/WEB-INF/WEB-INF.jsp로 forward 시켜주세요
--%>

<%
//reuqestDispatcher 객체는 request 내장객체의 getRequestDispatcher 메소드를 통해 획득한다.
RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/WEB-INF.jsp");
dis.forward(request, response);
%>