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
/*
 * /user/userList 		:	사용자 리스트 조회
 * /user/getUser 		:	사용자 상세 조회
 * /user/deleteUser 	:	사용자 삭제
 * /user/userFormView	:	사용자 폼 화면(신규입력/수정)
 * /user/userForm		:	사용자 등록/수정
 * /user/insertUser		:	사용자 추가
 */
@WebServlet(urlPatterns= {"/user/userList", "/user/getUser", "/user/deleteUser", "/user/userFormView", "/user/userForm"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UserController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		
		System.out.println("uri : " + uri);
		
		if(uri.equals("/user/userList"))
			userList(request, response);
		else if(uri.equals("/user/getUser"))
			getUser(request, response);
		else if(uri.equals("/user/userFormView"))
			userFormView(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		uri = uri.replace(request.getContextPath(), "");
		
		System.out.println("uri : " + uri);
		
		if(uri.equals("/user/deleteUser"))
			deleteUser(request, response);
		else if(uri.equals("/user/userForm"))
			userForm(request, response);
	}

	/** 
	 * Method   : userForm
	 * 최초작성일  : 2017. 11. 30. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param request
	 * @param response 
	 * Method 설명 : 사용자 정보 입력/수정
	 */
	private void userForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int modifyCnt = 0;
		String method 		= request.getParameter("method");
		String userId 		= request.getParameter("userId");
		String userNm 		= request.getParameter("userNm");
		String userAlias		= request.getParameter("userAlias");
		String pass			= request.getParameter("psss");
		
		UserVo userVo	= new UserVo(userId, userNm, userAlias, pass);
		UserDao userDao	= new UserDaoMyBatisImpl();
		
		try {
			if(method.equals("insert"))
				modifyCnt = userDao.insertUser(userVo);
			else if(method.equals("update"))
				modifyCnt = userDao.updateUser(userVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		//입력/수정이 성공시 => 사용자 상세 조회 화면으로 이동
		if(modifyCnt == 1)
			getUser(request, response);
		//실패시 입력화면으로 이동
		else
			userFormView(request, response);
			
	}

	/** 
	 * Method   : updateUserView
	 * 최초작성일  : 2017. 11. 30. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException 
	 * Method 설명 : 사용자 수정 view
	 */
	private void userFormView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		//insert / method 구분
		String method = request.getParameter("method");
		method = method == null ? "insert" : method;
		request.setAttribute("method", method);
		
		//사용자 id input disabled
		String userIdDisabled = "disabled";
		if(method.equals("insert"))
			userIdDisabled = "";
		else
			userIdDisabled = "disabled";
		request.setAttribute("userIdDisabled", userIdDisabled);
		
		//사용자 정보 조회
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
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userForm.jsp");
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

			String html = NaviUtil.makePageNav(request.getContextPath() + "/user/userList", userDao.getUserTotalCnt(),
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
	  * @FileName : UserController.java
	  * @Project : jsp
	  * @Date : 2017. 11. 30.
	  * @작성자 : jw
	  * @변경이력 :
	  * @param request
	  * @param response
	  * @프로그램 설명 : 사용자 삭제
	  */
	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		UserDao userDao = new UserDaoMyBatisImpl();
		
		//사용자 정보
		String userId = request.getParameter("userId");
		
		//사용자 정보가 정상적으로 들어오지 않은 경우 : 사용자 리스트 화면으로 이동
		if(userId == null) {
			/*RequestDispatcher rd = request.getRequestDispatcher("/user/userList");
			rd.forward(request, response);*/
			userList(request, response);
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
			String 	msg = null;
			String	path	=	"";
			if(delCnt == 1){
				msg 	=	"삭제되었습니다.";
				request.setAttribute("msg", msg);
				userList(request, response);
			}
			else if(delCnt == 0) {
				msg 	=	userId + " 정상적으로 삭제되지 않았습니다.";
				request.setAttribute("msg", msg);
				getUser(request, response);
			}
		}
	}
}
