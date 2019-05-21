package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BasicServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.write("<html>");
		pw.write("	<head>");
		pw.write("		<title>hello, world!</title>");
		pw.write("	</head>");
		pw.write("	<body>");
		pw.write("		<table>");
		pw.write("			<tr>");
		pw.write("				<td>2*1=2</td>");
		pw.write("				<td>3*1=3</td>");
		pw.write("				<td>4*1=3</td>");
		
		pw.write("			</tr>");
		pw.write("		</table>");
		pw.write("	</body>");
		pw.write("</html>");
		pw.close();
	}

	@Override
	public void init() throws ServletException {
		System.out.println("BasicServlet init()");
	}
	
}






