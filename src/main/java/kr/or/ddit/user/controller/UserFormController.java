package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Servlet implementation class UserFormController
 */
@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);
	
	private IuserService userService;
	    
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	//사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용자 등록 화면으로 이동
		request.getRequestDispatcher("/user/userForm.jsp").forward(request, response);
	}

	//사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("UserForm doPost");
		request.setCharacterEncoding("utf-8");
		
		//사용자 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId	=	request.getParameter("userId");
		String name	 	=	request.getParameter("name");
		String alias	=	request.getParameter("alias");
		String addr1	=	request.getParameter("addr1");
		String addr2	=	request.getParameter("addr2");
		String zipcd	=	request.getParameter("zipcd");
		String birth	=	request.getParameter("birth");
		String pass		=	request.getParameter("pass");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		UserVo userVo = null;
		try {
			userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		//사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVo dbUser = userService.getUser(userId);
		
		//등록된 사용자가 아닌경우 --> 정상입력이 가능한 상황
		if(dbUser == null){
			int insertCnt = userService.insertUser(userVo);
			
			//정상등록 된경우
			if(insertCnt == 1)
				response.sendRedirect(request.getContextPath()+"/userPagingList");				
		}
		//아이디가 중복된 경우
		else{
			//redirect, forward (O)
			//request.getRequestDispatcher("/userForm").forward(request, response);
			request.setAttribute("msg", "이미 존재하는 사용자 입니다");
			doGet(request, response);
		}
	}

}








