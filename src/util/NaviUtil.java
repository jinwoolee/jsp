package util;

public class NaviUtil {
	
	//페이지 내비게이션 사이즈
	private final static int NAVIPAGE_NO	=	10;
	
	//url : user.do
	//totalCnt : 202
	/**
	 * @param url : 페이지 이동 주소
	 * @param totalCnt : 전체 게시물 건수
	 * @param page : active page 
	 * @param pageSize : 페이지당 게시물 건수
	 * @return
	 */
	
	/*
	 * todo
	 * 1. 페이지 네비게이션 사이즈를 적용한다. (default : 10)
	 * 
	 * 2. 1 페이지 --> 페이지 내비게이션 1~10
	 *    2 페이지 --> 페이지 내비게이션 1~10 (1 2 3 4 5 6 7 8 9 10)
	 *    ..
	 *    7 페이지 --> 페이지 내비게이션 2~11 (2 3 4 5 6 7 8 9 10 11)
	 *    8 페이지 --> 페이지 내비게이션 3~12 (3 4 5 6 7 8 9 10 11 12)
	 */
	

	//url : user.do
	//totalCnt : 202
	//page : 21 (현재 페이지)
	//pageSize : 10 (페이지당 컨텐츠 수)
	public static String makePageNav(String url, int totalCnt, int page, int pageSize){
		String html = "";
		
		//전체 페이지 개수 : 202--> 21
	    int pageTotalCnt = calcPageTotalCnt(totalCnt, pageSize);
	    
	    //시작 페이지 인덱스(현재 21번 페이지, 시작 페이지 인덱스는 : 16)
	    int startIndex = calcStartIndex(page);
	    
	    //시작 페이지 인덱스(현재 21번 페이지, 마지막 페이지 인덱스는 : 21)
	    int endIndex = calcEndIndex(page, pageTotalCnt);
	    
	    //prev
	    if(page == 1)
	    	html += "<li class=\"prev disabled\"><span>«</span></li>";
	    else
	    	html +=	"<li class=\"prev\"><a href=\"" + url + "?page=" + (page-1) + 
						"&amp;pageSize=" + pageSize + "\">«</a></li>";	
	    	
	    
	    //<li class="prev disabled"><span>«</span></li>
	    //<li class="prev"><a href="/articles/questions?offset=0&amp;max=20&amp;sort=id&amp;order=desc">«</a></li>
	    
	    
		for(int i = startIndex; i <= endIndex; i++){
			if( i == page)
				html += ("<li class=\"active\"><a href=\"" + url + "?page=" + i + 
						"&amp;pageSize=" + pageSize + "\">" + i +"</a></li>");
			else
				html += ("<li><a href=\"" + url + "?page=" + i + 
						"&amp;pageSize=" + pageSize + "\">" + i +"</a></li>");
		}
		
		//next 
		if(page == pageTotalCnt)
	    	html += "<li class=\"next disabled\"><span>»</span></li>";
	    else
	    	html +=	"<li class=\"next\"><a href=\"" + url + "?page=" + (page+1) + 
						"&amp;pageSize=" + pageSize + "\">»</a></li>";
		
		return html;
	}
	
	//url : user.do
	//totalCnt : 202
	//page : 21 (현재 페이지)
	//pageSize : 10 (페이지당 컨텐츠 수)
	public static String makePageNavForFunc(int totalCnt, int page, int pageSize){
		String html = "";
		
		//전체 페이지 개수 : 202--> 21
	    int pageTotalCnt = calcPageTotalCnt(totalCnt, pageSize);
	    
	    //시작 페이지 인덱스(현재 21번 페이지, 시작 페이지 인덱스는 : 16)
	    int startIndex = calcStartIndex(page);
	    
	    //시작 페이지 인덱스(현재 21번 페이지, 마지막 페이지 인덱스는 : 21)
	    int endIndex = calcEndIndex(page, pageTotalCnt);
	    
	    //prev
	    if(page == 1)
	    	html += "<li class=\"prev disabled\"><span>«</span></li>";
	    else
	    	//변경 로직
	    	html +=	"<li class=\"prev\"><a onclick=\"javascirpt:getPage('" + (page-1) + "');\" href=\"#page" + (page-1) + "\">«</a></li>";
	    	
	    
	    //<li class="prev disabled"><span>«</span></li>
	    //<li class="prev"><a href="/articles/questions?offset=0&amp;max=20&amp;sort=id&amp;order=desc">«</a></li>
	    
	    
		for(int i = startIndex; i <= endIndex; i++){
			if( i == page)
				html += "<li class=\"active\"><a onclick=\"javascirpt:getPage('" + i + "');\" href=\"#page" + i + "\">"+ i + "</a></li>";
			else
				html += "<li><a onclick=\"javascirpt:getPage('" + i + "');\" href=\"#page" + i + "\">"+ i + "</a></li>";
		}
		
		//next 
		if(page == pageTotalCnt)
	    	html += "<li class=\"next disabled\"><span>»</span></li>";
	    else
	    	html +=	"<li class=\"next\"><a onclick=\"javascirpt:getPage('" + (page+1) + "');\" href=\"#page" + (page+1) + "\">»</a></li>";
		return html;
	}


	/**
	 * 페이지 전체 건수 계산  --> 21건 
	 * @param totalCnt : 전체 컨텐츠 갯수 (202)
	 * @param pageSize : 페이지당 컨텐츠 갯수 (10)
	 * @return
	 */
	private static int calcPageTotalCnt(int totalCnt, int pageSize) {
		int pageNum = totalCnt/pageSize;	
	    int div = totalCnt%pageSize;
	    if(div > 0)
	    	pageNum++;
		return pageNum;
	}

	
	/**
	 * 페이지 내비게이션의 시작 인덱스 계산
	 * @param page : 조회하는 페이지
	 * @param pageNum : 총 페이지 수
	 * @return
	 */
	public static int calcStartIndex(int page) {
		int startIndex = 1;
		
		//1~6 페이지 : startIndex 1
		//7 페이지 : startIndex 2
		//8 페이지 : startIndex 3
		
		//현재 페이지가  페이지 내비게이션의 절반보다 작을 경우 : startIndex : 1
		//그외  : 현재 페이지 - (페이지 내비게이션 사이즈/2)
		if(page <= NAVIPAGE_NO/2)
			startIndex = 1;
		else
			startIndex = page-(NAVIPAGE_NO/2);
		
		return startIndex;
	}

	/**
	 * 페이지 내비게이션의 종료 인덱스 계산
	 * @param page : 조회하는 페이지
	 * @param pageNum : 총 페이지 수
	 * @return
	 */
	public static int calcEndIndex(int page, int pageNum) {
		int endIndex = 1;
		//현재 페이지가  페이지 내비게이션의 절반보다 작을 경우 : startIndex : 1
		if(page <= NAVIPAGE_NO/2)
			endIndex = NAVIPAGE_NO;
		
		//NAVIPAGE_NO = 10일 때 6부터 else 로직이 실행된다.
		//6페이지 : 1~10
		//7페이지 : 2~11
		//page=7 + (10/2) -1 --> 11 
		//page=8 + (10/2) -1 --> 12
		//page=20 + (10/2) -1 --> 12
		else
			endIndex = page + (NAVIPAGE_NO/2) -1;
		
		endIndex = endIndex > pageNum ? pageNum : endIndex; 
		
		return endIndex;
	}
}
