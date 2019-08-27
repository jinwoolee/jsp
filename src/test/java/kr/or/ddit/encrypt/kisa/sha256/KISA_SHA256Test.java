package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class KISA_SHA256Test {
	private static final Logger logger = LoggerFactory.getLogger(KISA_SHA256Test.class);
	
	/**
	* Method : encryptTest
	* 작성자 : SEM-PC
	* 변경이력 :
	* Method 설명 : sah256 암호화 테스트
	*/
	@Test
	public void encryptTest() {
		/***Given***/
		String pass = "brown1234";

		/***When***/
		String encryptedPass = KISA_SHA256.encrypt(pass);
		logger.debug("encryptedPass : {}", encryptedPass);

		/***Then***/
		//c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44
		//assertEquals("예상값", "실제값");
	}
}




