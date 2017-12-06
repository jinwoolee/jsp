package board.web;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Globals;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import util.ControllerUtil;

/**
 * Servlet implementation class BoardController
 */
@WebServlet(urlPatterns= {"/board/boardList"})
public class BoardController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private Logger logger = LoggerFactory.getLogger(BoardController.class);
       
    public BoardController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = ControllerUtil.parseUri(request, response);
		
		logger.debug("uri : {}", uri);
		
		if(uri.equals("/board/boardList"))
			boardList(request, response);
		
	}


	

	/**
	  * @FileName : BoardController.java
	  * @Project : jsp
	  * @Date : 2017. 12. 7.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @프로그램 설명 : 게시물 페이징 조회
	  */
	private void boardList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		RequestDispatcher rd = request.getRequestDispatcher("/board/boardList.jsp");
		rd.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
