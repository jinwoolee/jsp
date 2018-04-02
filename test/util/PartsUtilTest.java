package util;

import static org.junit.Assert.*;

import org.junit.Test;

public class PartsUtilTest {

	@Test
	public void getFileNametest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"testFileParam\"; filename=\"brown.png\"";

		/***When***/
		String fileName = PartsUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("brown.png", fileName);
	}
}
