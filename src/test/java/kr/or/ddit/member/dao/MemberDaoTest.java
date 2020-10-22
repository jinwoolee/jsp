package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {
	
	/*테스트 메소드 실행 사이클:
	 @BeforeClass (static)
		@Before => @Test => @After
		@Before => @Test => @After
		@Before => @Test => @After
	 @AfterClass (static)
	 */
	
	MemberDaoI memberDao;
	
	@Before
	public void setup() {
		memberDao = new MemberDao();
		String userid = "ljw";
		memberDao.deleteMember(userid);		
	}

	@Test
	public void getMemberTest() {
		/***Given***/
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When***/
		MemberVo memberVo = memberDao.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo, memberVo);
	}

	@Test
	public void selectAllMemberTest() {
		/***Given***/
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(15, memberList.size());
		//assertEquals("brown", memberList.get(0).getUserid());
	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 7);
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		//int page = 1;

		/***When***/
		List<MemberVo> memberList = memberDao.selectMemberPageList(sqlSession, pageVo);

		/***Then***/
		assertEquals(7, memberList.size());
	}
	
	@Test
	public void selectMemberTotalCntTest() {
		/***Given***/
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
	}
	
	@Test
	public void insertMemberTest() {
		/***Given***/
		MemberVo memberVo 
			= new MemberVo("ljw", "pass1234", "이진우", "sem",
							"대전 중구 중앙로 76", "영민빌딩 404호", "34940", 
							"D:\\profile\\sally.png", "sally.png");

		/***When***/
		int insertCnt = memberDao.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVo memberVo 
			= new MemberVo("ljw", "pass1234", "이진우", "sem",
							"대전 중구 중앙로 76", "영민빌딩 404호", "34940", 
							"D:\\profile\\sally.png", "sally.png");
		
		int insertCnt = memberDao.insertMember(memberVo);
		
		/***When***/
		memberVo.setAlias("sem_mod");
		int updateCnt = memberDao.updateMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, updateCnt);
	}
}












