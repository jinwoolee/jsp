package mail;

import java.util.Properties;

import javax.mail.Folder;

public interface MailService {

	//환경설정
	void setProps(Properties props);

	//메일 폴더 조회
	Folder getFolder();

}
