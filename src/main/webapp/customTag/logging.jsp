<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>    
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%-- localhost/customTag/logging.jsp --%>
<h2>loggings.tag</h2>
logging.jsp 출력<br>
<tags:loggings></tags:loggings>
logging.jsp 출력<br>
<tags:loggings></tags:loggings>

<h2>colorLogging.tag</h2>
<tags:cologLogging color="blue" size="20"/>
<tags:cologLogging color="yellow" size="50"/>

</body>
</html>









