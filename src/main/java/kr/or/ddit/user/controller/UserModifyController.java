package kr.or.ddit.user.controller;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.encrypt.kisa.sha256.KISA_SHA256;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.PartUtil;

@WebServlet("/userModify")
@MultipartConfig(maxFileSize=1024*1024*3, maxRequestSize=1024*1024*15)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);
    private IuserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	//사용자 수정 화면 요청
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userId = request.getParameter("userId");
		UserVo userVo = userService.getUser(userId);
		
		request.setAttribute("userVo", userVo);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}
	
	//사용자 수정
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("UserForm doPost");
		
		//사용자 보낸 파라미터를 사용해서 UserVo 인스턴스를 만들어서
		String userId	=	request.getParameter("userId");
		String name	 	=	request.getParameter("name");
		String alias	=	request.getParameter("alias");
		String addr1	=	request.getParameter("addr1");
		String addr2	=	request.getParameter("addr2");
		String zipcd	=	request.getParameter("zipcd");
		String birth	=	request.getParameter("birth");
		
		//사용자 보낸 평문 비밀번호 데이터
		String pass		=	request.getParameter("pass");
		pass = KISA_SHA256.encrypt(pass);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date birthDt = null;
		try {
			birthDt = sdf.parse(birth);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		UserVo userVo = new UserVo(name, userId, alias, pass, addr1, addr2, zipcd, birthDt);
		
		Part profile = request.getPart("profile");
		
		//사용자가 파일을 업로드 한경우
		if(profile.getSize() > 0 ){
			String contentDisposition = profile.getHeader("content-disposition");
			String filename = PartUtil.getFileName(contentDisposition);
			String ext = PartUtil.getExt(filename);
			
			String uploadPath = PartUtil.getUploadPath();
			File uploadFoler = new File(uploadPath);
			if(uploadFoler.exists()){
				//파일 디스크에 쓰기
				String filePath = uploadPath + File.separator + UUID.randomUUID().toString() + ext;
				userVo.setPath(filePath);
				userVo.setFilename(filename);
				
				profile.write(filePath);
				profile.delete();
			}
		}
		//update
		int updateCnt = userService.updateUser(userVo);
		
		//정상등록 -> 사용자 상세 조회 페이지로 이동
		if(updateCnt == 1){
			HttpSession session = request.getSession();
			session.setAttribute("msg", "등록되었습니다");
			response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
		}
		//비정상 --> 사용자 등록 페이지로 이동(수정 데이터 포함)
		else
			doGet(request, response);
	}

}
