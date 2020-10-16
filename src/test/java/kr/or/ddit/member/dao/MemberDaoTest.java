package kr.or.ddit.member.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.db.MybatisUtil;
import kr.or.ddit.member.model.MemberVo;

public class MemberDaoTest {

	@Test
	public void getMemberTest() {
		/***Given***/
		MemberDao memberDao = new MemberDao();
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
		MemberDaoI memberDao = new MemberDao();
		
		/***When***/
		List<MemberVo> memberList = memberDao.selectAllMember();

		/***Then***/
		assertEquals(15, memberList.size());
		//assertEquals("brown", memberList.get(0).getUserid());
	}
	
	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		MemberDaoI memberDao = new MemberDao();
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
		MemberDaoI memberDao = new MemberDao();
		SqlSession sqlSession = MybatisUtil.getSqlSession();

		/***When***/
		int totalCnt = memberDao.selectMemberTotalCnt(sqlSession);

		/***Then***/
		assertEquals(15, totalCnt);
	}
}







