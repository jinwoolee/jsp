<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/js/jquery-3.2.1.js"></script>
<script>
$(document).ready(function(){
	console.log("test");
	
	$("#addInput").on("click", function(){
		
		//a 태그기준 : a태그 위쪽에 input 추가
		$(this).before("<input type='text' name='number' /> <br/>");
		
		//name이 number인 input 태그중 가장 마지막 태그를 찾는다. : $("input[name=number]").last()
		//찾은 input 태그의 next 태그(br)를 찾는다. $("input[name=number]").last().next()
		//br 태그 다음에 새로인 input 태그를 붙여 넣는다.
		//$("input[name=number]").last().next().after("<input type='text' name='number' /> <br/>");
	});
	
});
</script>
</head>
<body>
<%-- 서버로 파라미터 전송
 *** 같은 이름의 파라미터를 전송하는 예제 ***
1. input (name=arg1, agr2,) 2개를 생성
2. 전송 버튼 왼쪽에 숫자 추가 링크 생성
2. 숫자 추가를 클릭하면 숫자를 입력할수 있는 input 태그를 동적으로 생성
2. form action = Day6DynamicCalculateServlet 
3. Day6DynamicCalculateServlet에서는  jsp에서 전송한 파라미터 복수의 파라미터를 받는다
4. 전송된 파라미터의 모든 값을 더하여 화면에 출력(out 객체 사용)
 --%>

<form method="post" action="/Day6DynamicCalculateServlet">
	<input type="text" name="number" /> <br/>
	<input type="text" name="number" /> <br/>
	<a href="#" id="addInput" />숫자 추가</a> <input type="submit" value="전송"/>
	
	<select id="operator" name ="operator" >
	 	<option value="mulitply"> mulitply </option>
	 	<option value="plus"> plus </option>
	 	<option value="minus"> minus </option>
	</select>
</form>
</body>
</html>