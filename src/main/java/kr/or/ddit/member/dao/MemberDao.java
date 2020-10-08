package kr.or.ddit.member.dao;

import kr.or.ddit.member.model.MemberVo;

public class MemberDao implements MemberDaoI{

	@Override
	public MemberVo getMember(String userId) {
		//원래는 db에서 데이터를 조회하는 로직이 있어야 하나
		//우리는 controller기능에 집중 => 하드코딩을 통해 dao, service는 간략하게 넘어간다
		// Mock (가짜)
		
		MemberVo memberVo = new MemberVo();
		memberVo.setUserId("brown");
		memberVo.setPassword("passBrown");
		
		return memberVo;
	}

}
