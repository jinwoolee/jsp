package sse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SSEservlet
 */
@WebServlet("/SSEservlet")
public class SSEservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public SSEservlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/event-stream;charset=UTF-8");
		response.setHeader("Cache-Control", "no-cache");
		response.setHeader("Connection", "keep-alive");

		PrintWriter out = response.getWriter();

		while (true) {
			out.print("id: " + "ServerTime" + "\n");
			out.print("data: " + new Date().toLocaleString() + "\n\n");
			out.flush();
			// out.close(); //Do not close the writer!
			try {
				Thread.currentThread().sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
