package prod.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prod.service.IProdService;
import prod.service.ProdServiceImpl;
import prod.vo.ProdVO;



@WebServlet("/ProdServlet")
public class ProdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProdServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String lprod_gu = request.getParameter("gu");
		
		IProdService  service = ProdServiceImpl.getInstance();
		List<ProdVO> list = service.getProdName(lprod_gu);
		
		request.setAttribute("list", list);
	    RequestDispatcher   disp = request.getRequestDispatcher("1129/prodNames.jsp");
	    disp.forward(request, response);
	}

}
