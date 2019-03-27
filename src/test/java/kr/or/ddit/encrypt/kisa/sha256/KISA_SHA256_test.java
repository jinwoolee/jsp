package kr.or.ddit.encrypt.kisa.sha256;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * KISA_SHA256_test.java
 *
 * @author SEM
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정자 수정내용
 * ------ ------------------------
 * SEM 최초 생성
 * KISA SHA256 hash 알고리즘 테스트
 * </pre>
 */
public class KISA_SHA256_test {
	private Logger logger = LoggerFactory
			.getLogger(KISA_SHA256_test.class);
	
	/**
	 * Method : testEncrypt
	 * 작성자 : SEM
	 * 변경이력 :
	 * Method 설명 : 암호화 테스트
	 */
	@Test
	public void testEncrypt() {
		/***Given***/
		String plainText = "brown1234";
		
		/***When***/
		String encryptText = KISA_SHA256.encrypt(plainText);
		logger.debug("encryptText : {}", encryptText);
		
		/***Then***/
		assertEquals("c6347b73d5b1f7c77f8be828ee3e871c819578f23779c7d5e082ae2b36a44",
					 encryptText);

	}

}









