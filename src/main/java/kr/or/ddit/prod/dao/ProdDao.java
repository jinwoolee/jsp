package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.prod.model.ProdVo;
import kr.or.ddit.util.model.PageVo;

public class ProdDao implements ProdDaoInf {

	/**
	* Method : selectProdList
	* 작성자 : sem
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 제품 리스트 페이징 조회
	*/
	@Override
	public List<ProdVo> selectProdList(PageVo pageVo) {
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<ProdVo> prodList = session.selectList("prod.selectProdList", pageVo);
		session.close();
		
		return prodList;
	}

	/**
	* Method : selectProdDetailTest
	* 작성자 : sem
	* 변경이력 :
	* @param prod_id
	* @return
	* Method 설명 : 제품 상세 조회
	*/
	@Override
	public ProdVo selectProdDetailTest(String prod_id) {
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		ProdVo prodVo = session.selectOne("prod.selectProdDetail", prod_id);
		session.close();
		
		return prodVo;
	}

	/**
	* Method : selectProdCnt
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 제품 전체건수조회
	*/
	@Override
	public int selectProdCnt() {
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totCnt = session.selectOne("prod.selectProdCnt");
		session.close();
		
		return totCnt;
	}

}
