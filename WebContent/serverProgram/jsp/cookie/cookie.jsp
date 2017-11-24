<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%
	//cookie 조회
	out.println("cookie 조회 <br/>");
	Cookie[] cookies = request.getCookies();
	for(Cookie cookie : cookies)
		out.println(cookie.getName() + " : " + cookie.getValue() + "<br/>");
%>

<br/><br/><br/>

<%
	//cookie 설정
	out.println("cookie 설정 <br/>");
	Cookie newCookie = new Cookie("jspMakeCookie", "jspMakeCookieValue");
	newCookie.setMaxAge(60);
	
	//클라이언트에게 전달되어야 cookie가 전달 되므로 jspMakeCookie 값은 조회되지 않는다.
	//페이지 새로고침을 해야 조회가 된다. (웹브라우저에서 신규 입력한 쿠키를 전송하게 되므로) 
	response.addCookie(newCookie);
	for(Cookie cookie : cookies)
		out.println(cookie.getName() + " : " + cookie.getValue() + "<br/>");
	
%>

<br/><br/><br/>

<%
	//cookie 삭제
	/*out.println("cookie 삭제 <br/>");
	newCookie.setMaxAge(30);
	for(Cookie cookie : cookies){
		if(cookie.getName().equals("jspMakeCookie")){
			cookie.setMaxAge(-1);
			break;
		}
		else
			continue;
	}
	
	for(Cookie cookie : cookies)
		out.println(cookie.getName() + " : " + cookie.getValue() + "<br/>");*/
		
%>