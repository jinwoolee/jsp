<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>fileUpload</title>
</head>
<body>
<!-- type
		[1] : text, password, email, hidden
		[2] : file
		[3] : submit (전송)
-->
	 
<form method="post" action="/fileUploadServlet">
	<input type="text" name="testParam" value="testParamValue"/> <br/>
	<input type="file" name="testFileParam" /> <br/>
	<input type="submit" value="전송" /> <br/>	
</form>

<br/><br/>

<form method="post" action="/fileUploadServlet" enctype="multipart/form-data">
	<input type="text" name="testParam" value="testParamValue"/> <br/>
	<input type="file" name="testFileParam" /> <br/>
	<input type="submit" value="전송" /> <br/>
</form>	
</body>
</html>




