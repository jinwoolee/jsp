package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/selectLang")
public class SelectLangServlet extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//lagn 파라미터 확인(default ko)
		String lang = req.getParameter("lang");
		lang = lang == null ? "ko" : lang;
		req.setAttribute("lang", lang);
		
		req.getRequestDispatcher("/jstl/selectLangWS.jsp")
			.forward(req, resp);
	}

}






