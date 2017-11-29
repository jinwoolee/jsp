package user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ibatis.sqlmap.client.SqlMapClient;

import ibatis.SqlMapClientFactory;
import user.model.UserVo;

public class UserDaoImpl implements UserDao{

	private	SqlMapClient sqlMapClient;
	
	public UserDaoImpl() {
		sqlMapClient = SqlMapClientFactory.getSqlMapClient();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<UserVo> getUserList() throws SQLException{
		return sqlMapClient.queryForList("user.getUserList");
	}

	@Override
	public List<UserVo> getUserListPaging(Map<String, Integer> map) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getUserTotalCnt() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
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

	@Override
	public int insertUser(Map<String, String> userinfo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateUser(Map<String, String> userinfo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(Map<String, String> userinfo) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}
}
