package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * BasicServlet.java
 * 
 * @author jw
 * @since 2017. 9. 25.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 9. 25.    jw				최초 생성
 *
 * </pre>
 */
public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public BasicServlet() {
        super();
    }

    //http://localhost:8080/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html; charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String param = request.getParameter("param");
		String queryParam = request.getParameter("queryParam");
		
		System.out.println("param : " + param);
		System.out.println("queryParam : " + queryParam);
	    
		System.out.println("request character set : " + request.getCharacterEncoding());
		System.out.println("response character set : " + response.getCharacterEncoding());
		
		//response character set 기본 설정
		//If no charset is specified, ISO-8859-1 will be used
		//setCharacterEncodingFilter
		//https://tomcat.apache.org/tomcat-5.5-doc/servletapi/javax/servlet/ServletResponse.html
		
		PrintWriter writer = response.getWriter();
		writer.append("<html>");
		writer.append("	<head>");
		writer.append("		<title>servlet test</title>");
		writer.append("	</head>");
		writer.append("	<body>");
		writer.append("		<span> 현재 시간: " + new Date() + "</span>");
		writer.append("		<span> param : " + param + "</span>");
		writer.append("	</body>");
		writer.append("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}