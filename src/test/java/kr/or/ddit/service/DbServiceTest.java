package kr.or.ddit.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.model.DbVo;

import org.junit.Test;

public class DbServiceTest {
	
	@Test
	public void getUriClassMappingTest() {
		/***Given***/
		IdbService dbService = new DbService();

		/***When***/
		List<DbVo> uriClassMappingList = dbService.getUriClassMapping();

		/***Then***/
		assertNotNull(uriClassMappingList);
		assertEquals(2, uriClassMappingList.size());
	}

}
