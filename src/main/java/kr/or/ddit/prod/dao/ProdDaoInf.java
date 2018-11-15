package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public interface ProdDaoInf {

	/**
	* Method : selectProdList
	* 작성자 : sem
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 제품 리스트 페이징 조회
	*/
	List<ProdVo> selectProdList(PageVo pageVo);

	/**
	* Method : selectProdDetailTest
	* 작성자 : sem
	* 변경이력 :
	* @param prod_id
	* @return
	* Method 설명 : 제품 상세 조회
	*/
	ProdVo selectProdDetailTest(String prod_id);

	/**
	* Method : selectProdCnt
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 제품 전체건수조회
	*/
	int selectProdCnt();

}
