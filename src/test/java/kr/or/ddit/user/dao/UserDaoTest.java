package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDaoTest.class);
	
	//junit 실행순서
	//@BeforeClass가 적용된 메소드가 1회 실행
	
	//다음 구간은 @Test가 적용된 모든 메소드에 대해 반복 적용
	//@Before가 적용된 메소드 실행
	//@Test가 적용 메소드가 실행
	//@After가 적용된 메소드가 실행
	
	//@AfterClass가 적용된 메소드가 1회 실행
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	private IuserDao userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	
	/** 
	 * Method   : userListTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		/***Given***/

		/***When***/
		List<UserVo> userList = userDao.userList();

		/***Then***/
		//assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		logger.debug("usrList : {}", userList);
	}
	
	/** 
	 * Method   : getUserTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 조회 테스트
	 */
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo userVo = userDao.getUser(userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getName());
		logger.debug("userVo : {}", userVo);
	}
	
	//사용자 페이징 리스트 조회
	//고려사항
	//몇번째 페이지 조회인지?, 페이징 몇건씩 데이터를 보여줄건지 : 쿼리 실행 파라미터
	//정렬순서 ? : 로직 --> 파리미터화 시킬수 있다 
	// --> 우리는 사용자 아이디 순으로 정렬
	
	/** 
	 * Method   : userPagingListTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1, 10);

		/***When***/
		List<UserVo> userList = userDao.userPagingList(pageVo);

		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());	
	}
	
	/** 
	 * Method   : usersCntTest
	 * 작성자 : SEM
	 * 변경이력 :  
	 * Method 설명 : 사용자 전체수 조회 테스트 
	 */
	@Test
	public void usersCntTest(){
		/***Given***/

		/***When***/
		int usersCnt = userDao.usersCnt();

		/***Then***/
		assertEquals(105, usersCnt);

	}

}











