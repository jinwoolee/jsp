<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- custom tag도 등록 필요 --%>
<%@ taglib prefix="log" tagdir="/WEB-INF/tags"%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 1. <log:logging> 
================================

1. <log:logging size="5">
size를 통해 출력되는 갯수를 제어

2. <log:logging size="5" color="red">
font 태그를 이용한 color 적용  

custom tag
<%@ attribute name="color" />
<%@ attribute name="size" />
--%>




<%-- <log:logging/> --%>
<log:logging size="5" color="red"/>
<log:logging size="10" color="blue"/>
<br/><hr>

<%--동적 속성 예제 --%>
<log:dynamicLogging size="5" color="red" font="15"/>

<%-- sum --%>

<%--tag 파일에서 변수 넘기기
tag를 사용하면서 속성값을 전달 (jsp --> tag)
전달된 속성값을 이용해서 연산, 화면출력 시행

tag파일에서 연산된 결과를 -> 호출한 jsp tag 부분에 리턴 
 --%>

sum :
<log:sum from="1" to="100" >		<%--open tag --%>
${result}
<%-- nested --%>
</log:sum>							<%--end tag --%>

 <br/> 
</body>
</html>












