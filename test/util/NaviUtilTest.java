package util;

import static org.junit.Assert.*;

import org.junit.Ignore;
import org.junit.Test;

public class NaviUtilTest {
	
	private final String EXPECTEPAGE1 = 
			new StringBuffer()
				.append("<li class=\"prev disabled\"><span>«</span></li>")
				.append("<li class=\"active\"><a href=\"user.do?page=1&amp;pageSize=10\">1</a></li>")
				.append("<li><a href=\"user.do?page=2&amp;pageSize=10\">2</a></li>")
				.append("<li><a href=\"user.do?page=3&amp;pageSize=10\">3</a></li>")
				.append("<li><a href=\"user.do?page=4&amp;pageSize=10\">4</a></li>")
				.append("<li><a href=\"user.do?page=5&amp;pageSize=10\">5</a></li>")
				.append("<li><a href=\"user.do?page=6&amp;pageSize=10\">6</a></li>")
				.append("<li><a href=\"user.do?page=7&amp;pageSize=10\">7</a></li>")
				.append("<li><a href=\"user.do?page=8&amp;pageSize=10\">8</a></li>")
				.append("<li><a href=\"user.do?page=9&amp;pageSize=10\">9</a></li>")
				.append("<li><a href=\"user.do?page=10&amp;pageSize=10\">10</a></li>")
				.append("<li class=\"next\"><a href=\"user.do?page=2&amp;pageSize=10\">»</a></li>").toString();
	
	private final String EXPECTEPAGE2 = 
			new StringBuffer()
				.append("<li class=\"prev\"><a href=\"user.do?page=1&amp;pageSize=10\">«</a></li>")
				.append("<li><a href=\"user.do?page=1&amp;pageSize=10\">1</a></li>")
				.append("<li class=\"active\"><a href=\"user.do?page=2&amp;pageSize=10\">2</a></li>")
				.append("<li><a href=\"user.do?page=3&amp;pageSize=10\">3</a></li>")
				.append("<li><a href=\"user.do?page=4&amp;pageSize=10\">4</a></li>")
				.append("<li><a href=\"user.do?page=5&amp;pageSize=10\">5</a></li>")
				.append("<li><a href=\"user.do?page=6&amp;pageSize=10\">6</a></li>")
				.append("<li><a href=\"user.do?page=7&amp;pageSize=10\">7</a></li>")
				.append("<li><a href=\"user.do?page=8&amp;pageSize=10\">8</a></li>")
				.append("<li><a href=\"user.do?page=9&amp;pageSize=10\">9</a></li>")
				.append("<li><a href=\"user.do?page=10&amp;pageSize=10\">10</a></li>")
				.append("<li class=\"next\"><a href=\"user.do?page=3&amp;pageSize=10\">»</a></li>").toString();
	
	//7 페이지 --> 페이지 내비게이션 2~11 (2 3 4 5 6 7 8 9 10 11)
	private final String EXPECTEPAGE7 = 
			new StringBuffer()
				.append("<li class=\"prev\"><a href=\"user.do?page=6&amp;pageSize=10\">«</a></li>")
				.append("<li><a href=\"user.do?page=2&amp;pageSize=10\">2</a></li>")
				.append("<li><a href=\"user.do?page=3&amp;pageSize=10\">3</a></li>")
				.append("<li><a href=\"user.do?page=4&amp;pageSize=10\">4</a></li>")
				.append("<li><a href=\"user.do?page=5&amp;pageSize=10\">5</a></li>")
				.append("<li><a href=\"user.do?page=6&amp;pageSize=10\">6</a></li>")
				.append("<li class=\"active\"><a href=\"user.do?page=7&amp;pageSize=10\">7</a></li>")
				.append("<li><a href=\"user.do?page=8&amp;pageSize=10\">8</a></li>")
				.append("<li><a href=\"user.do?page=9&amp;pageSize=10\">9</a></li>")
				.append("<li><a href=\"user.do?page=10&amp;pageSize=10\">10</a></li>")
				.append("<li><a href=\"user.do?page=11&amp;pageSize=10\">11</a></li>")
				.append("<li class=\"next\"><a href=\"user.do?page=8&amp;pageSize=10\">»</a></li>")
				.toString();
	
