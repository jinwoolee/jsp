package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

import org.junit.Before;
import org.junit.Test;

public class ProdDaoTest {
	private IprodDao prodDao;
	
	@Before
	public void setup(){
		prodDao = new ProdDao();
	}
	
	@Test
	public void getProdListTest() {
		/***Given***/
		String prod_lgu = "P201";

		/***When***/
		List<ProdVo> prodList = prodDao.getProdList(prod_lgu);
		
		/***Then***/
		assertNotNull(prodList);
		assertEquals(21, prodList.size());

	}

}
