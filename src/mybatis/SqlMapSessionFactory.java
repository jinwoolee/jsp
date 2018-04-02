package mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlMapSessionFactory {
	private static SqlSessionFactory sqlSessionFactory;
	static{
		try{
			String resource = "/mybatis/SqlMapConfig.xml";
			InputStream inputStream = Resources.getResourceAsStream(resource);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	public static SqlSessionFactory getSqlMapSessionFactory(){
		return sqlSessionFactory;
	}
}
