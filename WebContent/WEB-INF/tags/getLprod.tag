<%@tag import="prod.vo.ProdVO"%>
<%@tag import="java.util.List"%>
<%@tag import="prod.dao.ProdDaoImpl"%>
<%@tag import="prod.dao.IProdDao"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ attribute name="prod_lgu" %>

\${prod_lgu } : ${prod_lgu } <br/>
<c:set var="prod_lgu" value="${prod_lgu}" scope="request"/>
<%
	IProdDao dao = new ProdDaoImpl();
	out.println(request.getAttribute("prod_lgu") + "<br/>");
	List<ProdVO> list = dao.getProdName((String)request.getAttribute("prod_lgu"));
	request.setAttribute("list", list);
%>

getLprod :

<select >
<c:forEach var="prodVO" items="${list}">
	<option value="${prodVO.prod_id}">${prodVO.prod_name}</option>
</c:forEach>
</select>
