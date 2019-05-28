package kr.or.ddit.user.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

/**
 * Servlet implementation class UserPaingController
 */
@WebServlet("/userPagingList")
public class UserPaingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IuserService userService;
	
    @Override
	public void init() throws ServletException {
    	userService = new UserService();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//page, pageSize 파라미터 받기 
		//page, pageSize 파라미터가 없을경우 page=1, pageSize = 10 기본값설정
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString); 
		int pageSize = pageSizeString == null ? 10 : Integer.parseInt(pageSizeString);
		
		//page, pageSize 파라미터를 이용 하여 pageVo 작성
		PageVo pageVo = new PageVo(page, pageSize);
		
		//pageVo를 이용한 사용자 페이징 리스트 조회
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>)resultMap.get("userList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		//request scope에서 사용자 리스트를 공유할 수 있도록 속성 설정
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVo", pageVo);
		
		//화면 출력을 담당하는 jsp에게 역할 위임
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);;
	}
}






