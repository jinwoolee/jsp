<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="rangers" type="java.lang.String" required="true"%>
<select>
	<c:forTokens items="${rangers }" delims="," var="ranger">
		<option>${ranger }</option>
	</c:forTokens>
</select>