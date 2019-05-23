package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVo;

public interface IuserService {
	
	/** 
	 * Method   : userList
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 사용자 전체 리스트 조회 
	 */
	List<UserVo> userList();
	
}
