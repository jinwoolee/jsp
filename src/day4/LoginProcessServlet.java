package day4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginProcessServlet
 */
@WebServlet("/LoginProcessServlet")
public class LoginProcessServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginProcessServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		LoginService loginService = new LoginService();

		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		
		boolean loginSuccess = loginService.loginProcess(userId, pass);
		
		
		//parameter
		// 웹브라우저에서(클라이언트) form : input name  : userId, pass
	
		//attribute
		//서버가, 클라이언트의 요청을 처리하고 난뒤 응답을 생성할때 첨부하는 값

		
		//로그인 성공
		if(loginSuccess == true){
			request.setAttribute("userNm", "브라운");
			
			RequestDispatcher dis = request.getRequestDispatcher("/day4/main.jsp");
			dis.forward(request, response);
			/*서블릿에서 다음 명령을 통해 사용자 이름을 등록한다.
			 request.setAttribute("userNm", "브라운");
			 등록후 request dispatch를 이용하여 main.jsp로 이동
		     main.jsp에는 request.getAttribute("userNm")을 이용하여
			 인사 문구 표시 [브라운 "님이 접속하셨습니다"]*/
			
		}
		//로그인 실패
		else{
			request.setAttribute("msg", "비밀번호를 잘못 입력하셨습니다");
			RequestDispatcher dis = request.getRequestDispatcher("/day4/login.jsp");
			dis.forward(request, response);
			
			/*userId input에 처음 요청했던 userId가 userId input에 자동설정 되도하고
			userId input 위에 : "비밀번호가 잘못되었습니다" 라는 메세지를 작성해준다*/
		}
	}

}
