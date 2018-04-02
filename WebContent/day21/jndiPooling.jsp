<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.Connection"%>
<%@page import="util.Const" %>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String DATASOURCE_CONTEXT = "java:comp/env/jdbc/oracleDB";
											 //jdbc/oracleDB		
		Connection conn = null;
		try{
			Class.forName(Const.driver);
			
			Context initialContext = new InitialContext();
			DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
			
			
			//총 8회 컨넥션을 얻고 종료(close)하는데 걸리는 시간 측정
			long start = System.currentTimeMillis();
			for(int i = 0; i < Const.loop_count; i++){
				conn = datasource.getConnection();
				out.println(conn.getSchema() +"<br/>");
				conn.close();
			}
			long end = System.currentTimeMillis();
			out.println("end-start : " + (end-start));
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			try { if(conn != null){ conn.close();} }catch(SQLException e){e.printStackTrace();}
		}
%>