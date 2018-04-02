package prod.dao;

import java.sql.SQLException;
import java.util.List;

import prod.vo.ProdVO;

public interface IProdDao {

	//prod�빆紐� 媛��졇�삤湲� -  lprod_gu瑜� 留ㅺ컻蹂��닔濡� �빐�꽌 prod_lgu��鍮꾧탳 媛숈� 媛믪쓣 select 
	public List<ProdVO>  getProdName(String lprod_gu) throws SQLException;
	
	//�긽�꽭蹂닿린 - id瑜� 留ㅺ컻蹂��닔濡� �빐�꽌  prod_id�� 媛숈� �뻾�쓣 select
	public ProdVO  getProdDetail(String prod_id) throws SQLException;
}
