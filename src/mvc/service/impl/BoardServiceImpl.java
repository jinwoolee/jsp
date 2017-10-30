package mvc.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import mvc.model.BoardVo;
import mvc.service.BoardService;

public class BoardServiceImpl implements BoardService{

	@Override
	public Map<String, Object> getBoardList() {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		for(int i = 1; i <= 10; i++)
			boardList.add(new BoardVo(i, "게시글 제목" + i, "게시글내용입니다", "userId", "2017-10-18"));
		
		resultMap.put("boardList", boardList);
		resultMap.put("totalCnt", boardList.size());
		
		return resultMap;
	}
	
}