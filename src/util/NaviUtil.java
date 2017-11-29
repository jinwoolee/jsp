package util;

public class NaviUtil {
	
	
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
		
	    int pageNum = totalCnt/pageSize;	
	    int div = totalCnt%pageSize;
	    if(div > 0)
	    	pageNum++;
		
		for(int i = 1; i <= pageNum; i++){
			if( i == page)
				html += ("<li class=\"active\"><a href=\"" + url + "?page=" + i + 
						"&pageSize=" + pageSize + "\">" + i +"</a></li>");
			else
				html += ("<li><a href=\"" + url + "?page=" + i + 
							"&pageSize=" + pageSize + "\">" + i +"</a></li>");
		}
		
		return html;
	}
}
