package kr.or.ddit.etc;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PaginationTest {

	@Test
	public void paginationTest() {
		/***Given***/
		int userTotCnt = 32;
		int pageSize = 5;
		
		/***When***/
		int pagination = (int)Math.ceil( (double)userTotCnt / pageSize);

		/***Then***/
		assertEquals(7, pagination);
	}
}
