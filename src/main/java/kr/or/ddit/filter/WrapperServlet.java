package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/wrapper")
public class WrapperServlet extends HttpServlet{
	
	//wrapper test page 요청
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/wrapper/wrapperTest.jsp").forward(req, resp);
	}

	//wrapper test page에서 파라미터 전송 요청
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/wrapper/wrapperResult.jsp").forward(req, resp);
	}	
}



