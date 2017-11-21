<?xml version="1.0" encoding="UTF-8" ?>
<%@page import="java.net.URL"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.IOException"%>
<%@page import="java.io.FileReader"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>04/ application.jsp </title>
</head>
<body>
<!-- web.xml내 <context-param>내 설정 확인 -->
MySqlDriver : <%=application.getInitParameter("MySqlDriver") %> <br />
MySqlURL : <%=application.getInitParameter("MySqlURL") %> <br />
MySqlUSER : <%=application.getInitParameter("MySqlUSER") %> <br />
MySqlPASSWD : <%=application.getInitParameter("MySqlPASSWD") %> <br />
<hr />
SERVER 정보 : <%=application.getServerInfo() %> <br />
서블릿 : <%=application.getMajorVersion() %>.<%=application.getMinorVersion() %> <br />
<hr />

<%
	// 이클립스 콘솔 메세지... 실제 서버 배포시 실서버와 이클립스의 server.xml 내 설정으로 logs 폴더내에 로그파일 출력
	log("아 배고파");
	application.log("화요일...");
	
	// 콘솔 로그 실제 서버 배포시 실서버의 logs의 로그파일로 출력 않됨.
	System.out.println("로그....");
%>

ddit의 웹 경로 : <%=request.getRealPath("/WEB-INF/canNotAccess.jsp") %><br/>
ddit의 실제 물리적인 경로 : <%=request.getRealPath("/WEB-INF/canNotAccess.jsp") %> <br/>
<hr/>        
<%
	String buffer = "";
	
	/*BufferedReader br = new BufferedReader(
			new InputStreamReader(
					new FileInputStream(
							application.getRealPath("/04/readme.txt")),"UTF-8"));
	try{
		PrintWriter pw = response.getWriter();
		while((buffer = br.readLine()) != null){
			pw.println(buffer);
		}
	}catch(IOException e){
		out.print("에러" + e.getMessage());
	}finally{
		br.close();
	}*/

%>
<%
	/*String temp = "";
	URL url = application.getResource("/04/readme.txt");
	
	BufferedReader bufferReader = new BufferedReader(
			new InputStreamReader(url.openStream() ,"UTF-8"));
	try{
		PrintWriter pw = response.getWriter();
		while((temp = bufferReader.readLine()) != null){
			pw.println(temp);
		}
	}catch(IOException e){
		out.print("에러" + e.getMessage());
	}finally{
		br.close();
	}*/

%>
<%
/*	String path = "/04/readme.txt";
	InputStream in = application.getResourceAsStream(path);
	BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
	while(true){
		String str = reader.readLine();
		if(str == null){
			break;
		}
		out.println(str);
	}*/
	
%>
</body>
</html>