	//20 페이지 --> 페이지 내비게이션 15~21 (15 16 17 18 19 20 21) 
	private final String EXPECTEPAGE20 = 
			new StringBuffer()
				.append("<li class=\"prev\"><a href=\"user.do?page=19&amp;pageSize=10\">«</a></li>")
				.append("<li><a href=\"user.do?page=15&amp;pageSize=10\">15</a></li>")
				.append("<li><a href=\"user.do?page=16&amp;pageSize=10\">16</a></li>")
				.append("<li><a href=\"user.do?page=17&amp;pageSize=10\">17</a></li>")
				.append("<li><a href=\"user.do?page=18&amp;pageSize=10\">18</a></li>")
				.append("<li><a href=\"user.do?page=19&amp;pageSize=10\">19</a></li>")
				.append("<li class=\"active\"><a href=\"user.do?page=20&amp;pageSize=10\">20</a></li>")
				.append("<li><a href=\"user.do?page=21&amp;pageSize=10\">21</a></li>")
				.append("<li class=\"next\"><a href=\"user.do?page=21&amp;pageSize=10\">»</a></li>").toString();
		
	//21 페이지 --> 페이지 내비게이션 16~21 (16 17 18 19 20 21) 
		private final String EXPECTEPAGE21 = 
			new StringBuffer()
				.append("<li class=\"prev\"><a href=\"user.do?page=20&amp;pageSize=10\">«</a></li>")
				.append("<li><a href=\"user.do?page=16&amp;pageSize=10\">16</a></li>")
				.append("<li><a href=\"user.do?page=17&amp;pageSize=10\">17</a></li>")
				.append("<li><a href=\"user.do?page=18&amp;pageSize=10\">18</a></li>")
				.append("<li><a href=\"user.do?page=19&amp;pageSize=10\">19</a></li>")
				.append("<li><a href=\"user.do?page=20&amp;pageSize=10\">20</a></li>")
				.append("<li class=\"active\"><a href=\"user.do?page=21&amp;pageSize=10\">21</a></li>")
				.append("<li class=\"next disabled\"><span>»</span></li>").toString();
		
	//junit 테스트의 기본
	//기대하는 값, 실제 로직에의한 결과값이 일치하는지 비교
	
	@Test
	public void makePage1NavTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(EXPECTEPAGE1, NaviUtil.makePageNav("user.do", 202, 1, 10));
	}
	
	@Test
	public void makePage2NavTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(EXPECTEPAGE2, NaviUtil.makePageNav("user.do", 202, 2, 10));
	}
	
	@Test
	public void makePage7NavTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		assertEquals(EXPECTEPAGE7, NaviUtil.makePageNav("user.do", 202, 7, 10));
	}

	@Test
	public void makePage20NavTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		//15, 16, 17, 18, 19, 20, 21
		assertEquals(EXPECTEPAGE20, NaviUtil.makePageNav("user.do", 202, 20, 10));
	}
	
	@Test
	public void makePage21NavTest() {
		/***Given***/
		
		/***When***/
		
		/***Then***/
		//16, 17, 18, 19, 20, 21
		assertEquals(EXPECTEPAGE21, NaviUtil.makePageNav("user.do", 202, 21, 10));
	}
	
	
	@Test
	public void calcStartIndexTest(){
		/***Given***/

		/***When***/

		/***Then***/
		//총 페이지수가 21건이고, 현재 보는 페이지가 1페이지이면 : 내비게이션의 startIndex : 1
		assertEquals(1, NaviUtil.calcStartIndex(1));
		assertEquals(1, NaviUtil.calcStartIndex(2));
		assertEquals(1, NaviUtil.calcStartIndex(6));
		assertEquals(2, NaviUtil.calcStartIndex(7));
		assertEquals(15, NaviUtil.calcStartIndex(20));		//15, 16, 17, 18, 19, 20, 21
	}
	
	@Test
	public void calcEndIndexTest(){
		/***Given***/

		/***When***/

		/***Then***/
		//총 페이지수가 21건이고, 현재 보는 페이지가 1페이지이면 : 내비게이션의 endIndex : 10
		assertEquals(10, NaviUtil.calcEndIndex(1, 21));
		assertEquals(10, NaviUtil.calcEndIndex(2, 21));
		assertEquals(10, NaviUtil.calcEndIndex(6, 21));
		assertEquals(11, NaviUtil.calcEndIndex(7, 21));
		assertEquals(21, NaviUtil.calcEndIndex(20, 21));		// 15, 16, 17, 18, 19, 20, 21
	}
	
}
