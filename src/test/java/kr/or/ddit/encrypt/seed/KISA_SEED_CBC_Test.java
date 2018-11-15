package kr.or.ddit.encrypt.seed;

import static org.junit.Assert.*;

import org.junit.Test;

public class KISA_SEED_CBC_Test {

	/**
	* Method : EncryptTest
	* 작성자 : sem
	* 변경이력 :
	* Method 설명 : seed encrypt 테스트
	*/
	@Test
	public void EncryptTest() {
		/***Given***/
		String pass = "brownpass";

		/***When***/
		String encrypt = KISA_SEED_CBC.Encrypt(pass);
		String decrypt = KISA_SEED_CBC.Decrypt(encrypt);

		/***Then***/
		assertEquals("5207bbf01d00451c23800ae909470f26", encrypt);
		assertEquals(pass, decrypt);
	}

}





