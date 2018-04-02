package prod.service;

import java.sql.SQLException;
import java.util.List;

import prod.vo.ProdVO;


public interface IProdService {

	//lprod_gu의 하위 prod 리스트 조회 
	public List<ProdVO>  getProdName(String lprod_gu);
	
	//prod 상세조회
	public ProdVO  getProdDetail(String prod_id) ; 
}
