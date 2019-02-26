package kr.or.ddit.rangers.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.rangers.model.RangerVo;

public class RangersService {

	public List<String> getAll() {
		//db연동이 필요한 부분 --> 추후 
		List<String> rangersList = new ArrayList<String>();
		rangersList.add("brown");
		rangersList.add("cony");
		rangersList.add("sally");
		rangersList.add("james");
		rangersList.add("moon");
		
		return rangersList;
	}
	
	public List<RangerVo> getRangerVoAll(){
		List<RangerVo> rangersList = new ArrayList<RangerVo>();
		rangersList.add(new RangerVo("brown", "브라운", 8));
		rangersList.add(new RangerVo("cony", "코니", 9));
		rangersList.add(new RangerVo("sally", "샐리", 10));
		rangersList.add(new RangerVo("james", "제임스", 11));
		rangersList.add(new RangerVo("moon", "문", 12));
		
		return rangersList;
	}
	

}











