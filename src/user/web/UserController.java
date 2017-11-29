package user.web;

import java.io.IOException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import user.dao.UserDao;
import user.dao.UserDaoMyBatisImpl;
import util.DefaultConst;
import util.NaviUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet("/user.do")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//localhost:8090/user.do로 서블릿 접속
		//mybatis 모듈을 이용하여 userList 조회 
		//조회된 userList를 /user/user.jsp에 전달
		// /user/user.jsp에서는 해당 결과를 화면에 출력
    	
    	UserDao userDao = new UserDaoMyBatisImpl();
    	try {
			//request.setAttribute("userList", userDao.getUserList());
    		
    		//유저 리스트 페이징 처리
    		Map<String, Integer> paramMap = new HashMap<String, Integer>();
    		
    		// 사용자가 /user.do 로접속
    		// 1. page, pageSize를 파라미터로 보낸경우
    		///user.do?page=1&pageSize=10
    		
    		// 2.  page, pageSize를 파라미터로 안보낸경우
    		//		--> controller에서 default로 page = 1, pageSize = 10
    		
    		//page, pageSize
    		//조회 하고자 하는 페이지, 페이지 사이즈 : 파라미터로 넘어오지 않을경우 default 1, 10
    		String	pageParam		=	request.getParameter("page");
    		String	pageSizeParam	=	request.getParameter("pageSize");
    		
    		int	page		=	pageParam == null ? 1 : Integer.valueOf(pageParam);
    		int	pageSize	=	pageSizeParam == null ? DefaultConst.PAGESIZE : Integer.valueOf(pageSizeParam); 
    		
    		
	    	paramMap.put("page", page);
	    	paramMap.put("pageSize", pageSize);
	    	
    		request.setAttribute("userList", userDao.getUserListPaging(paramMap));
    		
    		String html = NaviUtil.makePageNav(request.getContextPath() + "user.do", 
    											userDao.getUserTotalCnt(),
    											Integer.valueOf(page), DefaultConst.PAGESIZE);
			request.setAttribute("pageNav", html);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/user/user.jsp");
    	rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
