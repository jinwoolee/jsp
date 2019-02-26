package kr.or.ddit.lprod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.util.model.PageVo;

import org.junit.Before;
import org.junit.Test;

public class LprodDaoImplTest {

	private ILprodDao lprodDao;
	
	@Before
	public void setup(){
		lprodDao = new LprodDaoImpl();
	}

	/**
	 * Method : testGetAllLprod
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 제품 카테고리 조회
	 */
	@Test
	public void testGetAllLprod() {
		/***Given***/
				
		/***When***/
		List<LprodVo> lprodList = lprodDao.getAllLprod();

		/***Then***/
		assertTrue(lprodList.size() > 0);
	}
	
	/**
	 * Method : testSelectLprodPagingList
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 제품 카테고리 페이징 조회 테스트
	 */
	@Test
	public void testSelectLprodPagingList(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 5);
		
		/***When***/
		List<LprodVo> lprodList = lprodDao.selectLprodPagingList(pageVo);

		/***Then***/
		assertEquals(5, lprodList.size());
	}
	
	@Test
	public void testGetLprodCnt(){
		/***Given***/
		
		/***When***/
		int totalCnt = lprodDao.getLprodCnt();

		/***Then***/
		assertEquals(19, totalCnt);
	}

}
