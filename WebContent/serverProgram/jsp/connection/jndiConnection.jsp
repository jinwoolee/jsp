<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.sql.*, javax.sql.*, javax.naming.*"%>

<%
	String DATASOURCE_CONTEXT = "java:comp/env/jdbc/oracleDB";

	
	final	int		LOOP_COUNT	=	10;
	
	long start = System.currentTimeMillis();
	long end = 0L;
	
	try{
		Context initialContext = new InitialContext();
		DataSource datasource = (DataSource)initialContext.lookup(DATASOURCE_CONTEXT);
		
		for(int i = 0; i < LOOP_COUNT; i++){
			System.out.println(i);
			Connection conn = datasource.getConnection();
			
			out.println("conn.getSchema() : " + conn.getSchema() + "<br/>");
			conn.close();
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	end = System.currentTimeMillis();
	out.println("duration : " + (end-start) + "ms" + "<br/>");
	out.println("duration : " + (end-start)/1000 + "s" + "<br/>");
%>