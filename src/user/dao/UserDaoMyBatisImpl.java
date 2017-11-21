package user.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.SqlMapClientFactory;
import mybatis.SqlMapSessionFactory;
import user.model.UserVo;

public class UserDaoMyBatisImpl implements UserDao{

	private	SqlSessionFactory sqlSessionFactory;
	
	public UserDaoMyBatisImpl() {
		sqlSessionFactory = SqlMapSessionFactory.getSqlSessionFactory();
	}
	
	@Override
	public List<UserVo> getUserList() throws SQLException{
		SqlSession sqlSession = sqlSessionFactory.openSession(false);
		return sqlSession.selectList("user.getUserList");
	}
}
