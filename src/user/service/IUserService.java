package user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import user.model.UserVo;

public interface IUserService {
	//전체 사용자 정보 조회
	public List<UserVo> getUserList() throws SQLException;
	
	//전체 사용자 정보 조회(페이징)
	public List<UserVo> getUserListPaging(Map<String, String> map) throws SQLException;
	
	//사용자 전체 건수 조회
	public int getUserTotalCnt() throws SQLException;

	//사용자 인증
	public boolean checkLogin(Map<String, String> userinfo);
	
	//사용자 조회
	public UserVo getUser(Map<String, String> userinfo) throws SQLException;
	
	//사용자 삭제
	public int deleteUser(Map<String, String> userinfo) throws SQLException;
	
	//사용자 수정
	public int updateUser(UserVo userVo) throws SQLException;
	
	//사용자 입력
	public int insertUser(UserVo userVo) throws SQLException;
	
	//사용자 중복체크
	public int checkDupId(String userId) throws SQLException;
}
