package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserService implements UserServiceInf {

	@Override
	public List<UserVo> selectUserAll() {
		UserDao userDao = new UserDao();
		return userDao.selectUserAll();
	}

	@Override
	public UserVo selectUser(String userId) {
		UserDao userDao = new UserDao();
		return userDao.selectUser(userId);
	}

	@Override
	public UserVo selectUser(UserVo userVo) {
		UserDao userDao = new UserDao();
		return userDao.selectUser(userVo);
	}

	/**
	* Method : selectUserPageList
	* 작성자 : sem
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 조회
	*/
	@Override
	public Map<String, Object> selectUserPageList(PageVo pageVo) {
		UserDao userDao = new UserDao();
		
		//페이지에 해당하는 유저 리스트(1~10건 사이)
		List<UserVo> userList = userDao.selectUserPageList(pageVo);
		
		//페이지 내비게이션을 위한 전체 유저 리스트 조회
		int totalUserCnt = userDao.getUserCnt();
		
		//결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userList);
		resultMap.put("pageCnt", 
			(int)Math.ceil((double)totalUserCnt / pageVo.getPageSize()));
		
		return resultMap;
	}

	/**
	* Method : insertUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 입력
	*/
	@Override
	public int insertUser(UserVo userVo) {
		UserDao userDao = new UserDao();
		return userDao.insertUser(userVo);
	}
	
	/**
	* Method : deleteUser
	* 작성자 : sem
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		UserDao userDao = new UserDao();
		return userDao.deleteUser(userId);
	}

	/**
	* Method : updateUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 정보 수정
	*/
	@Override
	public int updateUser(UserVo userVo) {
		UserDao userDao = new UserDao();
		return userDao.updateUser(userVo);
	}

}






