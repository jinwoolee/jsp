package kr.or.ddit.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserServiceImpl;

// localhost/profileImg?userId=brown
// localhost/profileImg?userId=userId1
@WebServlet("/profileImg")
public class ProfileImgServlet extends HttpServlet{

	private IUserService userService;

	@Override
	public void init() throws ServletException {
		userService = new UserServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setHeader("Content-Disposition", "attachment; filename=profile.png"); 
		resp.setContentType("image.png"); 
		
		//1.사용자 아이디 파리미터 확인
		String userId = req.getParameter("userId");
		
		//2.해당 사용자 아이디로 사용자 정보 조회(realFilename)
		UserVo userVo = userService.selectUser(userId);
		
		//3-1.realFilename이 존재할 경우
		//3-1-1. 해당 경로의 파일을 FileInputStream으로 읽는다
		FileInputStream fis;
		if(userVo != null && userVo.getRealFilename() != null)
			fis	= new FileInputStream(new File(userVo.getRealFilename()));
		
		//3-2.realFilename이 존재하지 않을 경우
		//3-2-1. /upload/noimg.png (application.getRealPath())
		else{
			 ServletContext application = getServletContext();
			 String noimgPath = application.getRealPath("/upload/noimg.png");
			 fis = new FileInputStream(new File(noimgPath));
		}
		
		//4.FileInputStream을 response객체의 outputStream 객체에 write
		ServletOutputStream sos = resp.getOutputStream();
		
		byte[] buff = new byte[512];
		int len = 0;
		while((len = fis.read(buff)) > -1){
			sos.write(buff);
		}
		
		sos.close();
		fis.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		doGet(req, resp);
	}

}






