package kr.or.ddit.dao;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.model.DbVo;

import org.junit.Test;

public class DbDaoTest {
	
	@Test
	public void getUriClassMappingTest() {
		/***Given***/
		IdbDao dbDao = new DbDao();

		/***When***/
		List<DbVo> uriClassMappingList = dbDao.getUriClassMapping();

		/***Then***/
		assertNotNull(uriClassMappingList);
		assertEquals(2, uriClassMappingList.size());
	}

}
