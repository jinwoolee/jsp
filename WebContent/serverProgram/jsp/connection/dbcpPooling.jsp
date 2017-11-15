<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="org.apache.commons.dbcp.DriverManagerConnectionFactory" %>
<%@ page import="org.apache.commons.dbcp.ConnectionFactory" %>
<%@ page import="org.apache.commons.dbcp.PoolableConnectionFactory" %>

<%@ page import="org.apache.commons.dbcp.BasicDataSource" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%
	final	String	driver		=	"oracle.jdbc.driver.OracleDriver";
	final	String	url			=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	final	String	user		=	"pc01";
	final	String	pass		=	"java";
	final	int		LOOP_COUNT	=	10;
	final	int		POOL_SIZE	=	5;


	long start = 0L;
	long end = 0L;
	
	BasicDataSource bds = new BasicDataSource();
	bds.setDriverClassName(driver);
	bds.setUrl(url);
	bds.setUsername(user);
	bds.setPassword(pass);
	bds.setInitialSize(POOL_SIZE);
	
	start	=	System.currentTimeMillis();
	try{
		for(int i = 0; i < LOOP_COUNT; i++){
			System.out.println(i);
			Connection conn = bds.getConnection();
			conn.close();
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	end = System.currentTimeMillis();
	out.println("duration : " + (end-start) + "ms" + "<br/>");
	out.println("duration : " + (end-start)/1000 + "s" + "<br/>");
	
	
	start = System.currentTimeMillis();
	bds.close();
	
	end = System.currentTimeMillis();
	out.println("basic datasource close duration : " + (end-start) + "ms" + "<br/>");
	out.println("basic datasource close duration : " + (end-start)/1000 + "s" + "<br/>");
%>