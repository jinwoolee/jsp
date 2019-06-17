package kr.or.ddit.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.model.DbVo;
import kr.or.ddit.mybatis.MyBatisUtil;

public class DbDao implements IdbDao {

	@Override
	public List<DbVo> getUriClassMapping() {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<DbVo> uriClassMappingList = session.selectList("db.getUriClassMapping");
		session.close();
		
		return uriClassMappingList;
	}

}
