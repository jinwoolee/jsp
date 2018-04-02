package ibatis;

import java.io.IOException;
import java.io.Reader;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient smc = null;
	static{
		  try{
			  Reader rd = Resources.getResourceAsReader("/ibatis/SqlMapConfig.xml");
			  smc = SqlMapClientBuilder.buildSqlMapClient(rd);
			  
			  rd.close();
		  }catch(IOException e){
			  e.printStackTrace();
		  }
	}
	
	public static SqlMapClient getSqlMapClient(){
		return smc;
	}
}
