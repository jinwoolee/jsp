<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" 
	errorPage="/day10/error.jsp"%>

<%
	/*
	error 발생시, 에러를 처리하는 방법에 대해서 학습
	error 페이지를 설정하는 방법 3가지
	
	1. jsp 페이지에 등록(설정)
	2. web.xml 예외 타입(ex : ArithmeticException, NullPointerException ...)
	3. web.xml 응답 코드(ex : 500-server internal error, 404-not found error)
	
	해당 페이지에서는 1번 방법 학습
	
	테스트 방법
	http://localhost:8090/day10/throwException.jsp에 접속을 하면
	페이지 설정대로 예외를 강제로 발생  
	
	 jsp page 지시자에 설정한 error 처리 페이지로 이동되는지 확인*/
throw new Exception("강제 에러 발생"); %>