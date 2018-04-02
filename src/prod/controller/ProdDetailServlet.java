package prod.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import prod.service.IProdService;
import prod.service.ProdServiceImpl;
import prod.vo.ProdVO;


@WebServlet("/ProdDetailServlet")
public class ProdDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public ProdDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String id = request.getParameter("id");
		
		IProdService  service = ProdServiceImpl.getInstance();
		ProdVO  vo = service.getProdDetail(id);
		
		request.setAttribute("vo", vo);
		RequestDispatcher   disp = request.getRequestDispatcher("1129/prodDetail.jsp");
	    disp.forward(request, response);
	}

}
