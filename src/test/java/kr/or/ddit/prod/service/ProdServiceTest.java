package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class ProdServiceTest {
	
	private ProdServiceInf prodService;
	
	@Before
	public void setup(){
		prodService = new ProdService();
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
		Map<String, Object> resultMap = prodService.selectProdList(pageVo);
		List<ProdVo> prodList = (List<ProdVo>)resultMap.get("prodList");
		int totCnt = (Integer)resultMap.get("pageCnt"); 
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
		ProdVo prodVo = prodService.selectProdDetailTest(prod_id);

		/***Then***/
		assertNotNull(prodVo);
		assertEquals(prod_id, prodVo.getProd_id());

	}
	

}
