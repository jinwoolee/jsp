<%--<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<jsp:doBody></jsp:doBody> --%>

<%@ tag language="java" pageEncoding="UTF-8" body-content="scriptless"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ variable name-given="varFromTag" variable-class="java.lang.String" scope="AT_BEGIN" %>

<c:set var="varFromTag" value="test"/>
<jsp:doBody></jsp:doBody>