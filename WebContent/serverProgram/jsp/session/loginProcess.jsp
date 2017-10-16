<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//login 처리가 정상적으로 이루어짐
	//session에 사용자 아이디를 저장
	//해당 세션이 유지되는 동안에는 session 객체를 통해 해당 사용자의 id를 확인할수 있다.
	
	String userId		=	request.getParameter("useId");
	String password		=	request.getParameter("password");
	
	System.out.println("useId = " + userId);
	System.out.println("password = " + password);
	
	//이부분은 사용자가 입력한 id, pass에 대해 검증하는 로직이 들어와야함.
	//일반적으로는 db에 있는 사용자 테이블을 조회하여 패스워드가 일치하는지 체크
	//여기서는 사용자가 1234라고 입력한 경우 정상적으로 사용자라고 판단한다
	
	//로그인 실패
	if(password == null || !password.equals("1234"))
		response.sendRedirect("login.jsp");
	//로그인 성공
	else if(userId != null && password.equals("1234")){
		session.setAttribute("userId", userId);
		
		//일반적으로 로그인 성공하면 사이트의 메인 화면으로 이동한다.
		//여기서는 세션 값을 확인하기 위한 페이지로 이동한다.
		response.sendRedirect("sessionCheck.jsp");
	}	
%>