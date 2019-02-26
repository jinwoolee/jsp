package kr.or.ddit.prod.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

import org.junit.Test;

public class ProdServiceImplTest{
	
	@Test
	public void testGetProdByLgu(){
		/***Given***/
		IProdService prodDao = new ProdServiceImpl();
		String lgu = "P101";
		
		/***When***/
		List<ProdVo> prodList = prodDao.getProdByLgu(lgu);

		/***Then***/
		assertTrue(prodList.size() > 0);

	}

}
