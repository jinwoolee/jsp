package ibatis;

import java.io.IOException; 
import java.io.Reader;
import java.nio.charset.Charset;
import java.sql.SQLException;

import com.ibatis.common.resources.Resources;
import com.ibatis.sqlmap.client.SqlMapClient;
import com.ibatis.sqlmap.client.SqlMapClientBuilder;

public class SqlMapClientFactory {
	private static SqlMapClient client = null;
	
	static {
		try{
			Reader rd = Resources.getResourceAsReader("/ibatis/sqlMapConfig.xml");
			client = SqlMapClientBuilder.buildSqlMapClient(rd);
			rd.close();
		}catch(IOException e){
			e.printStackTrace();
		}finally {
		}
	}
	
	public static SqlMapClient getSqlMapClient(){
		return client;
	}
}