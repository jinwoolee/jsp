<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="user.dao.*"%>
<%@ page import="user.model.UserVo" %>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	
	UserDao userDao = new UserDaoMyBatisImpl();

	//사용자 정보 임의 조회
	Map<String, Integer> pMap = new HashMap<String, Integer>();
	pMap.put("page", 1);
	pMap.put("pageSize", 10);
	List<UserVo> userList = userDao.getUserListPaging(pMap);
	pageContext.setAttribute("userList", userList);
%>

<%-- items -> userVo --%>
<c:forEach var="userVo" items="${pageScope.userList }" step="2" varStatus="status">
	${status.first } / ${status.last } / ${status.step } / ${status.count } <br/>
	 ${userVo.userId }  / ${userVo.userNm } / ${userVo.userAlias } <br/> 
</c:forEach><br/><br/>


pageScope.userList.size() : ${userList.size()} <br/>
<c:forEach var="i" begin="0" end="${userList.size()}">
${userList[i].userId}  / ${userList[i].userNm } / ${userList[i].userAlias } <br/>
</c:forEach><br/><br/>


