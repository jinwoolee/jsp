<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/fileUploadParts" method="post" enctype="multipart/form-data">
    <input type="text" id="userId" name="userId"  value="브라운"><br>
    <input type="file" id="file" name="file"><br>
    <input type="submit" value="전송">
</form>
</body>
</html>