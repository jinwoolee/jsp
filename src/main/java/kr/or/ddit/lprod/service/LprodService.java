package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.dao.ILprodDao;
import kr.or.ddit.lprod.dao.LprodDao;
import kr.or.ddit.lprod.model.Lprod;
import kr.or.ddit.util.MybatisUtil;

public class LprodService implements ILprodService{

	private ILprodDao lprodDao;
	
	public LprodService() {
		lprodDao = new LprodDao();
	}
	
	/**
	* Method : getLprodList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @return
	* Method 설명 : 제품 그룹 리스트 조회
	*/
	@Override
	public List<Lprod> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Lprod> lprodList = lprodDao.getLprodList(sqlSession);
		sqlSession.close();
		return lprodList;
	}

	/**
	* Method : getLprodPagingList
	* 작성자 : SEM-PC
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품 그룹 페이징 리스트 조회
	*/
	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		SqlSession sqlSession = MybatisUtil.getSession();
		
		int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);
		
		resultMap.put("lprodList", lprodDao.getLprodPagingList(sqlSession, page));
		resultMap.put("paginationSize", (int)Math.ceil( (double)totalCnt / page.getPagesize()));
		
		sqlSession.clearCache();
		
		return resultMap;
	}

}
