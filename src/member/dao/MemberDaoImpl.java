package member.dao;

import java.util.List; 

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import member.model.MemberVo;
import mybatis.SqlMapSessionFactory;

public class MemberDaoImpl implements IMemberDao{
	
	private SqlSessionFactory factory = SqlMapSessionFactory.getSqlSessionFactory();
	
	@Override
	public List<MemberVo> memberList() {
		SqlSession session = factory.openSession();
		return session.selectList("memberList");
	}
}