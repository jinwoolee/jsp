<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tf" tagdir="/WEB-INF/tags" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<tf:header title="텍스트 제목" level="2" />

<tf:header title="${'EL변수 제목'}" level="3" />

<tf:header title="<%="표현식 제목"%>" level="3" />

</body>
</html>