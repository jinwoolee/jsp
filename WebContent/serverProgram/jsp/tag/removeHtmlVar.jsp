<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="tags" %>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:set var="dateEL" value="<%= new Date() %>" />
<tags:removeHtmlVar trim="true" trail="..." var="removed">
  <font size="10"> 현재 <style>시간은</style>은 ${dateEL} 입니다. </font>
</tags:removeHtmlVar>

처리결과: ${removed} <br/>
!! ${result} !!
</body>
</html>