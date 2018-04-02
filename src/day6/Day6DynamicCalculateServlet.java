package day6;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Day6DynamicCalculateServlet
 */
@WebServlet("/Day6DynamicCalculateServlet")
public class Day6DynamicCalculateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Day6DynamicCalculateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] numbers = request.getParameterValues("number");
		String operator = request.getParameter("operator");
		
		int result = Integer.valueOf(numbers[0]);
//		for(String str : numbers){
//			sum += Integer.parseInt(str);
//		}
		for(int i = 1; i< numbers.length;i++){
			if(operator.equals("mulitply")){
				result*=Integer.valueOf(numbers[i]);
			}else if(operator.equals("plus")){
				result+=Integer.valueOf(numbers[i]);
			}else{
				result-=Integer.valueOf(numbers[i]);
			}
		}
		
		response.getWriter().println("result : " + result);
	}

}
