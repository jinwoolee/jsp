<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="/ApplicationServlet">
	<input type="text" name="param" value="test" /> <br/>
	<input type="file" name="paramFile"/><br/>
	<input type="submit" />	
</form>
<br/><br/><br/>

file upload Servlet - commons
<form method="post" action="/FileUploadServlet" enctype="multipart/form-data">
	<input type="text" name="param" value="test" /> <br/>
	<input type="file" name="paramFile"/><br/>
	<input type="submit" />	
</form>
<br/><br/><br/>

jsp/servelt parts --enctype = default : application/x-www-form-urlencoded
<form method="post" action="/FileUploadPartsServlet">
	<input type="text" name="paramText" value="test" /> <br/>
	<input type="file" name="paramFile"/><br/>
	<input type="submit" />	
</form>
<br/><br/><br/>

jsp/servelt parts --enctype = multipart/form-data
<form method="post" action="/FileUploadPartsServlet" enctype="multipart/form-data">
	<input type="text" name="paramText" value="test" /> <br/>
	<input type="file" name="paramFile"/><br/>
	<input type="submit" />	
</form>

commons fileuplaod --enctype = multipart/form-data
<form method="post" action="/FileUploadServlet" enctype="multipart/form-data">
	<input type="text" name="paramText" value="test" /> <br/>
	<input type="file" name="paramFile"/><br/>
	<input type="submit" />	
</form>

</body>
</html>