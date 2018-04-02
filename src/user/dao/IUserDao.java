package user.dao;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import user.model.UserVo;

public interface IUserDao {
	
	//전체 사용자 정보 조회
	public List<UserVo> getUserList(SqlSession sqlSession) throws SQLException;
	
	//전체 사용자 정보 조회(페이징)
	public List<UserVo> getUserListPaging(SqlSession sqlSession, Map<String, String> map) throws SQLException;
	
	//사용자 전체 건수 조회
	public int getUserTotalCnt(SqlSession sqlSession) throws SQLException;

	//사용자 인증
	public boolean checkLogin(SqlSession sqlSession, Map<String, String> userinfo);
	
	//사용자 조회
	public UserVo getUser(SqlSession sqlSession, Map<String, String> userinfo) throws SQLException;
	
	//사용자 삭제
	public int deleteUser(SqlSession sqlSession, Map<String, String> userinfo) throws SQLException;
	
	//사용자 수정
	public int updateUser(SqlSession sqlSession, UserVo userVo) throws SQLException;
	
	//사용자 입력
	public int insertUser(SqlSession sqlSession, UserVo userVo) throws SQLException;
	
	//사용자 중복체크
	public int checkDupId(SqlSession sqlSession, String userId) throws SQLException;
}
