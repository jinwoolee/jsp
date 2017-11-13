package member.dao;

import java.util.List;

import member.model.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		
		IMemberDao memberDao = new MemberDaoImpl();
		
		List<MemberVo> memberList = memberDao.memberList();
		for(MemberVo vo : memberList)
			System.out.println(vo);
	}
}
