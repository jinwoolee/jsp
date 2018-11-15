package kr.or.ddit.prod.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public interface ProdServiceInf {

	/**
	* Method : selectProdList
	* 작성자 : sem
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 제품 리스트 페이징 조회
	*/
	Map<String, Object> selectProdList(PageVo pageVo);

	/**
	* Method : selectProdDetailTest
	* 작성자 : sem
	* 변경이력 :
	* @param prod_id
	* @return
	* Method 설명 : 제품 상세 조회
	*/
	ProdVo selectProdDetailTest(String prod_id);

}
