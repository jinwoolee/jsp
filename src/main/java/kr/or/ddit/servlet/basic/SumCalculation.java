package kr.or.ddit.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory.getLogger(SumCalculation.class);
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start_str = request.getParameter("start");
		String end_str = request.getParameter("end");
		
		int start = Integer.parseInt(start_str);
		int end = Integer.parseInt(end_str);
		
		//start부터 end까지의 합
		int sum = 0;
		for(int i = start; i <= end; i++) {
			sum = sum + i;
		}
		
		logger.debug("{}", sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
		
	}
}










