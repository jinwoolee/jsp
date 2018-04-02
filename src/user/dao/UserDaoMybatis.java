package user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import user.model.UserVo;

public class UserDaoMybatis implements IUserDao {
	
	private SqlSessionFactory sqlSessionFactory;
	
	public UserDaoMybatis(){
		sqlSessionFactory = SqlMapSessionFactory.getSqlMapSessionFactory();
	}
	
	@Override
	public List<UserVo> getUserList(SqlSession sqlSession) throws SQLException {
		return sqlSession.selectList("user.getUserList");
	}
	
	@Override
	public List<UserVo> getUserListPaging(SqlSession sqlSession, Map<String, String> map) throws SQLException {
		return sqlSession.selectList("user.getUserListPaging", map);
	}
	
	@Override
	public int getUserTotalCnt(SqlSession sqlSession) throws SQLException {
		return (Integer)sqlSession.selectOne("user.getUserTotalCnt");
	}

	@Override
	public boolean checkLogin(SqlSession sqlSession, Map<String, String> userinfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVo getUser(SqlSession sqlSession, Map<String, String> userinfo) throws SQLException {
		return sqlSession.selectOne("user.getUser", userinfo);
	}

	@Override
	public int deleteUser(SqlSession sqlSession, Map<String, String> userinfo) throws SQLException {
		return sqlSession.delete("user.deleteUser", userinfo);
	}

	@Override
	public int updateUser(SqlSession sqlSession, UserVo userVo) throws SQLException {
		return sqlSession.update("user.updateUser", userVo);
	}

	@Override
	public int insertUser(SqlSession sqlSession, UserVo userVo) throws SQLException {
		return sqlSession.insert("user.insertUser", userVo);
	}

	@Override
	public int checkDupId(SqlSession sqlSession, String userId) throws SQLException {
		return sqlSession.selectOne("user.checkDupId", userId);
	}
}
