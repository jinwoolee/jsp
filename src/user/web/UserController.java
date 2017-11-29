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
import user.model.UserVo;
import util.DefaultConst;
import util.NaviUtil;

/**
 * Servlet implementation class UserController
 */
@WebServlet(urlPatterns= {"/user/userList", "/user/getUser"})
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
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// localhost:8090/user.do로 서블릿 접속
		// mybatis 모듈을 이용하여 userList 조회
		// 조회된 userList를 /user/user.jsp에 전달
		// /user/user.jsp에서는 해당 결과를 화면에 출력
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		
		System.out.println("uri : " + uri);
		
		if(uri.equals("/user/userList"))
			userList(request, response);
		else if(uri.equals("/user/getUser"))
			getUser(request, response);
	}

	/**
	  * @FileName : UserController.java
	  * @Project : jsp
	  * @Date : 2017. 11. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @프로그램 설명 : 사용자 정보 조회
	  */
	private void getUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		String userId = request.getParameter("userId");
		Map<String, String> pMap = new HashMap<String, String>();
		pMap.put("userId", userId);
		UserDao userDao = new UserDaoMyBatisImpl();
		
		try {
			UserVo userVo = userDao.getUser(pMap);
			request.setAttribute("userVo", userVo);
		} catch (SQLException e) {
			request.setAttribute("userVo", new UserVo());
			e.printStackTrace();
		} 
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userView.jsp");
		rd.forward(request, response);
	}

	/**
	  * @FileName : UserController.java
	  * @Project : jsp
	  * @Date : 2017. 11. 29.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @throws ServletException
	  * @throws IOException
	  * @프로그램 설명 : 사용자리스트 조회(페이징)
	  */
	private void userList(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UserDao userDao = new UserDaoMyBatisImpl();
		try {

			// request.setAttribute("userList", userDao.getUserList());

			// 유저 리스트 페이징 처리
			Map<String, Integer> paramMap = new HashMap<String, Integer>();

			// 사용자가 /user.do 로접속
			// 1. page, pageSize를 파라미터로 보낸경우
			/// user.do?page=1&pageSize=10

			// 2. page, pageSize를 파라미터로 안보낸경우
			// --> controller에서 default로 page = 1, pageSize = 10

			// page, pageSize
			// 조회 하고자 하는 페이지, 페이지 사이즈 : 파라미터로 넘어오지 않을경우 default 1, 10
			String pageParam = request.getParameter("page");
			String pageSizeParam = request.getParameter("pageSize");

			int page = pageParam == null ? 1 : Integer.valueOf(pageParam);
			int pageSize = pageSizeParam == null ? DefaultConst.PAGESIZE : Integer.valueOf(pageSizeParam);

			paramMap.put("page", page);
			paramMap.put("pageSize", pageSize);

			request.setAttribute("userList", userDao.getUserListPaging(paramMap));

			String html = NaviUtil.makePageNav(request.getContextPath() + "user.do", userDao.getUserTotalCnt(),
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
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		
		System.out.println("uri : " + uri);
		
		if(uri.equals("/user/delUser"))
			delUser(request, response);
	}

	/**
	  * @FileName : UserController.java
	  * @Project : jsp
	  * @Date : 2017. 11. 30.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @프로그램 설명 : 사용자 삭제
	  */
	private void delUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDaoMyBatisImpl();
		
		//사용자 정보
		String userId = request.getParameter("usreId");
		
		//사용자 정보가 정상적으로 들어오지 않은 경우
		if(userId == null) {
			RequestDispatcher rd = request.getRequestDispatcher("user/userList");
			rd.forward(request, response);
		}
		//사용자 정보가 정상적으로 들어온 경우
		else {
			Map<String, String> pMap = new HashMap<String, String>();
			pMap.put("userId", userId);
			int delCnt = 0;
			
			try {
				delCnt = userDao.deleteUser(pMap);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			//delCnt == 1 :정상삭제, delCnt == 0 :비정상
			String msg = null;
			if(delCnt == 1)
				msg = "삭제되었습니다.";
			else if(delCnt == 0)
				msg = userId + " 정상적으로 삭제되지 않았습니다.";
			
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("user/userList");
			rd.forward(request, response);
		}
	}
}
