package kr.or.ddit.util.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/cookieList")
public class CookieServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//로직처리
		/////////
		
		//화면구성은 jsp로 위임
		req.getRequestDispatcher("/jsp/cookieList.jsp").forward(req, resp);
	}	
}





