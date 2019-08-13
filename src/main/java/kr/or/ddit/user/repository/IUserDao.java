package kr.or.ddit.user.repository;

import java.util.List;

import kr.or.ddit.user.model.User;

public interface IUserDao {
	
	List<User> getUserList();

	User getUser(String userId);

	/**
	* Method : getUserListOnlyHalf
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 리스트중 50명임의 조회
	*/
	List<User> getUserListOnlyHalf();
}
