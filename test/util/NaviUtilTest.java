package util;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/**
 * NaviUtilTest.java
 * 
 * @author jw
 * @since 2017. 11. 29.
 * @version 1.0
 * @see
 * 
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *	  수정일  		수정자				수정내용		
 *	----------		------		------------------------
 *	2017. 11. 29.    jw				최초 생성
 *
 * </pre>
 */
public class NaviUtilTest {
	
	private final String page1Respect = 
			
			(new StringBuffer()
							  .append("<li class=\"prev disabled\"><span>&lt;&lt;</span></li>")
							  .append("<li class=\"active\"><a href=\"user/userList?page=1&amp;pageSize=10\">1</a></li>")
							  .append("<li><a href=\"user/userList?page=2&amp;pageSize=10\">2</a></li>")
							  .append("<li><a href=\"user/userList?page=3&amp;pageSize=10\">3</a></li>")
							  .append("<li><a href=\"user/userList?page=4&amp;pageSize=10\">4</a></li>")
							  .append("<li><a href=\"user/userList?page=5&amp;pageSize=10\">5</a></li>")
							  .append("<li><a href=\"user/userList?page=6&amp;pageSize=10\">6</a></li>")
							  .append("<li><a href=\"user/userList?page=7&amp;pageSize=10\">7</a></li>")
							  .append("<li><a href=\"user/userList?page=8&amp;pageSize=10\">8</a></li>")
							  .append("<li><a href=\"user/userList?page=9&amp;pageSize=10\">9</a></li>")
							  .append("<li><a href=\"user/userList?page=10&amp;pageSize=10\">10</a></li>")
							  .append("<li class=\"next\"><a href=\"user/userList?page=2&amp;pageSize=10\">&gt;&gt;</a></li>")).toString();
			 
	
	private final String page2Respect = 
			(new StringBuffer()
							  .append("<li class=\"prev\"><a href=\"user/userList?page=1&amp;pageSize=10\">&lt;&lt;</a></li>")
							  .append("<li><a href=\"user/userList?page=1&amp;pageSize=10\">1</a></li>") 
							  .append("<li class=\"active\"><a href=\"user/userList?page=2&amp;pageSize=10\">2</a></li>")
							  .append("<li><a href=\"user/userList?page=3&amp;pageSize=10\">3</a></li>")
							  .append("<li><a href=\"user/userList?page=4&amp;pageSize=10\">4</a></li>")
							  .append("<li><a href=\"user/userList?page=5&amp;pageSize=10\">5</a></li>")
							  .append("<li><a href=\"user/userList?page=6&amp;pageSize=10\">6</a></li>")
							  .append("<li><a href=\"user/userList?page=7&amp;pageSize=10\">7</a></li>")
							  .append("<li><a href=\"user/userList?page=8&amp;pageSize=10\">8</a></li>")
							  .append("<li><a href=\"user/userList?page=9&amp;pageSize=10\">9</a></li>")
							  .append("<li><a href=\"user/userList?page=10&amp;pageSize=10\">10</a></li>")
							  .append("<li class=\"next\"><a href=\"user/userList?page=3&amp;pageSize=10\">&gt;&gt;</a></li>")).toString();
	
	private final String page7Respect = 
			(new StringBuffer().append("<li class=\"prev\"><a href=\"user/userList?page=6&amp;pageSize=10\">&lt;&lt;</a></li>")
							  .append("<li><a href=\"user/userList?page=2&amp;pageSize=10\">2</a></li>")
							  .append("<li><a href=\"user/userList?page=3&amp;pageSize=10\">3</a></li>")
							  .append("<li><a href=\"user/userList?page=4&amp;pageSize=10\">4</a></li>")
							  .append("<li><a href=\"user/userList?page=5&amp;pageSize=10\">5</a></li>")
							  .append("<li><a href=\"user/userList?page=6&amp;pageSize=10\">6</a></li>")
							  .append("<li class=\"active\"><a href=\"user/userList?page=7&amp;pageSize=10\">7</a></li>")
							  .append("<li><a href=\"user/userList?page=8&amp;pageSize=10\">8</a></li>")
							  .append("<li><a href=\"user/userList?page=9&amp;pageSize=10\">9</a></li>")
							  .append("<li><a href=\"user/userList?page=10&amp;pageSize=10\">10</a></li>")
							  .append("<li><a href=\"user/userList?page=11&amp;pageSize=10\">11</a></li>")
							  .append("<li class=\"next\"><a href=\"user/userList?page=8&amp;pageSize=10\">&gt;&gt;</a></li>")).toString();
	
