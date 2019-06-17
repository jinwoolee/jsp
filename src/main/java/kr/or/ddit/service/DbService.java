package kr.or.ddit.service;

import java.util.List;

import kr.or.ddit.dao.DbDao;
import kr.or.ddit.dao.IdbDao;
import kr.or.ddit.model.DbVo;

public class DbService implements IdbService {
	private IdbDao dbDao;
	
	public DbService(){
		dbDao = new DbDao();
	}

	@Override
	public List<DbVo> getUriClassMapping() {
		return dbDao.getUriClassMapping();
	}

}
