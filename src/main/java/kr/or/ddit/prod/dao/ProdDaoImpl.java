package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.mybatis.MybatisSqlSessionFactory;
import kr.or.ddit.lprod.model.LprodVo;
import kr.or.ddit.prod.model.ProdVo;

public class ProdDaoImpl implements IProdDao {

	/**
	 * Method : getProdByLgu
	 * 작성자 : SEM
	 * 변경이력 :
	 * @return
	 * Method 설명 : 카테고리 하위 제품 조회
	 */
	@Override
	public List<ProdVo> getProdByLgu(String lgu) {
		SqlSessionFactory sqlSessionFactory = MybatisSqlSessionFactory.getSqlSessionFactory();
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ProdVo> prodList = sqlSession.selectList("prod.getProdByLgu", lgu);
		sqlSession.close();
		return prodList;
	}

}
