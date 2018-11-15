package kr.or.ddit.user.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import kr.or.ddit.db.SqlFactoryBuilder;
import kr.or.ddit.user.model.UserVo;
import kr.or.ddit.util.model.PageVo;

public class UserDao implements UserDaoInf{
	
	//jspuser 테이블 데이터전체 조회 쿼리
	//select query id : selectUserAll
	
	public List<UserVo> selectUserAll(){
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();

		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		List<UserVo> userList = session.selectList("user.selectUserAll");

		session.close();
		
		return userList;
	}
	
	public UserVo selectUser(String userId){
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		UserVo userVo = session.selectOne("user.selectUser", userId);
		session.close();
		
		return userVo;
	}
	
	public UserVo selectUser(UserVo userVo){
		SqlSessionFactory factory =SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		//selectOne : 데이터가 한건일때
		//selectList : 여러건의 데이터를 조회
		//메소드 인자 : 문자열 = 네임스페이스(모듈명).쿼리아이디
		UserVo userResultVo = session.selectOne("user.selectUserByVo", userVo);
		session.close();
		
		return userResultVo;
	}

	@Override
	public List<UserVo> selectUserPageList(PageVo pageVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		List<UserVo> userList = session.selectList("user.selectUserPageList", pageVo);
		session.close();
		
		return userList;
	}

	/**
	* Method : getUserCnt
	* 작성자 : sem
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Override
	public int getUserCnt() {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int totalUserCnt = session.selectOne("user.getUserCnt");
		session.close();
		
		return totalUserCnt;
	}

	/**
	* Method : insertUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 사용자 등록
	*/
	@Override
	public int insertUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int insertCnt = session.insert("user.insertUser", userVo);
		
		session.commit();
		session.close();
		
		return insertCnt;
	}

	/**
	* Method : deleteUser
	* 작성자 : sem
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 :사용자 삭제
	*/
	@Override
	public int deleteUser(String userId) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int deleteCnt = session.delete("user.deleteUser", userId);
		
		session.commit();
		session.close();
		
		return deleteCnt;
	}

	/**
	* Method : updateUser
	* 작성자 : sem
	* 변경이력 :
	* @param userVo
	* Method 설명 : 사용자 정보 수정
	*/
	@Override
	public int updateUser(UserVo userVo) {
		SqlSessionFactory factory = SqlFactoryBuilder.getSqlSessionFactory();
		SqlSession session = factory.openSession();
		
		int updateCnt = session.delete("user.updateUser", userVo);
		
		session.commit();
		session.close();
		
		return updateCnt;
	}
	
}









