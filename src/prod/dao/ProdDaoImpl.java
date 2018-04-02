package prod.dao;

import java.sql.SQLException;
import java.util.List;






import mybatis.SqlMapSessionFactory;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import prod.vo.ProdVO;

import com.ibatis.sqlmap.client.SqlMapClient;

public class ProdDaoImpl implements IProdDao {
	private static IProdDao dao = new ProdDaoImpl();
	private SqlSessionFactory sqlSessionFactory;
	
	public ProdDaoImpl() {
		sqlSessionFactory = SqlMapSessionFactory.getSqlMapSessionFactory();
	}
	
	public static IProdDao getInstance(){
		return  dao ;
	}

	
	@Override
	public ProdVO getProdDetail(String prod_id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ProdVO> getProdName(String lprod_gu) throws SQLException {
		SqlSession sqlSession = sqlSessionFactory.openSession();
		List<ProdVO> list = sqlSession.selectList("prod.getprodlist", lprod_gu);
		sqlSession.close();
		return list;
	}

	

}
