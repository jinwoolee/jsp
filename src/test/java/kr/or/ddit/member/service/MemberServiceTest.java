package kr.or.ddit.member.service;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.PageVo;
import kr.or.ddit.member.model.MemberVo;

public class MemberServiceTest {
	private static final Logger logger = LoggerFactory.getLogger(MemberServiceTest.class);

	MemberServiceI memberService;
	
	@Before
	public void setup() {
		memberService = new MemberService();
		String userid = "ljw";
		memberService.deleteMember(userid);
	}
	
	@Test
	public void getMemberTest() {
		/***Given***/
		String userId = "brown";
		
		MemberVo answerMemberVo = new MemberVo();
		answerMemberVo.setUserid("brown");
		answerMemberVo.setPass("brownPass");

		/***When***/
		MemberVo memberVo = memberService.getMember(userId);
		
		/***Then***/
		assertEquals("brown", memberVo.getUserid());
		assertEquals("brownPass", memberVo.getPass());
		
		//assertEquals(answerMemberVo, memberVo);
	}

	@Test
	public void selectMemberPageListTest() {
		/***Given***/
		PageVo pageVo = new PageVo(1, 7);

		/***When***/
		//memberList 확인
		Map<String, Object> map = memberService.selectMemberPageList(pageVo);
		List<MemberVo> memberList = (List<MemberVo>)map.get("memberList");
		
		//생성해야할 page 수
		int pages = (int)map.get("pages");

		/***Then***/
		assertEquals(7, memberList.size());
		assertEquals(3, pages);
	}
	
	@Test
	public void localeListTest() {
		Locale[] locales = SimpleDateFormat.getAvailableLocales();
		for(Locale locale : locales) {
			logger.debug("{}", locale);
		}
	}
	
	@Test
	public void insertMemberDaoTest() {
		/***Given***/
		MemberVo memberVo 
			= new MemberVo("ljw", "pass1234", "이진우", "sem",
							"대전 중구 중앙로 76", "영민빌딩 404호", "34940", 
							"d:\\profile\\ljw.png", "ljw.png");

		/***When***/
		int insertCnt = memberService.insertMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateMemberTest() {
		/***Given***/
		MemberVo memberVo 
			= new MemberVo("ljw", "pass1234", "이진우", "sem",
							"대전 중구 중앙로 76", "영민빌딩 404호", "34940", 
							"d:\\profile\\ljw.png", "ljw.png");
		
		int insertCnt = memberService.insertMember(memberVo);
		
		/***When***/
		memberVo.setAlias("sem_mod");
		int updateCnt = memberService.updateMember(memberVo);

		/***Then***/
		assertEquals(1, insertCnt);
		assertEquals(1, updateCnt);
	}
}










