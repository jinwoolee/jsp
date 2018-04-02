<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//웹브라우저는 해당 도메인으로 보내는 모든 요청에 대해
	// 해당 도메인으로 설정된 모든 cookie를 요청에 같이 전송한다.
	// --> request 내장 객체에서 설정된 cookie 정보들을 조회 할 수 있다
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies){
		out.println(cookie.getName() + " / " +
					cookie.getValue() + " / " +  "<br/>");
	}
%>