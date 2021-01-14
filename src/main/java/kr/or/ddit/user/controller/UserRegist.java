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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.user.service.UserServiceI;

@WebServlet("/userRegist")
public class UserRegist extends HttpServlet{
	
	private static final Logger logger = LoggerFactory.getLogger(UserRegist.class);
	private UserServiceI userService = new UserService();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/user/userRegist.jsp").forward(req, resp);
	}

	//사용자 정보 수정 요청 처리
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//파라미터를 읽기 전에 실행
		//servlet의 doPost 메소드 마다 실행 필요 ==> Filter
		req.setCharacterEncoding("utf-8");
		
		String userid	= req.getParameter("userid"); 
		String usernm	= req.getParameter("usernm"); 
		String pass		= req.getParameter("pass");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd");
		Date reg_dt		= null;
		
		try {
			reg_dt = sdf.parse(req.getParameter("reg_dt"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		String alias	= req.getParameter("alias");  
		String addr1	= req.getParameter("addr1");  
		String addr2	= req.getParameter("addr2");  
		String zipcode	= req.getParameter("zipcode");
		
		UserVo userVo = new UserVo(userid, usernm, pass, reg_dt, alias, addr1, addr2, zipcode);
		
		int updateCnt = 0;
		try {
			updateCnt = userService.registUser(userVo);			
		}catch(Exception e) {
			updateCnt = 0;
		}
		
		//사용자 등록이 정상적으로 된 경우	==> 사용자 페이징 리스트로 이동(1페이지)
		if(updateCnt == 1) {
			resp.sendRedirect(req.getContextPath()+"/pagingUser");
		}
		//사용자 수정이 비정상적으로 된 경우 ==> 사용자 등록 페이지로 이동(사용자가 입력한 값 설정)
		else {
			doGet(req, resp);
		}
	}
}










