<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<!-- pageEncoding : jsp 파일 작성에 대한 인코딩 -->
<!-- charset : jsp 파일 출력시의 인코딩 / contentType 헤더 설정값 -->

<!-- html charset 결정순서 
 1. Content-Type 헤더
 2. META http-equiv  Content-Type과 charset 속성
 3. charset 속성
 -->

<!DOCTYPE html>
<html>
<head>
<!--  <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">-->
<meta charset="utf-8"> 
<title>Insert title here</title>
<script>
function getUrl(encode){
	if(encode == true)
		document.location="/servlet/getUrl.jsp?param=" + encodeURIComponent("한글");
	else
		document.location="/servlet/getUrl.jsp?param=" + "한글";
}
</script>
</head>
<body>

<!--
tomcat8 부터는 한글 파라미터를 사용할경우 에러가 발생 -> encode uri 과정을 반드시 거쳐야 한다.
tomcat6의 경우 한글이 깨지지만 에러는 발생하지 않음.

tomcat8의 경우 encodeURIComponent 를 사용하면 별도 설정은 필요 없음
tomcat6의 경우 connector를 통해 URIEncoding="UTF-8" 설정을 해야 한글이 정상적으로 보인다.

https://tomcat.apache.org/tomcat-6.0-doc/config/http.html
https://wiki.apache.org/tomcat/FAQ/CharacterEncoding#Q1

-->

<a href="/servlet/getUrl.jsp?param=한글">getUrl.jsp</a> <br/>
<a href="#" onclick="javascript:getUrl(true);">uriEncodegetUrl.jsp</a> <br/>
<a href="#" onclick="javascript:getUrl(false);">noUriEnocdegetUrl.jsp</a>

</body>
</html>