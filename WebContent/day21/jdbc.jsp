<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.Const"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
		Connection conn = null;
		try{
			Class.forName(Const.driver);
			
			//총 8회 컨넥션을 얻고 종료(close)하는데 걸리는 시간 측정
			long start = System.currentTimeMillis();
			for(int i = 0; i < Const.loop_count; i++){
				conn = DriverManager.getConnection(Const.url, Const.user, Const.pass);
				conn.close();
			}
			long end = System.currentTimeMillis();
			out.println("end-start : " + (end-start));
		}catch(SQLException e){
			
			
		}finally{
			try { if(conn != null){ conn.close();} }catch(SQLException e){e.printStackTrace();}
		}
%>

