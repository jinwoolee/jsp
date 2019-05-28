package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
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

	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		//1. List<UserVo>, userCnt를 필드로 하는 vo
		//2. List<Object> resultList = new ArrayList<Object>();
		//   resultList.add(userList);	
		//   resultList.add(usersCnt);
		//3. Map<String, Object> resultMap = new HashMap<String, Object>();
		//   resultMap.put("userList", userList);
		//	 resultMap.put("usersCnt, usersCnt);
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", userDao.userPagingList(pageVo));
		
		//usersCnt --> paginationSize 변경
		int usersCnt = userDao.usersCnt();
		//pageSize --> pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}

}















