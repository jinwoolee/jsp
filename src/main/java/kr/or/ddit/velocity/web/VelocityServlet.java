package kr.or.ddit.velocity.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/velocityServlet")
public class VelocityServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//3가지 영역에 임의의 값을 넣어서 vm에서 활용하도록 한다
		ServletContext application = getServletContext();
		HttpSession session = request.getSession();
		
		application.setAttribute("applicationAttr", "applicationValue");
		session.setAttribute("sessionAttr", "sessionValue");
		request.setAttribute("requestAttr", "requestValue");
		
		//list객체를 생성하여 request에 저장 --> vm foreach 구문을 통해 출력연습
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		request.setAttribute("rangers", rangers);
		
		request.getRequestDispatcher("/velocity/velocity.vm")
				.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}







