package prod.service;

import java.sql.SQLException;
import java.util.List;

import prod.dao.IProdDao;
import prod.dao.ProdDaoImpl;
import prod.vo.ProdVO;


public class ProdServiceImpl  implements IProdService{
	private static IProdService service = new ProdServiceImpl();
	private IProdDao dao;
	
	private ProdServiceImpl(){
		dao = ProdDaoImpl.getInstance();
	}
	public static IProdService getInstance(){
		return (service == null) ? new ProdServiceImpl() : service;
	}
	
	@Override
	public ProdVO getProdDetail(String prod_id) {
		ProdVO  vo = null;
		try {
			vo = dao.getProdDetail(prod_id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return vo;
	}
	@Override
	public List<ProdVO> getProdName(String lprod_gu) {
		List<ProdVO>  list = null;
		try {
			list = dao.getProdName(lprod_gu);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
}
