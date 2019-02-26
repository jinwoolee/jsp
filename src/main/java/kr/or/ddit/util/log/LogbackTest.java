package kr.or.ddit.util.log;

import java.util.HashMap;

//simple logging facade 4 java
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogbackTest {
	
	private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	
	//1. logger 선언
	//private Logger logger = LoggerFactory.getLogger(Class);
	//private Logger logger = LoggerFactory.getLogger(LogbackTest.class);
	
	//private Logger logger = LoggerFactory.getLogger("kr.or.ddit.util.log.LogbackTest");
	//<logger name="kr.or.ddit" level="DEBUG"/>
		
	
	//private Logger logger = LoggerFactory.getLogger(String);
	
	public LogbackTest(){
		
		System.out.println("test");
		logger.trace("trace " + "test" );
		logger.debug("debug " + "test" );
		logger.info("info " + "test" );
		//if(로깅 레벨 < debug)
			logger.warn("warn " + "test" );
		
		//==================================
		
		logger.error("error " + "test" );		
		logger.error("error {}, {}, {}", "test", "test2", new HashMap() );
		
		
	}
	
	public static void main(String[] args){
		LogbackTest logbackTest = new LogbackTest();
	}
}










