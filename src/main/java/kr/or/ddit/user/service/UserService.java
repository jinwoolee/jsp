package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.model.UserVo;

public class UserService implements IuserService{

	/** 
	 * Method   : userList
	 * 작성자 : SEM
	 * 변경이력 : 
	 * @return 
	 * Method 설명 : 사용자 전체 리스트 조회 
	 */
	@Override
	public List<UserVo> userList() {
		//db에서 데이터를 조회했다고 가정
		List<UserVo> userList = new ArrayList<UserVo>();
		//브라운, 샐리, 제임스
		userList.add(new UserVo("브라운", "brown", "곰"));
		userList.add(new UserVo("코니", "cony", "토끼"));
		userList.add(new UserVo("샐리", "sally", "병아리"));
		userList.add(new UserVo("제임스", "james", "...."));
		userList.add(new UserVo("문", "moon", "달"));
				
		return userList;
	}

}


