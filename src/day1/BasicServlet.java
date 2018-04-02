package day1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	@Override
	public void init() throws ServletException {
		super.init();
	}
	
    @Override
	public void destroy() {
		super.destroy();
	}

	public BasicServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		writer.println("<!DOCTYPE html>");
		writer.println("<html>"); 
		writer.println("<head>"); 
		writer.println("	<meta charset=\"utf-8\">"); 
		writer.println("	<title>Insert title here</title>"); 
		writer.println("</head>"); 
		writer.println("<body>"); 
		writer.println("현재시간 : " + new Date()); 
		writer.println("</body>"); 
		writer.println("</html>");
		writer.flush();
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}