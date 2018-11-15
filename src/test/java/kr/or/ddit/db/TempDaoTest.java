package kr.or.ddit.db;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Test;

public class TempDaoTest {

	//테스트 메소드 명명 규칙(회사 마다 다름)
	//운영코드 메소드 이름 + Test
	//getTemp + Test : getTempTest
	@Test
	public void getTempTest() {
		/***Given : 주어진 상황***/
		TempDao tempDao = new TempDao();
		
		/***When : 어떤 동작 수행(메소드 호출)***/
		Map<String, Object> map = tempDao.getTemp();
		System.out.println("map : " + map);
		
		//select 'X' as result from dual
		// result : X

		/***Then : 결과가 어떠해야하는지 정의***/
		assertEquals("X", map.get("result"));
	}

}





