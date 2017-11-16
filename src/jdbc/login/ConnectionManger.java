package jdbc.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManger {
	
	public static Connection getConnection() {
		final	String	driver		=	"oracle.jdbc.driver.OracleDriver";
		final	String	url			=	"jdbc:oracle:thin:@127.0.0.1:1521:orcl";
		final	String	user		=	"pc01";
		final	String	pass		=	"java";
		
		Connection conn 			=	null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pass);
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
	}
}
