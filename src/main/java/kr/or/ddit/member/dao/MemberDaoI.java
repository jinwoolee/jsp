package kr.or.ddit.member.dao;

import java.util.List;

import kr.or.ddit.member.model.MemberVo;

public interface MemberDaoI {
	
	MemberVo getMember(String userId);
	
	List<MemberVo> selectAllMember();
}
