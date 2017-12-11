<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map.Entry"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.dao.*"%>
<%@ page import="user.model.UserVo" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="logging"  tagdir="/WEB-INF/tags" %>
<%@ include file="/commonJsp/jquery.jsp" %>

loggin2.tag test <br/>
<logging:logging2 color="red" size="20" />
<logging:logging2 color="green" size="100" />
<logging:logging2 color="blue" />

<%
	session.invalidate();
%>