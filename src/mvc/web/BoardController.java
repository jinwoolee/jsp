package mvc.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.service.BoardService;
import mvc.service.impl.BoardServiceImpl;

public class BoardController implements IAction{
	BoardService boardService = new BoardServiceImpl();

	@Override
	public String process(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		
		Map<String, Object> resultMap = boardService.getBoardList();
		
		request.setAttribute("boardList", resultMap.get("boardList"));
		request.setAttribute("totalCnt", resultMap.get("totalCnt"));
		
		return "forward:/WEB-INF/mvc/ui/board/boardList.jsp";
	}
}
