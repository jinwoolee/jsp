<%@page import="org.apache.ibatis.datasource.DataSourceException"%>
<%@page import="org.apache.commons.dbcp2.BasicDataSource"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" trimDirectiveWhitespaces="true"%>
<%@ page import="org.apache.commons.dbcp2.DriverManagerConnectionFactory" %>
<%@ page import="org.apache.commons.dbcp2.ConnectionFactory" %>
<%@ page import="org.apache.commons.dbcp2.PoolableConnectionFactory" %>
<%@ page import="org.apache.commons.dbcp2.PoolableConnection" %>
<%@ page import="org.apache.commons.dbcp2.PoolingDataSource" %>
<%@ page import="org.apache.commons.pool2.impl.GenericObjectPool" %>
<%@ page import="java.sql.Connection" %>
<%@ page import="java.sql.SQLException" %>
<%
	final	String	driver		=	"oracle.jdbc.driver.OracleDriver";
	final	String	url			=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
	final	String	user		=	"pc01";
	final	String	pass		=	"java";
	final	int		LOOP_COUNT	=	10;
	final	int		POOL_SIZE	=	5;

	PoolingDataSource<PoolableConnection> dataSource = null;
	BasicDataSource bds = null;
	
	long start = 0L;
	long end = 0L;
	
	try{
		
		Class.forName(driver);
		
		//신규 conn
		ConnectionFactory connectionFactory = new DriverManagerConnectionFactory(url, user, pass);
		PoolableConnectionFactory poolableConnectionFactory = new PoolableConnectionFactory(connectionFactory, null);
		GenericObjectPool<PoolableConnection> connectionPool =  new GenericObjectPool<PoolableConnection>(poolableConnectionFactory);
		dataSource  =  new PoolingDataSource<PoolableConnection>(connectionPool);
		poolableConnectionFactory.setPool(connectionPool);
		
		
	}
	catch(ClassNotFoundException e){
		throw new RuntimeException("fail jdbc driver load", e);
	}
	
	start	=	System.currentTimeMillis();
	try{
		for(int i = 0; i < LOOP_COUNT; i++){
			System.out.println(i);
			Connection conn = dataSource.getConnection();
			conn.close();
			//Connection conn = bds.getConnection();
			
		}
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	end = System.currentTimeMillis();
	out.println("duration : " + (end-start) + "ms" + "<br/>");
	out.println("duration : " + (end-start)/1000 + "s" + "<br/>");
	
	
	start = System.currentTimeMillis();
	
	end = System.currentTimeMillis();
	out.println("basic datasource close duration : " + (end-start) + "ms" + "<br/>");
	out.println("basic datasource close duration : " + (end-start)/1000 + "s" + "<br/>");
	
	dataSource.close();
	//bds.close();
%>