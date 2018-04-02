package day3;

import java.util.ArrayList;
import java.util.List;

public class BoardService {
	
	public List<BoardVo> getBoardList(){
		List<BoardVo> boardList = new ArrayList<BoardVo>();
		boardList.add(new BoardVo(1, "제목입니다.", "글내용입니다.", "brown", "brown", "2017-11-15"));
		boardList.add(new BoardVo(2, "제목입니다2.", "글내용입니다2.", "sally", "sally", "2017-11-15"));
		boardList.add(new BoardVo(3, "제목입니다3.", "글내용입니다3.", "cony", "cony", "2017-11-15"));
		boardList.add(new BoardVo(4, "제목입니다4.", "글내용입니다4.", "james", "james", "2017-11-15"));
		
		return boardList;
	}
}