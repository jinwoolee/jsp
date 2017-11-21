package user.dao;

import java.sql.SQLException;
import java.util.List;

import user.model.UserVo;


/**
 * UserDao.java
 * 
 * @author jw
 * @since 2017. 11. 21.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 11. 21.    jw				최초 생성
 *
 * </pre>
 */
public interface UserDao {
	
	List<UserVo> getUserList() throws SQLException;
}
