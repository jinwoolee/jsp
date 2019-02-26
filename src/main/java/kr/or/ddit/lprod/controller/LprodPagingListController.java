package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

@WebServlet("/lprodPagingList")
public class LprodPagingListController extends HttpServlet {

	private ILprodService lprodService;

	@Override
	public void init() throws ServletException {
		lprodService = new LprodServiceImpl();
	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// page, pageSize에 해당하는 파라미터 받기 ==> pageVo
		// 단 파라미터가 없을경우 page : 1, pageSize : 10
		String pageStr = request.getParameter("page");
		String pageSizeStr = request.getParameter("pageSize");

		int page = pageStr == null ? 1 : Integer.parseInt(pageStr);
		int pageSize = pageSizeStr == null ? 5 : Integer.parseInt(pageSizeStr);

		PageVo pageVo = new PageVo(page, pageSize);

		// userService 객체를 이용 userPagingList 조회
		Map<String, Object> resultMap = lprodService
				.selectLprodPagingList(pageVo);
		List<LprodVo> lprodList = (List<LprodVo>) resultMap.get("lprodList");
		int totalCnt = (Integer) resultMap.get("totalCnt");

		// reuqest객체에 조회된 결과를 속성으로 설정
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("totalCnt", totalCnt);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("page", page);

		// userPagingList를 화면으로 출력할 jsp로 위임(forward)
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(
				request, response);
	}

}
