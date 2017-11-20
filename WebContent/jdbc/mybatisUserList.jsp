<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.io.Reader, java.io.FileNotFoundException, java.io.IOException, java.sql.SQLException, java.util.List" %>
<%@ page import="jdbc.login.UserVo" %>
<%@ page import="org.apache.ibatis.io.Resources, org.apache.ibatis.session.SqlSessionFactory, org.apache.ibatis.session.SqlSessionFactoryBuilder" %>
<%@ page import="org.apache.ibatis.session.SqlSession" %>


<% 
response.setHeader("Pragma", "no-cache");			//http 1.0 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.setHeader("Cache-Control", "no-cache");	//http 1.1 , 브라우저에게 응답결과를 캐쉬하지 않도록 설정
response.addHeader("Cache-Control", "no-store");	//파이어 폭스 no-cache bug
response.setDateHeader("Expires", 1L);				//만료일자 설정
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%

	SqlSessionFactory sqlSessionFactory = null; 
	try {
		String resource = "mybatis/mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		if (sqlSessionFactory == null) {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
	} catch (FileNotFoundException fileNotFoundException) {
		fileNotFoundException.printStackTrace();
	} catch (IOException iOException) {
		iOException.printStackTrace();
	}

	SqlSession sqlSession = sqlSessionFactory.openSession();
	
	
	List<UserVo> userList = sqlSession.selectList("getUserList");
	
	for(UserVo vo : userList)
		out.print(vo.getUserId() + " / " + vo.getUserNm() + " / " + vo.getPass() + "<br/>");
	
	sqlSession.close();

%>

</body>
</html>