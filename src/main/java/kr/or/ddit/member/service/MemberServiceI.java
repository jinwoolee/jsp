package kr.or.ddit.member.service;

import java.util.List;

import kr.or.ddit.member.model.MemberVo;

public interface MemberServiceI {

	MemberVo getMember(String userId);
	
	List<MemberVo> selectAllMember();

}
