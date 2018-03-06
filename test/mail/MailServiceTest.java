package mail;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.mail.Folder;

import org.junit.Before;
import org.junit.Test;

public class MailServiceTest {
	
	private MailService mailService;
	
	String username = null;
	String password = null;
	String host = null;
	int port = 0;
	Properties props = null;
	
	//setup
	@Before
	public void setup() {
		mailService = new MailServiceImpl();
		
		username = "jwlee1728@naver.com";
		password = "leeyjwoo33190411";
		host = "imap.naver.com";
		port = 993;
		props = new Properties();
		//props.put("user")
		props.put("mail.imaps.host", host);
		props.put("mail.imaps.port", port);
		props.put("mail.imaps.starttls.enable", true);
		
		mailService.setProps(props);
	}
	
	//메일 수신 테스트
	@Test
	public void test() {
		/***Given***/

		/***When***/
		Folder folder = mailService.getFolder();

		/***Then***/
	}
	
	 

}
