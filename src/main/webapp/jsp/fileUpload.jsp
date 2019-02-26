<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="${cp }/fileUpload" 
	  method="post" enctype="multipart/form-data">
	  
	<input type="text" name="userId" value="${user.userId }"/> <br>
	<input type="file" name="uploadFile" value="${user.filename }" /> <br>
	<input type="submit" value="전송"/>
</form>	
</body>
</html>













