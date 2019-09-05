package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.Date;
import java.util.TimeZone;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/timeZone")
public class TimeZoneController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String[] timeZoneList = TimeZone.getAvailableIDs();
		req.setAttribute("timeZoneList", timeZoneList);
		
		req.setAttribute("dt", new Date());
		req.getRequestDispatcher("/jstl/timeZone.jsp").forward(req, resp);
	}
}






