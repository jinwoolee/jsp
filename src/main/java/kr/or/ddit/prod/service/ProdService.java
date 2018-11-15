package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdDao;
import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public class ProdService implements ProdServiceInf {

	/**
	* Method : selectProdList
	* 작성자 : sem
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 제품 리스트 페이징 조회
	*/
	@Override
	public Map<String, Object> selectProdList(PageVo pageVo) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		ProdDaoInf prodDao = new ProdDao();
		List<ProdVo> prodList = prodDao.selectProdList(pageVo);
		int totalProdCnt = prodDao.selectProdCnt();
		
		resultMap.put("prodList", prodList);
		
		resultMap.put("pageCnt", 
						(int)Math.ceil((double)totalProdCnt / pageVo.getPageSize()));
		return resultMap;
	}

	/**
	* Method : selectProdDetailTest
	* 작성자 : sem
	* 변경이력 :
	* @param prod_id
	* @return
	* Method 설명 : 제품 상세 조회
	*/
	@Override
	public ProdVo selectProdDetailTest(String prod_id) {
		ProdDaoInf prodDao = new ProdDao();
		return prodDao.selectProdDetailTest(prod_id);
	}

}
