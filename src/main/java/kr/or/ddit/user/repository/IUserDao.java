package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IUserDao {
	
	List<UserVo> getUserList();
}
