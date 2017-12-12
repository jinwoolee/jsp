<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager, java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet, java.sql.SQLException" %>
<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	final	String	driver		=	"oracle.jdbc.driver.OracleDriver";
	final	String	url			=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	final	String	user		=	"pc01";
	final	String	pass		=	"java";
	
	Connection conn = null;
	PreparedStatement pstm = null;
	ResultSet rs = null;
	
	try{
		//Class.forName(driver);
		conn = DriverManager.getConnection(url, user, pass);
		
		pstm = conn.prepareStatement("select userid, usernm, pass from t_user");
		rs = pstm.executeQuery();
		
		while(rs.next()){
			out.println(rs.getString("USERID") + " / " + rs.getString("USERNM") + " / " + rs.getString("PASS") + "<br/>");
		}
		
		
		
	}catch(Exception e){
		e.printStackTrace();
	}finally {
		try { if(rs != null) rs.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if(pstm != null) pstm.close(); } catch (SQLException e) { e.printStackTrace(); }
		try { if(conn != null) conn.close(); } catch (SQLException e) { e.printStackTrace(); }
	}
%>
</body>
</html>