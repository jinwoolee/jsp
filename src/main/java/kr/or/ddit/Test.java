package kr.or.ddit;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Test {
	
	private static final Logger logger = LoggerFactory.getLogger(Test.class);
	
	public static void main(String[] args) {
		Test t = new Test();
		
		int a = 5;
		logger.debug("a : {}", a);	//5
		t.addNumber(a);
		logger.debug("a : {}", a);	//5
	}

	private void addNumber(int a) {
		a = a + 5;
	}

	/*private void addRanger(List<String> rangers) {
		rangers.add("sally");
	}*/
}






