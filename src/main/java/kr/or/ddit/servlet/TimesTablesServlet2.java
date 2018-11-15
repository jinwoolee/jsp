package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class TimesTablesServlet2 extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		
		
		pw.println("<!DOCTYPE html>");
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<meta charset=\"UTF-8\">");
		pw.println("		<title>Insert title here</title>");
		pw.println("			<style>");
		pw.println("				td {border: 1px solid pink}");
		pw.println("			</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("	timesTables2");
		pw.println("		<table>");
		for(int gob = 1;gob<10;gob++ ){
			pw.println("		<tr>");
			for(int dan = 2; dan <10; dan++){
				pw.println("			<td>@"+dan+" ���ϱ� " + gob +" = " + dan*gob + "@</td>");
			}
			pw.println("		</tr>");
			
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
		
		
		
	}
	
}
