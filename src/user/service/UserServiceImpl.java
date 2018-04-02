package user.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import user.dao.IUserDao;
import user.dao.UserDaoMybatis;
import user.model.UserVo;

public class UserServiceImpl implements IUserService{
	
	private SqlSessionFactory sqlSessionFactory;
	private IUserDao userDao;
	
	public UserServiceImpl(){
		sqlSessionFactory = SqlMapSessionFactory.getSqlMapSessionFactory();
		userDao = new UserDaoMybatis();
	}
	
	@Override
	public List<UserVo> getUserList() throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserVo> userList = userDao.getUserList(sqlSession);
		sqlSession.close();
		return userList;
	}

	@Override
	public List<UserVo> getUserListPaging(Map<String, String> map) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<UserVo> userList = userDao.getUserListPaging(sqlSession, map);
		sqlSession.close();
		return userList;
	}

	@Override
	public int getUserTotalCnt() throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int	cnt	=	userDao.getUserTotalCnt(sqlSession);
		sqlSession.close();
		return cnt;
	}

	@Override
	public boolean checkLogin(Map<String, String> userinfo) {
		return false;
	}

	@Override
	public UserVo getUser(Map<String, String> userinfo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		UserVo userVo = userDao.getUser(sqlSession, userinfo);
		sqlSession.close();
		return userVo;
	}

	@Override
	public int deleteUser(Map<String, String> userinfo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int deleteCnt = userDao.deleteUser(sqlSession, userinfo);
		sqlSession.commit();
		sqlSession.close();
		return deleteCnt;
	}

	@Override
	public int updateUser(UserVo userVo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int updateCnt = userDao.updateUser(sqlSession, userVo);
		sqlSession.commit();
		sqlSession.close();
		return updateCnt;
	}

	@Override
	public int insertUser(UserVo userVo) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int insertCnt = userDao.insertUser(sqlSession, userVo);
		sqlSession.commit();
		sqlSession.close();
		return insertCnt;
	}

	@Override
	public int checkDupId(String userId) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		int checkCnt = userDao.checkDupId(sqlSession, userId);
		sqlSession.close();
		return checkCnt;
	}

}
