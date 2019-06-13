<%@tag import="kr.or.ddit.prod.dao.ProdDao"%>
<%@tag import="kr.or.ddit.prod.dao.IprodDao"%>
<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="code" required="true"%>
<%	
	IprodDao prodDao = new ProdDao();
	jspContext.setAttribute("prodList", prodDao.getProdList(code));
%>
<select>
	<c:forEach items="${prodList }" var="prod">
		<option value="${prod.prod_id }">${prod.prod_name }</option>
	</c:forEach>
</select>









