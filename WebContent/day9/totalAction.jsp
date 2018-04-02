<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<%--
include 지시지를 통한 jsp 모듈화  <%@ include file="path" %>
file 속성에 지정한 파일을 compile시간에 소스를 붙여 넣는 형태
즉 원래 하나의 파일인 것처럼 동작
 --%>
<%@ include file="/jqueryInclude.jsp" %>
 
</head>
<body>
<%--
	각 영역 (헤더, 좌측메뉴....)을 별도의 페이지로 분리하여
	jsp 액션태그로 동적 include
	
	사용예
	접속한 사람마다 보여야 하는 조직도 select box가 다른 경우
	본부장 -> 부 select box / 팀 select box / 팀원 select box
	부장 -> 팀 select box / 팀원 select box
	팀장 -> 팀원 select box
	팀원 -> no select box 
	
 --%>
<!-- <table border="1">
	<tr>
		<th colspan="2">헤더(header)</th>
	</tr>
	<tr>
		<th>좌측 메뉴(left side)</th>
		<th>컨텐츠(contents)</th>
	</tr>
	<tr>
		<th colspan="2">푸터(footer)</th>
	</tr>
</table> -->

<table border="1">
	<tr>
		<th colspan="2">
			<jsp:include page="header.jsp">
				<jsp:param name="headerKey" value="headerValue" />
			</jsp:include>
		</th>
	</tr>
	<tr>
		<th><jsp:include page="leftSide.jsp"/></th>
		<th><jsp:include page="contents.jsp"/></th>
	</tr>
	<tr>
		<th colspan="2"><jsp:include page="footer.jsp"/></th>
	</tr>
</table>

request.getParameter("headerKey") : <%=request.getParameter("headerKey")%>

</body>
</html>

