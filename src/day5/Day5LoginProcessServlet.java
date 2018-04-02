package day5;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Day5LoginProcessServlet
 */
@WebServlet("/Day5LoginProcessServlet")
public class Day5LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Day5LoginProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 user id : <input type="text" name="userId" value="<%= request.getParameter("userId") == null ? "" : request.getParameter("userId") %>"/> <span id="userIdDesc1"></span><br/>
		 password : <input type="password" name="pass" /> <span id="passwordDesc"><%= msg %></span> <br/>
		 */
		
		String	userId  =	request.getParameter("userId");
		String	pass	=	request.getParameter("pass");
		
		boolean loginResult = loginProcess(request, userId, pass);
		
		//loginResult == true : 정상사용자 인증 --> day5/main.jsp : userNm 출력
		//loginReulst == flase : 사용자 인증 실패 --> day5/login.jsp, userId를 login.jsp화면에 설정
		// dispatch 방식 이용
		
		//loginResult == true : 정상사용자 인증 --> day5/main.jsp : userNm 출력
		if(loginResult){
			RequestDispatcher rd = request.getRequestDispatcher("/day5/main.jsp");
			rd.forward(request, response);
		}
		else{
			request.setAttribute("msg", "비밀번호를 잘못 입력하셨습니다");
			RequestDispatcher rd = request.getRequestDispatcher("/day5/login.jsp");
			rd.forward(request, response);
		}
	}

	private boolean loginProcess(HttpServletRequest request, String userId, String pass) {

		if(userId.equals("brown") || userId.equals("cony")){
			if(pass.equals("admin")){
				request.setAttribute("userNm", "***" + userId + "***");
				return true;
			}
		}
			
		return false;
	}
}
