package kr.or.ddit.user.repository;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import kr.or.ddit.user.model.UserVo;

public class UserDaoTest {

	/**
	* Method : getUserListTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListTest() {
		/***Given***/
		IUserDao userDao = new UserDao();

		/***When***/
		List<UserVo> userList = userDao.getUserList();

		/***Then***/
		assertEquals(5, userList.size());
	}
	
	/**
	* Method : getUserTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";
		IUserDao userDao = new UserDao();

		/***When***/
		UserVo userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
	}

}









