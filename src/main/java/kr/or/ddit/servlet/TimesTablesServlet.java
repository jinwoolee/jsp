package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("text/html; charset=utf-8");
		PrintWriter pw = resp.getWriter();
		
		pw.print("<!DOCTYPE html>");
		pw.print("<html>");
		pw.print("<head>");
		pw.print("<meta charset=\"UTF-8\">");
		pw.print("<title>Insert title here</title>");
		pw.print("<style>");
		pw.print("	td {	border : 1px solid pink;");
		pw.print("	}");
		pw.print("</style>");
		pw.print("</head>");
		pw.print("<body>");
		pw.print("<table>");
		
		for(int j = 1; j < 10; j ++){
			pw.print("	<tr>");
			for(int i = 2; i < 10; i ++){
				pw.print("		<td>" + i + "*" + j + "=" + i*j +"</td>");
			}
			pw.print("	</tr>");		
		}
		pw.print("	</table>");
		pw.print("	</body>");
		pw.print("	</html>");
	
	}
}
