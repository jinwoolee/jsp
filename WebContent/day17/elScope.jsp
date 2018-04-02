<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 속성을 저장할수 있는 4개의 영역에 동일한 키, 다른 값으로 속성을 저장
	// day17/elScopeResult.jsp 에서는 해당키 값으로 el 변수 속성을 출력
	
	//test 방법
	// http://localhost:8090/day17/elScope.jsp 접속
	// http://localhost:8090/day17/elScopeResult.jsp 접속하여 결과 확인
	pageContext.setAttribute("elScope", "page el scope");
	request.setAttribute("elScope", "request el scope");
	session.setAttribute("elScope", "session el scope");
	application.setAttribute("elScope", "application el scope");
	
	RequestDispatcher rd = request.getRequestDispatcher("elScopeResult.jsp");
	rd.forward(request, response);
%>