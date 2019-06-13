package kr.or.ddit.prod.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.prod.model.ProdVo;

public class ProdDao implements IprodDao{

	@Override
	public List<ProdVo> getProdList(String prod_lgu) {
		SqlSession session = MyBatisUtil.getSqlSession();
		List<ProdVo> prodList = session.selectList("getProdList", prod_lgu);
		session.close();
		return prodList;
	}

}






