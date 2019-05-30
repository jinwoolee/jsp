package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//사용아이디를 파라미터로부터 확인해서
		String userId = request.getParameter("userId");
		
		//사용자 정보(path)를 조회
		UserVo userVo = userService.getUser(userId);
		
		//path정보로 file을 읽어 들여서
		ServletOutputStream sos = response.getOutputStream();
		
		File file = new File(userVo.getPath());
		FileInputStream fis = new FileInputStream(file);
		byte[] buffer = new byte[512];
		
		//repsonse객체에 스트림으로 써준다
		while( fis.read(buffer, 0, 512) != -1){
			sos.write(buffer);
		}
		
		fis.close();
		sos.close();
	}

}








