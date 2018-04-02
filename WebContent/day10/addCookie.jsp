<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import=" javax.servlet.http.Cookie" %>

<%
	//1.jsp 페이지 cookie 생성
	//2.jsp 페이지의 응답결과를 전송 할때 새로 생성한 cookie를 같이 전송
	//3.웹브라우저(클라이언트)가 응답결과를 받으면 cookie 정보를 웹브라우저에 저장
	//4.추후에 같은 도메인으로 요청을 보낼시에는 설정된 모든 쿠키정보를 서버로 전송 (기간이 만료가 안된 쿠키)

	//http://localhost:8090/day10/addCookie.jsp 접속시
	// 아래의 쿠키 정보를 생성후 클라이언트로 전송
	
	Cookie cookie = new Cookie("rememberMe", "rememberMe");
	
	//setMaxAge : 초단위 60*60*24 = 24시간, GMT기준, 대한민국은 GMT+9
	cookie.setMaxAge(60*60*33);		//24 + 9 		
	cookie.setPath("/");
	response.addCookie(cookie);
	
	
	Cookie[] cookies = request.getCookies();
	for(Cookie c : cookies){
		out.println(c.getName() + " / " +
					c.getValue() + " / " +  "<br/>");
	}
%>