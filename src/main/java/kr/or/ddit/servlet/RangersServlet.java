package kr.or.ddit.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.javafx.collections.ListListenerHelper;

import kr.or.ddit.rangers.model.RangerVo;
import kr.or.ddit.rangers.service.RangersService;

@WebServlet("/rangersList")
public class RangersServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//service 객체를 이용하여 rangerList를 조회
		RangersService rangersService = new RangersService();
		List<String> rangersList = rangersService.getAll();
		List<RangerVo> rangersVoList = rangersService.getRangerVoAll();
		
		//해당 데이터를 request 영역에 설정
		req.setAttribute("rangersList", rangersList);
		req.getSession().setAttribute("rangersVoList", rangersVoList);
		
		// 서로다른 영역에 같은 이름의 속성을 정의
		
		//request attribute
		req.setAttribute("userName", "brown_request");	
		
		//session attribute
		HttpSession session = req.getSession();
		session.setAttribute("userName", "brown_session");
		session.removeAttribute("userName");
		
		//application attribute --> ServletContext
		ServletContext application = getServletContext();
		application.setAttribute("userName", "brown_application");
		
		
		
		
		
		
		
		// /rangers/ragnersList.jsp로 forward
		// rangersList.jsp에서는 해당 데이터를 출력
		req.getRequestDispatcher("/rangers/rangersList.jsp")
								.forward(req, resp);
	}
}





