package user.dao;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

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
	
	//전체 사용자 정보 조회
	public List<UserVo> getUserList() throws SQLException;
	
	//전체 사용자 정보 조회(페이징)
	public List<UserVo> getUserListPaging(Map<String, Integer> map) throws SQLException;
	
	//사용자 전체 건수 조회
	public int getUserTotalCnt() throws SQLException;

	//사용자 인증
	public boolean checkLogin(Map<String, String> userinfo);
	
	//특정 유저 조회
	public UserVo getUser(Map<String, String> userinfo) throws SQLException;
}
