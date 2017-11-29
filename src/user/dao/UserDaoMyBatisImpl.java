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
		// TODO Auto-generated method stub
		return null;
	}
}
