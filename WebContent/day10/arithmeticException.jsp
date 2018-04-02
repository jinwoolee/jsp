<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%--
	jsp 예외처리 학습 2
	
	1. jsp 페이지에 등록(설정)
	2. web.xml 예외 타입(ex : ArithmeticException, NullPointerException ...)
	3. web.xml 응답 코드(ex : 500-server internal error, 404-not found error)
	
	산술연산중 나눗셈의 잘못된 연산을 하여 강제로 ArithmeticException을 발생 시키는 예제
	localhost:8090/day10/arithmeticException.jsp 접속시
	0으로 정수를 나누어 예외 발생
	
	예외 타입별 페이지 설정은 web.xml에서 정의
	
	첫번째 방법(예외 페이지를 각 jsp 페이지에 등록)의 경우 다양한 예외 처리가 힘들고
	페이지마다 설정해야하는 불편함이 있음
	
	본 페이지가 호출되면 ArithmeticException이 발생
	ArithmeticException는 RuntimeException을 상속함
	
	web.xml에는 
	ArithmeticException 타입의 예외가 발생할경우 -> /day10/arithMeticError.jsp
	RuntimeException 타입의 예외가 발생할경우 -> /day10/runtimeError.jsp
--%>

<%
	int result = 5/0;
%> 