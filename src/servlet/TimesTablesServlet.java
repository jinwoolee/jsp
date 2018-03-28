package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class TimesTablesServlet
 */
@WebServlet("/TimesTablesServlet")
public class TimesTablesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimesTablesServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		
		out.write("<!DOCTYPE html>");
		out.write("<html>");
		out.write("<head>");
		out.write("<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">");
		out.write("<title>Insert title here</title>");
		out.write("<style>");
		out.write("td{border : 1px solid black;");
		out.write("   padding : 10px;");
		out.write("}");
		out.write("</style>");
		out.write("</head>");
		out.write("<body>");
		out.write("<table>");
		for(int i = 1; i <= 9; i++) {
			out.write("<tr>");
			for(int j = 2; j <= 9; j++) {
				out.write("<td>" + j + " * " + i  + " = " + (i*j) + "</td>");
			}
			out.write("</tr>");
		}
		
		out.write("</table>");
		out.write("</body>");
		out.write("</html>");
	}
}
