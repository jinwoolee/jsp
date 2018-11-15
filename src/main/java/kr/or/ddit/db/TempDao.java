package kr.or.ddit.db;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class TempDao {
	
	public Map<String, Object> getTemp(){
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		return session.selectOne("temp.temp");
	}
}
