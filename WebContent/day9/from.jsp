<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--

1.jsp 액션태그를 이용한 페이지 흐름제어  
2.jsp 액션태그를 이용한 페이지 모듈화

from.jsp / to.jsp 에서는 액션 태그를 이용한 페이지 흐름제어를 학습한다.
기존 페이지 흐름제어 방법 2가지
1.response.sendirect
2.RequestDispatcher rd = request.getRequestDispatcher(PATH);
 rd.(request, response);
 
3.액션 태그를 통해 흐름제어 ==  RequestDispatcher 방식과 거의 유사

테스트 방식
localhost:8090/day9/from.jsp에 접속시
액션태그를 이용하여 /day9/to.jsp로 이동
--%>

<%--기존 사용 방법
RequestDispatcher dis = request.getRequestDispatcher("/day9/to.jsp");
dis.forward(request, response);
 --%>


<%--
액션 태그 (<jsp:forward>)를 통해서 페이지 흐름제어시 이동하는 page에 파라미터를 전달해줄 수 있다.
 --%>

<jsp:forward page="/day9/to.jsp">
	<jsp:param name="fromJsp" value="fromJspValue"/>
</jsp:forward>

<%--
상단의 <jsp:forwrad> 액션태그를, 기존 requestDsipatch 방식으로 완벽하게 변환이 불가능하다
위의 액션태그를 기존 방식으로 바꾸면 아래와 같다.
 --%>
<%
//request 객체에는 setParameter 메소드가 없다. --> 추후 requestWrapper 객체 학습 예정
//request.setParameter("fromJsp", "fromjspValue");

RequestDispatcher dis = request.getRequestDispatcher("/day9/to.jsp");
dis.forward(request, response);
%>




