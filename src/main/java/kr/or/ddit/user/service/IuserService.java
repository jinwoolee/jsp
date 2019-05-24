package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IuserService {

	List<UserVo> userList();

	UserVo getUser(String userId);

}
