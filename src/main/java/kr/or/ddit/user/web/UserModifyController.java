package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/userModify")
@MultipartConfig(maxFileSize = 1024*1024*5, maxRequestSize = 1024*1024*5*5)
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    private static final Logger logger = LoggerFactory.getLogger(UserModifyController.class);
    
    private IUserService userService;
    
    @Override
    public void init() throws ServletException {
    	userService = new UserService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		User user = userService.getUser(userId);
		request.setAttribute("user", user);
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	
	/**
	* Method : doPost
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 사용자 등록 요청
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		Date reg_dt_date = null;
		
		
		Part picture = request.getPart("picture");
		
		//사용자가 파일을 업로드 한경우
		String filename = "";
		String path = "";
		if(picture.getSize() > 0 ) {
			filename = FileuploadUtil.getFilename(
								picture.getHeader("Content-Disposition"));//사용자가 업로드한 파일명
			String realFilename = UUID.randomUUID().toString();
			String ext = FileuploadUtil.getFileExtension(
								picture.getHeader("Content-Disposition"));
			path = FileuploadUtil.getPath() + realFilename + ext;
			
			picture.write(path);
			
			//기존 파일은 삭제한다
			User orgUser = userService.getUser(userId);
			
			File file = new File(orgUser.getRealfilename());
			file.delete();
		}
		
		
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
		e.printStackTrace();
		}
		
		//validation
		Pattern p = Pattern.compile("^([a-zA-Z\\d\\.@]){5,20}$");
		Matcher m = p.matcher(userId);
		if(!m.find()) {
			request.setAttribute("userIdMsg", "사용자 아이디가 잘못 되었습니다");
			doGet(request, response);
		}
		else {
		
			logger.debug("user parameter : {}, {}, {}, {}, {}, {}, {}, {}",
					userId, userNm, alias, reg_dt, addr1, addr2, zipcode, pass);
			
			//사용자 등록
			User user = new User(userId, userNm, alias, reg_dt_date, addr1, addr2, zipcode, pass, filename, path);
			int insertCnt = 0;
			
			try{
				insertCnt = userService.updateUser(user);
				if(insertCnt == 1) {
					response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
				}
			}catch(Exception e) {
				e.printStackTrace();
				doGet(request, response);
			}
		}
	}

}








