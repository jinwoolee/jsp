<%@ tag language="java" pageEncoding="UTF-8" %>
<%@ tag import="java.sql.DriverManager"%>
<%@ tag import="java.sql.Connection"%>
<%@ tag import="java.sql.ResultSet"%>
<%@ tag import="java.sql.PreparedStatement"%>
<%@ attribute name="code" required="true" %>
code : ${code} <br>
<%
    String code = (String)jspContext.getAttribute("code");
    final   String  driver      =   "oracle.jdbc.driver.OracleDriver";
    final   String  url         =   "jdbc:oracle:thin:@127.0.0.1:1521:orcl";
    final   String  user        =   "pc01";
    final   String  pass        =   "java";
    
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null; 

    try{
        Class.forName(driver);
        conn = DriverManager.getConnection(url, user, pass);
        pst = conn.prepareStatement("select prod_id, prod_name from prod where prod_lgu= ?");
        pst.setString(1, code);     //index는 0이 아닌 1번부터 시작한다.
        
        rs = pst.executeQuery();
        
        out.write("<select>");
        while(rs.next())
            out.write("<option id=\"" + rs.getString("prod_id") + "\">" + rs.getString("prod_name") + "</option>");
        out.write("<select>");
        
        conn.close();
    }catch(Exception e){
        e.printStackTrace();
    }
%>