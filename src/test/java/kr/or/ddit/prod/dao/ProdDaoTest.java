package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class ProdDaoTest {
	
	private ProdDaoInf prodDao;
	
	@Before
	public void setup(){
		prodDao = new ProdDao();
	}
	
	/**
	* Method : selectProdListTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 제품 리스트 페이징 조회 테스트
	*/
	@Test
	public void selectProdListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		List<ProdVo> prodList = prodDao.selectProdList(pageVo);
		System.out.println(prodList);
		
		/***Then***/
		assertEquals(10, prodList.size());
	}
	
	/**
	* Method : selectProdDetailTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 제품 상세 조회
	*/
	@Test
	public void selectProdDetailTest(){
		/***Given***/
		String prod_id = "P102000001";

		/***When***/
		ProdVo prodVo = prodDao.selectProdDetailTest(prod_id);

		/***Then***/
		assertNotNull(prodVo);
		assertEquals(prod_id, prodVo.getProd_id());

	}
	
	/**
	* Method : selectProdCntTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 제품 전체건수 조회
	*/
	@Test
	public void selectProdCntTest(){
		/***Given***/

		/***When***/
		int totCnt = prodDao.selectProdCnt();

		/***Then***/
		assertEquals(74, totCnt);

	}
	

}