	private final String page20Respect = 
			(new StringBuffer()
							  .append("<li class=\"prev\"><a href=\"user/userList?page=19&amp;pageSize=10\">&lt;&lt;</a></li>")
							  .append("<li><a href=\"user/userList?page=15&amp;pageSize=10\">15</a></li>")
							  .append("<li><a href=\"user/userList?page=16&amp;pageSize=10\">16</a></li>")
							  .append("<li><a href=\"user/userList?page=17&amp;pageSize=10\">17</a></li>")
							  .append("<li><a href=\"user/userList?page=18&amp;pageSize=10\">18</a></li>")
							  .append("<li><a href=\"user/userList?page=19&amp;pageSize=10\">19</a></li>")
							  .append("<li class=\"active\"><a href=\"user/userList?page=20&amp;pageSize=10\">20</a></li>")
							  .append("<li><a href=\"user/userList?page=21&amp;pageSize=10\">21</a></li>")
							  .append("<li class=\"next\"><a href=\"user/userList?page=21&amp;pageSize=10\">&gt;&gt;</a></li>")).toString();
	
	private final String page21Respect = 
			(new StringBuffer()
							  .append("<li class=\"prev\"><a href=\"user/userList?page=20&amp;pageSize=10\">&lt;&lt;</a></li>")
							  .append("<li><a href=\"user/userList?page=16&amp;pageSize=10\">16</a></li>")
							  .append("<li><a href=\"user/userList?page=17&amp;pageSize=10\">17</a></li>")
							  .append("<li><a href=\"user/userList?page=18&amp;pageSize=10\">18</a></li>")
							  .append("<li><a href=\"user/userList?page=19&amp;pageSize=10\">19</a></li>")
							  .append("<li><a href=\"user/userList?page=20&amp;pageSize=10\">20</a></li>")
							  .append("<li class=\"active\"><a href=\"user/userList?page=21&amp;pageSize=10\">21</a></li>")
							  .append("<li class=\"next disabled\"><span>&gt;&gt;</span></li>")).toString();
	
	/** 
	 * Method   : page1NavaiTest
	 * 최초작성일  : 2017. 11. 29. 
	 * 작성자 : jw
	 * 변경이력 :  
	 * Method 설명 : 페이지에 대한 내비게이션 생성 테스트 
	 */
	@Test
	public void pageNavaiTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(page1Respect, NaviUtil.makePageNav("user/userList", 202, 1, 10));
		assertEquals(page2Respect, NaviUtil.makePageNav("user/userList", 202, 2, 10));
		assertEquals(page7Respect, NaviUtil.makePageNav("user/userList", 202, 7, 10));
		assertEquals(page20Respect, NaviUtil.makePageNav("user/userList", 202, 20, 10));
		assertEquals(page21Respect, NaviUtil.makePageNav("user/userList", 202, 21, 10));
	}
	
	
	
	/** 
	 * Method   : calcStartIndex
	 * 최초작성일  : 2017. 11. 29. 
	 * 작성자 : jw
	 * 변경이력 :  
	 * Method 설명 : 페이지 내비게이션의 start Index 계산 
	 */
	@Test
	public void calcStartIndexTest() {
		/***Given***/
		
		/***When***/

		/***Then***/
		assertEquals(1, NaviUtil.calcStartIndex(1, 21));
		assertEquals(1, NaviUtil.calcStartIndex(2, 21));
		assertEquals(1, NaviUtil.calcStartIndex(3, 21));
		assertEquals(1, NaviUtil.calcStartIndex(4, 21));
		assertEquals(1, NaviUtil.calcStartIndex(5, 21));
		assertEquals(1, NaviUtil.calcStartIndex(6, 21));
		assertEquals(2, NaviUtil.calcStartIndex(7, 21));
		assertEquals(3, NaviUtil.calcStartIndex(8, 21));
		
	}
}
