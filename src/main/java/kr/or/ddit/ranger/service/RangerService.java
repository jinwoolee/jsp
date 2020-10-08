package kr.or.ddit.ranger.service;

import java.util.ArrayList;
import java.util.List;

public class RangerService implements RangerServiceI {

	@Override
	public List<String> getRangers() {
		//dao 객체를 이용하여 db에 저장된 데이터를 조회하는 로직이 있어야 하나
		//현재 개발이 덜 되어있으므로 
		//가짜 데이터를 넘겨주는 로직으로 대체한다
		
		List<String> rangers = new ArrayList<String>();
		rangers.add("brown");
		rangers.add("cony");
		rangers.add("sally");
		rangers.add("moon");
		rangers.add("james");
		
		return rangers;
	}

}


