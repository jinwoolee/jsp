package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

import org.junit.Before;
import org.junit.Test;


public class UserServiceTest {
	
	//사용자 전체리스트를 조회 하는 메소드
	//1.메소드 인자가 필요한가? : 별다른 인자는 불필요 X
	//2.리턴 타입은 뭐가 될까? : List<UserVo>
	//3.메소드 이름은 뭐가 적당하지?? : userList
	
	private IuserService userService;
	
	@Before
	public void setup(){
		userService = new UserService();
	}
	
	@Test
	public void userListTest(){
		/***Given***/
	
		/***When***/
		List<UserVo> userList = userService.userList();

		/***Then***/
		assertNotNull(userList);
		assertEquals(105, userList.size());
	}
	
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";

		/***When***/
		UserVo userVo = userService.getUser(userId);

		/***Then***/
		assertNotNull(userVo);
		assertEquals("brown", userVo.getUserId());
	}
	
}




