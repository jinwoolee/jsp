package kr.or.ddit.sum;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/sumCalculation")
public class SumCalculationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//기존 view 요청 get : localhost:8081/jsp/sumInput.jsp
		//변경 view 요청 get : localhost:8081/sumCalculation
		//sumInput.jsp forward
		
		RequestDispatcher rd = request.getRequestDispatcher("/jsp/sumInput.jsp");
		rd.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String start_str = request.getParameter("start");
		String end_str = request.getParameter("end");
		
		int start = Integer.parseInt(start_str);
		int end = Integer.parseInt(end_str);
		
		CalculationLogic logic = new CalculationLogic();
		int sum = logic.sumBetweenTwoNumbers(start, end);
		
		System.out.println("sum : " + sum);
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", sum);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp")
			.forward(request, response);
		
	}

}
