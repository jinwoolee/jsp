package day4;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class RedirectForm
 */
@WebServlet("/RedirectDispatchForm")
public class RedirectDispatchForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RedirectDispatchForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String gb = request.getParameter("gb");
		
		//redirect
		if(gb.equals("01")){
			request.setAttribute("receivedGb", gb);
			response.sendRedirect("/day4/redirectResult.jsp");
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionGb", gb);
		}
		//request dispatch
		else if(gb.equals("02")){
			request.setAttribute("receivedGb", gb);
			
			HttpSession session = request.getSession();
			session.setAttribute("sessionGb", gb);
			
			RequestDispatcher dis = request.getRequestDispatcher("/day4/dispatchResult.jsp");
			dis.forward(request, response);
		}
		else{
			PrintWriter pw = response.getWriter();
			pw.println("올바르지 않은 선택 값입니다.");
			pw.println("gb : " + gb);
		}
	}
}
