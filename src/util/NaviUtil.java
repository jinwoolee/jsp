package util;

public class NaviUtil {
	
	private	static final int NAVISIZE = 10;
	
	//url : user.do
	//totalCnt : 202
	/**
	 * @param url : 페이지 이동 주소
	 * @param totalCnt : 전체 게시물 건수
	 * @param page : active page 
	 * @param pageSize : 페이지당 게시물 건수
	 * @return
	 */
	public static String makePageNav(String url, int totalCnt, int page, int pageSize){
		String html = "";
		 
	    int pageTotalCnt = pageTotalCnt(totalCnt, pageSize);
	    
	    //2페이지 : 2~11
	    //pageNum : 21, page : 2 , NVISIZE : 10  page + NAVISIZE= 12
	    
	    //이전 페이지
	    if(page <= 1)
	    	html += ("<li class=\"prev disabled\"><span>&lt;&lt;</span></li>");
	    else
	    	html += ("<li class=\"prev\"><a href=\"" + url + "?page=" + (page-1) + 
					"&amp;pageSize=" + pageSize + "\">&lt;&lt;</a></li>");
	    
	    
		for(int i = calcStartIndex(page, pageTotalCnt); i <= calcEndIndex(page, pageTotalCnt) ; i++){
			if( i == page)
				html += ("<li class=\"active\"><a href=\"" + url + "?page=" + i + 
						"&amp;pageSize=" + pageSize + "\">" + i +"</a></li>");
			else
				html += ("<li><a href=\"" + url + "?page=" + i + 
						"&amp;pageSize=" + pageSize + "\">" + i +"</a></li>");
		}
		
		//다음 페이지
	    if(page >= pageTotalCnt)
	    	html += ("<li class=\"next disabled\"><span>&gt;&gt;</span></li>");
	    else
	    	html += ("<li class=\"next\"><a href=\"" + url + "?page=" + (page+1) + 
					"&amp;pageSize=" + pageSize + "\">&gt;&gt;</a></li>");
	    
		return html;
	}

	/** 
	 * Method   : pageNavitionCnt
	 * 최초작성일  : 2017. 11. 29. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param totalCnt
	 * @param pageSize
	 * @return 
	 * Method 설명 : 페이지 전체 건수 
	 */
	private static int pageTotalCnt(int totalCnt, int pageSize) {
		int pageNum = totalCnt/pageSize;	
	    int div = totalCnt%pageSize;
	    if(div > 0)
	    	pageNum++;
		return pageNum;
	}

	/** 
	 * Method   : calcStartIndex
	 * 최초작성일  : 2017. 11. 29. 
	 * 작성자 : jw
	 * 변경이력 : 
	 * @param i
	 * @return 
	 * Method 설명 : 페이지 내비게이션의 startIndex를 계산한다
	 */
	public static int calcStartIndex(int page, int pageTotalCnt) {
		int startIndex = 1;
		
		//페이지가 내비게이션 사이즈의 절반 보다 작을때 : 1페이지부터 시작
		//페이지가 내비게이션 사이즈의 절반 보다 클때 : 해당 페이지 - 페이지 내비게이션 사이즈 절반 (ex page 7: 7 - (10/2) : 2  --> 2, 3, 4, 5, 6, 7, 8, 9, 10, 11) 
		if(NAVISIZE / 2 >= page)
			startIndex = 1;
		else
			startIndex = page - (NAVISIZE / 2); 
		
		return startIndex;
	}
	
	public static int calcEndIndex(int page, int pageTotalCnt) {
		int endIndex = NAVISIZE;
		
		//페이지가 내비게이션 사이즈의 절반 보다 작을때 : 1페이지부터 시작 - 10페이지 종료
		//페이지가 내비게이션 사이즈의 절반 보다 클때 : 해당 페이지 + 페이지 내비게이션 사이즈 절반 -1 (ex page 7: 7 + (10/2) -1 : 2  --> 2, 3, 4, 5, 6, 7, 8, 9, 10, 11)
		
		if(NAVISIZE / 2 >= page)
			endIndex = NAVISIZE;
		else
			endIndex = page + NAVISIZE/2 -1;
		
		endIndex = endIndex > pageTotalCnt ? pageTotalCnt : endIndex; 
		
		return endIndex;
	}
}
