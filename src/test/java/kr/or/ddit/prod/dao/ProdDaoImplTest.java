package kr.or.ddit.prod.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

import org.junit.Test;

public class ProdDaoImplTest{
	
	@Test
	public void testGetProdByLgu(){
		/***Given***/
		IProdDao prodDao = new ProdDaoImpl();
		String lgu = "P101";
		
		/***When***/
		List<ProdVo> prodList = prodDao.getProdByLgu(lgu);

		/***Then***/
		assertTrue(prodList.size() > 0);

	}

}
