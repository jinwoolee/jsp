package kr.or.ddit.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTablesServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter();
		
		writer.println("<table border='1'> ");
		
		for(int i = 1; i <= 9; i++) {
			writer.println("	<tr>");
			
			for(int j = 2; j <= 9; j++) {
				writer.println("		<td>" + j + " * " + i + " = " + i*j + "</td>");
			}
			writer.println("	</tr>");
		}
		writer.println("</table> ");
	}
}
