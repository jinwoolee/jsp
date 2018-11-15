package kr.or.ddit.etc;

import static org.junit.Assert.*;

import org.junit.Test;

public class PageEtcTest {

	/**
	* Method : test
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : 페이지 내비게이션 계산 테스트
	*/
	@Test
	public void pageNaviCalTest() {
		/***Given***/
		int totalUserCnt = 105;
		int pageSize = 10;

		/***When***/
		int naviSize = (int)Math.ceil((double)totalUserCnt / pageSize);

		/***Then***/
		assertEquals(11, naviSize);
	}

}






