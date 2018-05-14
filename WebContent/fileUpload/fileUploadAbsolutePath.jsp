<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<form method="post" action="${pageContext.request.contextPath }/fileUploadAbsolutePathServlet" enctype="multipart/form-data">
	<input type="text" name="paramText" value="test" /> <br/>
	<input type="file" name="paramFile"/><br/>
	<input type="submit" />	
</form>

</body>
</html>