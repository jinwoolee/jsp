<%@page import="java.util.*"%>
<%@page import="user.model.UserVo"%>
<%@page import="java.util.List"%>
<%@page import="user.dao.UserDaoMybatis"%>
<%@page import="user.dao.IUserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<%-- <c:if> : 분기, java의 if문과는 다소 다름
	jstl의 if 단일 분기/비교
	
	java의 일반적 if 문
	if(조건){
	} 
	else if(조건){
	}
	else if(조건){
	}
	else{
	}
	
	<c:if> 단일 비교만 가능
	-->
	if(조건){
	} 
 --%>

<%-- if
	test : 비교 문장 : 표현식, EL, 문자, boolean
	var : test 결과를 저장할 변수 (활용도 낮음)
	scope : var 변수를 저장할 영역 (활용도 낮음) 
--%>

<c:if test="true">
	true이기 때문에 무조건 출력됩니다.22 <br/>
</c:if>    

<c:if test="false">
	false이기 때문에 출력되지 않습니다. <br/>
</c:if>    

일반문자 테스트 <br/>
<c:if test=" test ">
	일반문자는 false로 인식. <br/>
</c:if> 

표현식 테스트 <br/>
<%
	String code = "05";
	pageContext.setAttribute("code", code);
%>

<c:if test="<%=\"05\".equals(pageContext.getAttribute(\"code\")) %>">
	표현식 테스트 <br/>
</c:if>

EL 테스트 <br/>
<c:if test="${code == '05'}" var="testResult">
	EL 테스트 if문 안입니다.<br/>
</c:if>

\${testResult } : ${testResult } <br/><br/><br/><br/>
    

<%-- <c:choose> : 다중 분기(java if 문과 동일)
	주의점 : test 속성에 공백넣지 말것
	test=" ${code == '01' }" ==> X
	test="${code == '01' }" ==> O
 --%>

test 공백추가
<c:choose>
	<c:when test=" ${code == '01' }" >code 01</c:when>		<%-- if --%>
	<c:when test=" ${code == '02' }" >code 02</c:when>		<%-- else if --%>
	<c:when test=" ${code == '03' }" >code 03</c:when>		<%-- else if --%>
	<c:when test=" ${code == '04' }" >code 04</c:when>		<%-- else if --%>
	<c:when test=" ${code == '05' }" >code 05</c:when>		<%-- else if --%>
	<c:when test=" ${code == '06' }" >code 06</c:when>		<%-- else if --%>
	<c:otherwise>otherwise code : ${code }</c:otherwise>	<%-- else --%>	
</c:choose>
<br/><br/><br/><br/>



 
<%
	Map<String, String> pMap = new HashMap<String, String>();
	pMap.put("page", "1");
	pMap.put("pageSize", "10");
	
	IUserDao userDao = new UserDaoMybatis();
	List<UserVo> userList = userDao.getUserListPaging(pMap);
	
	for(UserVo userVo : userList){
		out.println(userVo + "<br/>");
	}
	pageContext.setAttribute("userList", userList);
%> 
<br/><br/>

<%--
	<c:forEach> : 반복처리 == java for loop
	items : 반복처리할 대상객체
	var : items 현재 처리하고 있는 객체 
 --%>
jstl forEach <br/>
<%-- java의 향상된 for문--%> 
<c:forEach var="userVo" items="${userList}" varStatus="status" >
	${userVo}<br/>
	${status.current }<br/><br/>
</c:forEach>
<br/><br/><br/>

<%--
	for(int i = 0 ; i <= userList.size(); i=i+2){
		//로직
	}
 --%>
<%-- 일반적인 for 구문
    begin : 시작인덱스
    end : 종료인덱스
    step : 인덱스 스텝(default : 1)
    varStaus: for문에 대한 상태 객체
    	- first : 첫번째 인덱스인지 (boolean)
    	- last  : 마지막 인덱스인지 (boolean)
    	- index : loop문의 현재 index
 --%> 
<c:forEach var="i" begin="0" end="9" step="2" varStatus="status">
	${userList[i].userNm} :  \${status.first} - ${status.first} /
	 						 \${status.last} - ${status.last} / 
	 						 \${status.index} - ${status.index}
	 						 \${status.begin} - ${status.begin}
	 						 \${status.end} - ${status.end}
	 						 \${status.count} - ${status.count}
	 						 \${status.step} - ${status.step}
	 						 \${status.current} - ${status.current}  <br/>
</c:forEach> 

<br/><br/><br/>


<%-- <c:forTokens> 연속된 문자열을 특정 구분자로 분리  --%>
<%
	String lineRangers = "brown,sally,cony,james,moon";
	pageContext.setAttribute("lineRangers", lineRangers);
%>

<c:forTokens var="ranger" items="${lineRangers}" delims="," >
	${ranger } <br/>
</c:forTokens>



<br/><br/><br/><br/><br/><br/>
test









    
    
    
    
    
 