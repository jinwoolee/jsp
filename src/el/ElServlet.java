package el;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.model.BoardVo;

/**
 * Servlet implementation class ElServlet
 */
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//map
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("key", "value");
		req.setAttribute("map", map);
		
		//list
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		for(int i = 1; i <= 10; i++)
			boardList.add(new BoardVo(i, "게시글 제목" + i, "게시글내용입니다", "userId", "2017-10-18"));
		req.setAttribute("boardList", boardList);
		
		//session
		HttpSession session = req.getSession();
		session.setAttribute("sessionValue", "session-Value");
		session.setAttribute("sameValue", "sameValue-session");
		
		//request
		req.setAttribute("requestValue", "request-Value");
		req.setAttribute("sameValue", "sameValue-reuqest");
		
		req.setAttribute("totalCnt", 15);
		
		RequestDispatcher rd = req.getRequestDispatcher("/serverProgram/jsp/el/el.jsp");
		rd.forward(req, res);
	}
}