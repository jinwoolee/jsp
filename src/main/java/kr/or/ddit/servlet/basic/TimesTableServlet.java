package kr.or.ddit.servlet.basic;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TimesTableServlet extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>Times tables Servlet</title>");
		pw.println("		<style>");
		pw.println("			td { ");
		pw.println("				border: 1px solid black; ");
		pw.println("			} ");
		pw.println("			table { ");
		pw.println("				width: 100% ");
		pw.println("			} ");
		pw.println("		</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table>");
		
		
		for(int j = 1; j <= 9; j++) {
			pw.println("			<tr>");
			for(int i = 2; i <= 9; i++) {
				pw.println("			<td>" + i + " * " + j + " = " + i*j + "</td>");
			}
			pw.println("			</tr>");
		}
		
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");

	}
}









