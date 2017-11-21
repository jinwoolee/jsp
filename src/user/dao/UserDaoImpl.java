package user.dao;

import java.sql.SQLException;
import java.util.List;

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
}
