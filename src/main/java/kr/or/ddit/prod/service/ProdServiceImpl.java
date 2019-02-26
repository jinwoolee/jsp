package kr.or.ddit.prod.service;

import java.util.List;

import kr.or.ddit.prod.dao.IProdDao;
import kr.or.ddit.prod.dao.ProdDaoImpl;
import kr.or.ddit.prod.model.ProdVo;

public class ProdServiceImpl implements IProdService {
	
	private IProdDao prodDao;
	
	public ProdServiceImpl(){
		prodDao = new ProdDaoImpl();
	}
	
	/**
	 * Method : getProdByLgu
	 * 작성자 : SEM
	 * 변경이력 :
	 * @param lgu
	 * @return
	 * Method 설명 : 제품 카테고리 하위 제품 리스트 조회
	 */
	@Override
	public List<ProdVo> getProdByLgu(String lgu) {
		return prodDao.getProdByLgu(lgu);
	}

}
