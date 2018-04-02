<%@page import="java.sql.SQLException"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="java.sql.DriverManager"%>
<%@ page
	import="java.sql.Connection, java.sql.PreparedStatement, java.sql.ResultSet"%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
jdbcUsrList.jsp : jdbc를 통해 t_user 테이블을 조회, 조회된 결과를 화면에 출력
1. 드라이버 로드를 통한 jdbc 준비
2. 쿼리 실행 
3. resultSet에서 데이터 조회
4. jsp out객체를 통해 화면 출력
 
 --%>
	<%
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "sem";
		String pass = "java";

		Connection conn = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pass);
			pstm = conn.prepareStatement(" select * from t_user ");
			rs = pstm.executeQuery();
	
			while (rs.next()) {
				//3. resultSet에서 데이터 조회
				//4. jsp out 내장객체를 통해 화면 출력
				//userId, userNm, userAlias
				//컬럼 + " / " + 컬럼 + " / " + 컬럼
				
				out.println( rs.getString("USERID") + " / " + rs.getString("USERNM") + " / " + rs.getString("USERALIAS") +"<br/>"); 
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			try { if(rs != null){ rs.close();} }catch(SQLException e){e.printStackTrace();}
			try { if(pstm != null){ pstm.close();} }catch(SQLException e){e.printStackTrace();}
			try { if(conn != null){ conn.close();} }catch(SQLException e){e.printStackTrace();}
		}		
	%>
</body>
</html>