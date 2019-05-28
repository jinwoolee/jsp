package kr.or.ddit.user.service;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

public interface IuserService {

	List<UserVo> userList();

	UserVo getUser(String userId);

	Map<String, Object> userPagingList(PageVo pageVo);

}
