package kr.or.ddit.request;

import java.io.IOException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.UserVo;

/**
 * Servlet implementation class RequestServlet
 */
@WebServlet("/requestServlet")
public class RequestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//parameter userId, name
		//파라미터 : 클라이언트가 서버로 보내는 정보
		String userId = request.getParameter("userId");
		String name = request.getParameter("name");
		
		//request 정보에 값을 저장
		UserVo userVo = getUser(userId);
		request.setAttribute("userVo", userVo);
		
		HttpSession session = request.getSession();
		session.setAttribute("userVo", userVo);
		
		//dispatch forward : request/requestResult.jsp
		//RequestDispatcher rd = request.getRequestDispatcher("request/requestResult.jsp");
		//rd.forward(request, response);
		
		//redirect
		response.sendRedirect("request/requestResult.jsp");
	}
	
	public UserVo getUser(String userId){
		//userId 매개변수를 이용하여 사용자 정보를 db에서 조회
		UserVo userVo = new UserVo();
		userVo.setUserId(userId);
		userVo.setName("브라운");
		userVo.setAlias("곰");
		userVo.setBirth(new Date());
		
		return userVo;
	}

}











