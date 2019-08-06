package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public class UserDaoMainTest {
	public static void main(String[] args) {
		//userDao.getUserList();
		IUserDao userDao = new UserDao();
		
		List<UserVo> userList = userDao.getUserList();
		
		if(userList.size() == 5)
			System.out.println("db 조회 성공");
		else
			System.out.println("db 조회 실패");
		
		
	}
}




