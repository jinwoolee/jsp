<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.DriverManager"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	body { text-align: center;}
	#myCanvas {
		margin-top : 300px;
		border : 1px solid #000;
	}
	
	span {
		line-height: 100px;
	    width: 100px;
	    display: block;
	    height: 100px;
	   
	    font-size: 20px;
	    font-weight: bold;
	    
	    -webkit-animation: spin 3s infinite linear;
	  	-o-animation: spin 3s infinite linear;
	  	-moz-animation: spin 3s infinite linear;
	  	animation: spin 3s infinite linear;
	}
	.con {
		 width:100px; height:100px; margin: 300px auto; transform: rotate(30deg)
		  border-radius: 50%;
		  margin: 0,0,0,0;
		  background-color: #0000FF;
		   border: 1px solid #ccc;
		   -webkit-transition:width 2s, height 2s, background-color 2s, -webkit-transform 2s;
    transition:width 2s, height 2s, background-color 2s, transform 2s, color 2s, border:3s margin:3;
		 }
	.con:HOVER{
		margin: 100,0,0,0;
		background-color: #FFCCCC;
		color: #ffff00;
		border: 5px solid #ff000;
		 transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;
	    border-radius: 50%;
	}
	
	@-webkit-keyframes spin {
	    0%  {-webkit-transform: rotate(0deg);
	    	-webkit-transform: translateX(0);
	    }
	    100% {-webkit-transform: rotate(360deg);
	     transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;}
	}
	 
	@-moz-keyframes spin {
	   0%  {-moz-transform: rotate(0deg);}
	    100% {-moz-transform: rotate(360deg);
	     transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;}
	}
	@keyframes spin {
	    0%  {transform: rotate(0deg);}
	    100% {transform: rotate(360deg);
	    	 transform: scale(4.05) !important;
	    -webkit-transform: scale(4.05) !important;
	    -moz-transform: scale(4.05);
	    -o-transform: scale(4.05);
	    -webkit-transition: .2s;
	    -moz-transition: .2s;
	    -ms-transition: .2s;
	    
	    }
	    
	}
	
	
	
</style>
</head>
<body>
	<!-- <canvas id="myCanvas" width="200" height="200"></canvas>
	 -->
	<%
	// DB작업에 필요한 객체변수 선언
			
			int randomNo = (int)(Math.random()*19)+1;
	
			Connection conn = null;
			Statement stmt = null;
			ResultSet rs = null;	// 쿼리문이 select일때만 필요하다.
			
			int no_203 = 0;
			String name_203 = null;
			
			try{
				// 1. JBDC 드라이버 로딩  ==> Class.forName()을 이용한다.
				Class.forName("oracle.jdbc.driver.OracleDriver");
				
				// 2. 해당 DB에 접속하기 ==> 접속
				//		==> DriverManger.getConnection()을 이용하고
				//		==> 접속이 성공하면 Connection객체가 생성된다.
				String url = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "sem"; // 등록된 사용자 id
				String pass = "java"; // 등록된 사용자 암호
				
				conn = DriverManager.getConnection(url, user, pass);
				
				// 3. Statement객체 또는 PreparedStatement 객체 생성 질의를 수행하고 결과를 받아오는 객체
				//					  ==> 이 객체의 생성은 Connection객체를 이용한다.
				stmt = conn.createStatement();
				
				// 4. Statement객체를 이용하여 질의를 수행하고
				//	    결과를 받아서 ResultSet객체에 담는다.
				//	  (단, ResultSet객체는 Select문일 때만 사용한다.)
				String sql = "select * from JSPSTUDENT where no =" + randomNo;// 실행할 sql명령
				rs = stmt.executeQuery(sql); // sql명령이 select일 경우 
											 // 기타 insert, update, delete 명령일 때는
											 // executeUpdate()를 사용한다. 
				
				// 5. ResultSet 객체에 저장되어 있는 자료를 
				//	    반복문과 next()메서드를 이용하여 차례로 읽어와 처리한다.
				System.out.println("실행 쿼리문 :" + sql);
				System.out.println("============================");
				
				// rs.next() ==> ResultSet 객체의 데이터를 가리키는 포인터를 다음 레코드로
				//			 ==> 이동시키고 그 곳에 데이터가 있으면 true, 없으면 false를 반환한다.
				
				
				while(rs.next()){
					//out.println(rs.getInt("no"));
					//out.println(rs.getString("name"));
					
					no_203 = rs.getInt("no") ;
					name_203 = rs.getString("name");
					
				}
				System.out.println();
				System.out.println("출력끝");
				
				
			} catch (SQLException e){
				e.printStackTrace();
			} catch (ClassNotFoundException e) {

				e.printStackTrace();
			} finally{
				// 6. 사용했던 자원을 반납한다.
				if(rs != null)try{rs.close();}catch (Exception e2) {}
				if(rs != null)try{stmt.close();}catch (Exception e2) {}
				if(rs != null)try{conn.close();}catch (Exception e2) {}
			}
			
	
	%>
	
	
	<div class="con">
		<span style=" width: 100px; height: 100px; border:1px solid #ccc"><%=name_203%></span>
	</div>
	
	<div> 마우스를 올려주세요.</div>
	
	<!-- 
	<script type="text/javascript">
		var name = "<%=name_203%>";
		var canvas = document.getElementById("myCanvas");
		var ctx = canvas.getContext("2d");
		ctx.fillStyle = "#0f0";
		//ctx.fillRect(0,0,150,75); 
		
		ctx.beginPath();
		ctx.arc(100,100,100,0,2*Math.PI);
		ctx.stroke();
		ctx.font = "60px Arial";
		ctx.fillText(name, 10 ,122);
	</script>
	 -->
</body>
</html>