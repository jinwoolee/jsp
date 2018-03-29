<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	final	String	driver		=	"oracle.jdbc.driver.OracleDriver";
	final	String	url			=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	final	String	user		=	"pc01";
	final	String	pass		=	"java";
	final	int		LOOP_COUNT	=	10;
	
	long start = System.currentTimeMillis();
	long end = 0L;
	
	try{
		Class.forName(driver);
		
		for(int i = 0; i < LOOP_COUNT; i++){
			System.out.println(i);
			Connection conn = DriverManager.getConnection(url, user, pass);
			conn.close();
		}
		
	}catch(Exception e){
		e.printStackTrace();
	}
	
	end = System.currentTimeMillis();
	out.println("duration : " + (end-start) + "ms" + "<br/>");
	out.println("duration : " + (end-start)/1000 + "s" + "<br/>");
%>