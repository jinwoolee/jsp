package user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import mybatis.SqlMapSessionFactory;
import user.model.UserVo;

public class UserDaoMyBatisImpl implements UserDao{

	private	SqlSessionFactory sqlSessionFactory;
	
	public UserDaoMyBatisImpl() {
		sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}
	
	@Override
	public List<UserVo> getUserList() throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserVo> userList = sqlSession.selectList("user.getUserList");
		sqlSession.close();
		return userList;
	}
	
	@Override
	public List<UserVo> getUserListPaging(Map<String, Integer> map) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserVo> userList = sqlSession.selectList("user.getUserListPaging", map);
		sqlSession.close();
		return userList;
	}
	
	@Override
	public int getUserTotalCnt() throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int	cnt	=	(Integer)sqlSession.selectOne("user.getUserTotalCnt");
		sqlSession.close();
		return cnt;
	}

	@Override
	public boolean checkLogin(Map<String, String> userinfo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserVo getUser(Map<String, String> userinfo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserVo userVo = sqlSession.selectOne("user.getUser", userinfo);
		return userVo;
	}

	@Override
	public int insertUser(UserVo userVo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = sqlSession.insert("user.insertUser", userVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int updateUser(UserVo userVo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateCnt = sqlSession.insert("user.updateUser", userVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int deleteUser(Map<String, String> userinfo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int delCnt = sqlSession.insert("user.deleteUser", userinfo);
		sqlSession.commit();
		sqlSession.close();
		return delCnt;
	}
}
