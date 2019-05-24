package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService {
	private IuserDao userDao;
	
	public UserService(){
		userDao = new UserDao();
	}
	
	@Override
	public List<UserVo> userList() {
		return userDao.userList();
	}

	@Override
	public UserVo getUser(String userId) {
		return userDao.getUser(userId);
	}

}
