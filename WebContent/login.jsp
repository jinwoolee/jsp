<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    

    <title>Signin Template for Bootstrap</title>

    <!-- Bootstrap core CSS -->
    <link href="/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="/css/signin.css" rel="stylesheet">
    
    <%@ include file="/jqueryInclude.jsp" %>
    <script src="/js/cookiePlugin/jquery.cookie.js"></script>
    <script src="/js/cookiePlugin/js.cookie.js"></script>
<script>
$(document).ready(function(){
	
	//rememberMe 체크 여부를 쿠키를 통해 확인
	if(document.cookie.indexOf("rememberMe") >= 0){
		jQuery("input[name=rememberMe]").prop("checked", true)
		
		//쿠키에 저장된 userId값을 가져온다.
		var	userId		=	getCookieValue("userId");	
		jQuery("#userId").val(userId);
	}
});

//**getCookieValue
//param : key 찾고자 하는 cookie의 이름/키
//return : cookie의 값 
function getCookieValue(key){
	var startIndex	=	document.cookie.indexOf(key) + key.length +1; 
	var endIndex	=	document.cookie.indexOf(";", startIndex);
	endIndex		=	endIndex == -1 ? document.cookie.length : endIndex;
	var cookieValue	=	document.cookie.substring(startIndex, endIndex);
	return cookieValue;
}

// 쿠키 생성
function setCookie(cName, cValue, cDay){
     var expire = new Date();
     expire.setDate(expire.getDate() + cDay);
     cookies = cName + '=' + escape(cValue) + '; path=/ '; 
     if(typeof cDay != 'undefined') cookies += ';expires=' + expire.toGMTString() + ';';
     document.cookie = cookies;
}

//쿠키값 지우기
function deleteCookie( name, domain ){
	var todayDate = new Date();
	todayDate.setDate( todayDate.getDate() - 1 );
	document.cookie = name + "=; domain=" + domain + "; path=/; expires=" + todayDate.toGMTString() + ";";
}


</script>    
    
<%
	out.append("");
    request.getParameter("userId");
    request.setAttribute("userNm", "brown");
    request.getAttribute("userNm");
    
    response.getWriter();
    
    /*request.setAttribute("userNm", "brown");
    request.getAttribute("userNm");
    session.getAttribute();
    session.setAttribute(arg0, arg1)*/
    
%>


  </head>
  <body>
    <div class="container">
      <form method="post" class="form-signin" action="<%=request.getContextPath() %>/Day7LoginProcessServlet">
        <h2 class="form-signin-heading">Please sign in</h2>
        <label for="userId" class="sr-only">userId</label>
        <input type="text" id="userId" name="userId" class="form-control" placeholder="사용자 아이디">
        <label for="pass" class="sr-only">Password</label>
        <input type="password" id="pass" name="pass" class="form-control" placeholder="비밀번호">
        <div class="checkbox">
          <label>
            <input type="checkbox" name="rememberMe" value="rememberMe"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form>

    </div> <!-- /container -->
  </body>
</html>


<!-- 
로그인 화면 : login.jsp
안만든 것 : login을 처리하는 서블릿
과제 설명 :
login.jsp form전송을 Day7LoginProcessServlet에 요청
Day7LoginProcessServlet에서는

요청된 파라미터(userId, pass)를 받아서
유저 테이블(t_user)에 userId가 같은 사용자가 있는지 확인하여(query, ibatis사용)
존재할경우 pass가 동일하게 입력되었는지 체크
		동일할경우 ==> main.jsp(텍스트로 main.jsp)
비밀번호가 틀리거나, 존재하지 않는 사용자 이면 login.jsp로 이동		

-->