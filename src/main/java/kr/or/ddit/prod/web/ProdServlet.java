package kr.or.ddit.prod.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.prod.service.ProdService;
import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.util.model.PageVo;

/**
 * Servlet implementation class ProdServlet
 */
@WebServlet(urlPatterns={"/prodPageList", "/prodDetail"})
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uri = request.getRequestURI();
		if(uri.equals("/prodPageList"))
			prodList(request, response);
		else if(uri.equals("/prodDetail"))
			prodDetail(request, response);
	}

	/**
	* Method : prodDetail
	* 작성자 : sem
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 제품 상세 조회
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void prodDetail(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String prod_id = request.getParameter("prod_id");
		
		
		ProdServiceInf prodService = new ProdService();
		
		ProdVo prodVo = prodService.selectProdDetailTest(prod_id);
		
		request.setAttribute("prodVo", prodVo);
		request.getRequestDispatcher("/prod/prodDetail.jsp").forward(request, response);
	}

	/**
	* Method : prodList
	* 작성자 : sem
	* 변경이력 :
	* @param request
	* @param response
	* Method 설명 : 제품 리스트 페이징 조회 
	 * @throws IOException 
	 * @throws ServletException 
	*/
	private void prodList(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		int page = Integer.parseInt(request.getParameter("page"));
		int pageSize = Integer.parseInt(request.getParameter("pageSize"));
		PageVo pageVo = new PageVo(page, pageSize);
		
		ProdServiceInf prodService = new ProdService();
		Map<String, Object> resultMap = prodService.selectProdList(pageVo); 
		
		List<ProdVo> prodList = (List<ProdVo>)resultMap.get("prodList");
		int pageCnt = (Integer)resultMap.get("pageCnt");
		
		request.setAttribute("prodList", prodList);
		request.setAttribute("pageCnt", pageCnt);
		request.getRequestDispatcher("/prod/prodPageList.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
