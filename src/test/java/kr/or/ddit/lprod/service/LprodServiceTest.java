package kr.or.ddit.lprod.service;

import static org.junit.Assert.*;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.util.MybatisUtil;

public class LprodServiceTest {

	private ILprodService lprodService;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		lprodService = new LprodService();	
	}
	
	/**
	* Method : getLpordListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 그룹 리스트 조회 테스트
	*/
	@Test
	public void getLpordListTest() {
		/***Given***/
	
		/***When***/
		List<Lprod> lprodList = lprodService.getLprodList();

		/***Then***/
		assertEquals(10, lprodList.size());
	}
	
	/**
	* Method : getLprodPagingListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 제품 그룹 페이징 리스트 조회 테스트
	*/
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page(1, 5);

		/***When***/
		Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		List<Lprod> lprodList = (List<Lprod>)resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");

		/***Then***/
		assertEquals(5, lprodList.size());
		assertEquals(2, paginationSize);
	}
	
	

}
