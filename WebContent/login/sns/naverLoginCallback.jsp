<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	response.setHeader("Pragma", "no-cache"); //http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
	response.setHeader("Cache-Control", "no-cache"); //http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
	response.addHeader("Cache-Control", "no-store"); //파이어 폭스 no-cache bug
	response.setDateHeader("Expires", 1L); //만료일자 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>naverLoginCallback.jsp</title>
<%@include file="/commonJsp/jquery.jsp"%>
<%@include file="/commonJsp/bootstrap.jsp"%>
<script type="text/javascript"
	src="https://static.nid.naver.com/js/naverLogin_implicit-1.0.3.js"
	charset="utf-8"></script>
<%
	//String code = request.getParameter("code");
	//System.out.println("accessToken : " + code);

	String clientId = "gYkqeVAb7MK9Xnd7bgHh";//애플리케이션 클라이언트 아이디값";
	String clientSecret = "2KYz7VBzBq";//애플리케이션 클라이언트 시크릿값";
	
	//callbackurl로 code 파라미터가 존재하면 네아로 성공
	//실패시 state={state값}&error={에러코드값}&error_description={에러메시지}
	String code = request.getParameter("code");
	String state = request.getParameter("state");
	String redirectURI = URLEncoder.encode("http://localhost:8080/login/sns/naverLoginCallback.jsp", "UTF-8");
	String apiURL;
	apiURL = "https://nid.naver.com/oauth2.0/token?grant_type=authorization_code&";
	apiURL += "client_id=" + clientId;
	apiURL += "&client_secret=" + clientSecret;
	apiURL += "&redirect_uri=" + redirectURI;
	apiURL += "&code=" + code;
	apiURL += "&state=" + state;
	String access_token = "";
	String refresh_token = "";
	System.out.println("apiURL=" + apiURL);
	try {

		URL url = new URL(apiURL);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		con.setRequestMethod("GET");
		int responseCode = con.getResponseCode();
		BufferedReader br;
		System.out.print("responseCode=" + responseCode);
		if (responseCode == 200) { // 정상 호출
			br = new BufferedReader(new InputStreamReader(con.getInputStream()));
		} else { // 에러 발생
			br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
		}
		String inputLine;
		StringBuffer res = new StringBuffer();
		while ((inputLine = br.readLine()) != null) {
			res.append(inputLine);
		}
		br.close();
		if (responseCode == 200) {
			out.println(res.toString());
		}
	} catch (Exception e) {
		System.out.println(e);
	}
%>
<script>
$(document).ready(function() {
	var naverClientId = "gYkqeVAb7MK9Xnd7bgHh";
	var naverClientSecret = "2KYz7VBzBq";
	var redirectUri = "http://localhost:8080/login/sns/naverLoginCallback.jsp";

	var naverTokenUrl = "https://nid.naver.com/oauth2.0/token";
	
	var param = "grant_type=authorization_code";
	param += "&client_id=" + naverClientId;
	param += "&client_secret=" + naverClientSecret;
	param += "&code=<%=code%>";

						console.log("param : " + param);

						/*$.ajax({
							dataType: "jsonp",
							async : false, 
						    url: "https://nid.naver.com/oauth2.0/token",
						    data: param,
						    success: function(data){
						        console.log(data);
						    }
						});

						var naverIdLogin = new naver_id_login(naverClientId, redirectUri);

						// 접근 토큰 값 출력
						console.log(naverIdLogin.oauthParams.access_token);

						// 네이버 사용자 프로필 조회
						naverIdLogin.get_naver_userprofile("naverSignInCallback()");

						// 네이버 사용자 프로필 조회 이후 프로필 정보를 처리할 callback function
						function naverSignInCallback() {
							console.log(naverIdLogin.getProfileData('email'));
							console.log(naverIdLogin.getProfileData('nickname'));
							console.log(naverIdLogin.getProfileData('age'));
						}*/
					});
</script>
</head>
<body>naverLoginCallback.jsp
</body>
</html>