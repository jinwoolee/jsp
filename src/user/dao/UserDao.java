package user.dao;

import ibatis.SqlMapClientFactory;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapSession;

import user.model.UserVo;

public class UserDao implements IUserDao {
	private	SqlMapClient sqlMapClient;
	
	public UserDao(){
		sqlMapClient = SqlMapClientFactory.getSqlMapClient();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserVo> getUserList(SqlSession sqlSession) throws SQLException{		
		return sqlMapClient.queryForList("user.getUserList");
	}


	@Override
	public boolean checkLogin(SqlSession sqlSession, Map<String, String> userinfo) {
		boolean chk = false;
		
		try {
			UserVo user = (UserVo) sqlMapClient.queryForObject("user.loginCheck", userinfo);
			if(user != null){
				chk = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return chk;
	}

	@Override
	public UserVo getUser(SqlSession sqlSession, Map<String, String> userinfo) throws SQLException{
		SqlMapSession sqlMapSession = sqlMapClient.openSession();
		return (UserVo) sqlMapSession.queryForObject("user.getUser", userinfo);
	}

	@Override
	public List<UserVo> getUserListPaging(SqlSession sqlSession, Map<String, String> map)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserTotalCnt(SqlSession sqlSession ) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(SqlSession sqlSession, Map<String, String> userinfo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(SqlSession sqlSession, UserVo userVo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int insertUser(SqlSession sqlSession, UserVo userVo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int checkDupId(SqlSession sqlSession, String userId) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

}
