package kr.or.ddit.member.dao;

import kr.or.ddit.member.model.MemberVo;

public interface MemberDaoI {
	
	MemberVo getMember(String userId);
}
