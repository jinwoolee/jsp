package user.web;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.codehaus.jackson.map.ObjectMapper;

import user.dao.IUserDao;
import user.dao.UserDaoMybatis;
import user.model.UserVo;
import user.service.IUserService;
import user.service.UserServiceImpl;
import util.DefaultConst;
import util.NaviUtil;
import util.PartsUtil;

/**
 * Servlet implementation class UserController
 */
/*
 * 사용자 리스트 : /user.do          ==> doGet (조회성)
 * 사용자 상세정보 조회 : /userView.do  ==> doGet (조회성)
 * 사용자 삭제 : /userDelete.do  ==> doPost (트랜잭션 발생)
 * 사용자 삭제 ajax /userDeleteAjax.do
 * 사용자 수정/신규입력 view : /userFormView.do ==> doGet (조회성)
 * 사용자 수정/신규입력 기능 호출 : /userForm.do ==> doPost(트랜잭션)
 * 사용자 리스트 ajax view : /userAjax.do
 * 사용자 리스트 ajax      : /userAjaxPage.do
 */
@WebServlet(urlPatterns={"/user.do", "/userView.do", "/userDelete.do",
						"/userFormView.do", "/userForm.do",
						"/checkDupId.do",
						"/userAjax.do", "/userAjaxPage.do"})
