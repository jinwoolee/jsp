package kr.or.ddit.mvc.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
 * 모든 요청을 가장 앞에서 받는 FrontController
 * 지금까지 서블릿을 생성할때 doGet, doPost재정의
 * -->service 메소드 재정의(모든 요청 메소드의 요청을 받기 위해서)
 */
public class FrontController extends HttpServlet{
	private static final Logger logger = LoggerFactory.getLogger(FrontController.class);

	private HandlerMapper handlerMapper;
	
	@Override
	public void init() throws ServletException {
		handlerMapper = new HandlerMapper();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		logger.debug("request method : {}", req.getMethod());
		
		//아래 클래스는 HttpServlet 클래스를 상속받지 않는 pojo형태의 클래스
		// /userList.do --> UserListController
		// /memberList.do --> MemberListController
		
		logger.debug("req.getRequestURI() : {}", req.getRequestURI());
		
		String uri = req.getRequestURI();
		
		IController controller = handlerMapper.getController(uri);
		controller.exeucte(req, resp);
		
	}
	
}





