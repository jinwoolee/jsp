<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//DB작업에 필요한 객체변수 선언
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			// 1. 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			// 2. 접속 ==> Connection객체 생성
			long startTime = System.currentTimeMillis();
			for(int i = 0; i < 20; i++){
				conn = DriverManager.getConnection(
							"jdbc:oracle:thin:@localhost:1521:xe", 
							"sem", 
							"java");
				conn.close();
			}
			long endTime = System.currentTimeMillis();
			System.out.println("duration : "  + (endTime-startTime));
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			// 6. 사용했던 자원들을 모두 반납한다.
			if(rs!=null) try{ rs.close(); }catch(SQLException e){}
			if(stmt!=null) try{ stmt.close(); }catch(SQLException e){}
			if(conn!=null) try{ conn.close(); }catch(SQLException e){}
		}
%>