@MultipartConfig(maxFileSize=1024*1024*2, maxRequestSize=1024*1024*5)
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
    	System.out.println("doGet : " + request.getRequestURI());
    	
    	String uri = request.getRequestURI();
    	uri = uri.replace(request.getContextPath(), "");
    	
    	if(uri.equals("/user.do"))
    		user(request, response);
    	if(uri.equals("/userAjax.do"))
    		userAjax(request, response);
    	if(uri.equals("/userAjaxPage.do"))
    		userAjaxPage(request,response);
    	else if(uri.equals("/userView.do"))
    		userView(request, response);
    	else if(uri.equals("/userFormView.do"))
    		userFormView(request, response);
    	else if(uri.equals("/checkDupId.do"))
    		checkDupId(request, response);
	}
    
    /**
     * 사용자 페이징 조회
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    private void userAjaxPage(HttpServletRequest request,
			HttpServletResponse response)  throws ServletException, IOException{
    	response.setContentType("text/json");
    	response.setCharacterEncoding("utf-8");
    	
    	//사용자 리스트 페이징 조회로직 추가
    	

    	//IUserDao userDao = new UserDaoMybatis();
    	IUserService userService = new UserServiceImpl();
    	try {
			//유저 리스트 페이징 처리
    		Map<String, String> paramMap = new HashMap<String, String>();
    		
    		String	page		=	request.getParameter("page");
    		String	pageSize	=	request.getParameter("pageSize");
    		
    		page		=	page == null ? "1" : page;
    		pageSize	=	pageSize == null ? String.valueOf(DefaultConst.PAGESIZE) : pageSize;
    		
	    	paramMap.put("page", page);
	    	paramMap.put("pageSize", pageSize);
	    	
    		List<UserVo> userList = userService.getUserListPaging(paramMap);
    		
    		//page내비게이션 에 대한 json 문자열 생성 로직 추가 필요
    		String pageNav = NaviUtil.makePageNavForFunc(userService.getUserTotalCnt(), Integer.parseInt(page), Integer.parseInt(pageSize));
    	
    		//userList -> json 응답으로 변경
    		//기존 : userList 객체만 json으로 변환하여 전송
    		//변경 : map객체에 List<UserVo> userList, ->String pageNav를 담아 json으로 전송
    		// 1.Map 객체 생성 (Map<String, Object> resultMap = new HashMap<String, Object>(); 
    		// 2.Map 객체에 두개의 데이터를 담는다. 
    		//map.put("userList", userList);
    		//map.put("pageNav", pageNav);		//객체이름은 본인이 선언한 객체명으로 
    		//ajax callback 에서는 다음과 같이 접근이 가능
    		//  data.userList / data.pageNav
    		Map<String, Object> resultMap = new HashMap<String, Object>();
    		resultMap.put("userList", userList);
    		resultMap.put("pageNav", pageNav);
    		
	    	ObjectMapper om = new ObjectMapper();
	    	om.writeValue(response.getWriter(), resultMap);
	    	
    	}catch(IOException e){
    		e.printStackTrace();
    	} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
     * 사용자 ajax view
     * @param request
     * @param response
     */
    private void userAjax(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException{
		
    	RequestDispatcher rd = request.getRequestDispatcher("/user/userAjax.jsp");
    	rd.forward(request, response);
	}

	/**
     * 사용자 아이디 중복 체크
     * @param request
     * @param response
     */
    private void checkDupId(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
    	ObjectMapper om = new ObjectMapper();
    	
    	//result 0 : 중복건수 0 
    	//result 1 : 중복건수 1
    	
    	//중복 체크 로직 개발
    	//ajax를 통해 넘김 userId를 reuqest객체에서 받아온다.
    	//userId와 동일한 아이디가 t_user에 존재하는지 체크 하는 sql / dao 개발
    	//중복 건수를 map객체에 값으로 넘긴다. map.put("result", 중복건수);
    	
    	String userId = request.getParameter("userId");
    	
    	//IUserDao userDao = new UserDaoMybatis();
    	IUserService userService = new UserServiceImpl();
    	Map<String, Integer> map = new HashMap<String, Integer>();
    	
    	try {
			map.put("result", userService.checkDupId(userId));
			om.writeValue(response.getWriter(), map);
    		   		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
    
    
    //response.setContentType("text/json");    	
	//PrintWriter pw = response.getWriter(); 
	//pw.println("{'result' : '1' }");
		/*userDao.checkDupId(userId);
	pw.println("{\"result\" : \"1\" }");*/

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        	
		System.out.println("doPost : " + request.getRequestURI());
		
		String uri = request.getRequestURI();
    	uri = uri.replace(request.getContextPath(), "");
    	
    	if(uri.equals("/userDelete.do"))
    		userDelete(request, response);
    	else if(uri.equals("/userForm.do"))
    		userForm(request, response);
	}
    
	/**
	 * 사용자 form view 
	 * @param request
	 * @param response
	 */
  	//신규입력 / 수정 구분을 위한 파라미터 (method : insert -> 신규 / update -> 수정)
	private void userFormView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String method = request.getParameter("method");
		method = method == null ? "insert" : method;
		request.setAttribute("method", method);
		
		//신규 입력의 경우
		if(method.equals("insert")){
			//  /user/userForm.jsp으로 이동한다
		}
		//업데이트의 경우
		else if(method.equals("update")){
			
			try {
				//업데이트 대상 사용자 정보 조회
				//사용자 정보를 request 객체에 설정한다.
				//IUserDao userDao = new UserDaoMybatis();
				IUserService userService = new UserServiceImpl();
				Map<String, String> pMap = new HashMap<String, String>();
				pMap.put("userId", request.getParameter("userId"));
				
				UserVo userVo = userService.getUser(pMap);
				request.setAttribute("userVo", userVo);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		//  /user/userForm.jsp으로 이동한다
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userForm.jsp");
		rd.forward(request, response);
	}

	/**
	 * 사용자 정보 수정 / 신규 입력
	 * @param request
	 * @param response
	 */
	private void userForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//파라미터 설정
		String	userId		=	request.getParameter("userId");
		String	userNm		=	request.getParameter("userNm");
		String	userAlias	=	request.getParameter("userAlias");
		String	pass		=	request.getParameter("pass");
		
		 	
		
		UserVo userVo = new UserVo(userId, userNm, userAlias, pass, "system");
		//IUserDao userDao = new UserDaoMybatis();
		IUserService userService = new UserServiceImpl();
		
		//파일 part를 구한다.
		Part filePart = request.getPart("profilePicture");
		String filePath = "";
		//해당 파트의 파일 사이즈를 확인, 0보다 클경우만 파일생성처리
		if(filePart.getSize() > 0 ){
			String path = getServletContext().getRealPath("/uploadPicture");
			PartsUtil.uploadFile(filePart, path);
			filePath = "uploadPicture" + File.separator +  PartsUtil.getFileName(filePart.getHeader("content-disposition"));	
		}
		
		int	modifyCnt	=	0;
		
		//사용자 정보 수정 / 신규입력 구분
		String method = request.getParameter("method");
		
		try {
			if(method == null){
				
			}
			else if(method.equals("insert")){
				userVo.setPicturePath(filePath);
				modifyCnt = userService.insertUser(userVo);
				//사용자 정보 수정 성공 실패 여부 관계없이 사용자 성새 조회 페이지로 이동
				userView(request, response);
			}
			else if(method.equals("update")){
				Map<String,Object> map = new HashMap<String,Object>();
				
				//사용자가 파일을 업로드 한경우
				if(!filePath.equals("")){
					userVo.setPicturePath(filePath);
				}
				//사용자가 피일을 업로드 하지 않은경우
				else{
					//사용자가 사용자 이름만 수정, 파일은 그대로 유지
					Map<String, String> userinfo = new HashMap<String, String>();
					userinfo.put("userId", userId);
					UserVo orgUserVo = userService.getUser(userinfo);
					userVo.setPicturePath(orgUserVo.getPicturePath());
				}
				
				modifyCnt = userService.updateUser(userVo);
				//사용자 정보 수정 성공 실패 여부 관계없이 사용자 성새 조회 페이지로 이동
				userView(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 사용자 삭제
	 * @param request
	 * @param response
	 */
	private void userDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//userId를 파라미터로 받는다.
		String userId = request.getParameter("userId");
		Map<String, String> userinfo = new HashMap<String, String>();
		userinfo.put("userId", userId);
		
		//dao
		//IUserDao userDao = new UserDaoMybatis();
		IUserService userService = new UserServiceImpl();
		int deleteCnt = 0;
		try {
			deleteCnt = userService.deleteUser(userinfo);
			request.setAttribute("deleteCnt", deleteCnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//정상삭제된경우  --> user.do(사용자 리스트)
		if(deleteCnt == 1)
			user(request, response);
		//삭제 실패한경우 --> userView.do(사용자 상세화면)
		else
			userView(request, response);
		
	}

	/**
	 * 사용자 상세 조회 화면
	 * @param request
	 * @param response
	 */
	private void userView(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		//userId를 파라미터로 받는다.
		String userId = request.getParameter("userId");
		Map<String, String> userinfo = new HashMap<String, String>();
		userinfo.put("userId", userId);
		
		//dao
		//IUserDao userDao = new UserDaoMybatis();
		IUserService userService = new UserServiceImpl();
		
		try {
			UserVo userVo = userService.getUser(userinfo);
			request.setAttribute("userVo", userVo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/user/userView.jsp");
		rd.forward(request, response);
	}

	/**
	 * 사용자 리스트 조회
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	private void user(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//localhost:8090/user.do로 서블릿 접속
		//mybatis 모듈을 이용하여 userList 조회
		//조회된 userList를 /user/user.jsp에 전달
		// /user/user.jsp에서는 해당 결과를 화면에 출력
    	
    	//IUserDao userDao = new UserDaoMybatis();
		IUserService userService = new UserServiceImpl();
    	try {
			//request.setAttribute("userList", userDao.getUserList());
    		
    		//유저 리스트 페이징 처리
    		Map<String, String> paramMap = new HashMap<String, String>();
    		
    		// 사용자가 /user.do 로접속
    		// 1. page, pageSize를 파라미터로 보낸경우
    		///user.do?page=1&pageSize=10
    		
    		// 2.  page, pageSize를 파라미터로 안보낸경우
    		//		--> controller에서 default로 page = 1, pageSize = 10
    		
    		//page, pageSize
    		//조회 하고자 하는 페이지, 페이지 사이즈 : 파라미터로 넘어오지 않을경우 default 1, 10
    		String	page		=	request.getParameter("page");
    		String	pageSize	=	request.getParameter("pageSize");
    		
    		page		=	page == null ? "1" : page;
    		pageSize	=	pageSize == null ? String.valueOf(DefaultConst.PAGESIZE) : pageSize;
    		
	    	paramMap.put("page", page);
	    	paramMap.put("pageSize", pageSize);
	    	
    		request.setAttribute("userList", userService.getUserListPaging(paramMap));
    		
    		String html = NaviUtil.makePageNav(request.getContextPath() + "user.do", 
    											userService.getUserTotalCnt(),
    											Integer.valueOf(page), DefaultConst.PAGESIZE);
			request.setAttribute("pageNav", html);
			
				
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    	RequestDispatcher rd = request.getRequestDispatcher("/user/user.jsp");
    	rd.forward(request, response);
	}
}
