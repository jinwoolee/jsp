package kr.or.ddit.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/logout")
public class LogoutController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LogoutController.class);
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		logger.debug("logoutController.doGet");
		
		//로그아웃 --> login시 등록된 S_USERVO 속성을 세션에서 제거
		HttpSession session = request.getSession();
		
		//세션에서 속성제거 2가지 방법
		//session.removeAttribute("S_USERVO");	//특정 속성만 제거
		session.invalidate();		//세션에 저장된 모든 속성을 제거
		
		//SessionListener에 removeAttribute 메소드가 실행
		
		//로그인 화면으로 이동
		response.sendRedirect(request.getContextPath() + "/login");
	}
}





