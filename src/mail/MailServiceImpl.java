package mail;

import java.util.Properties;

import javax.mail.Folder;
import javax.mail.Session;
import javax.mail.Store;

public class MailServiceImpl implements MailService {

	private Properties props;

	// 환경설정
	@Override
	public void setProps(Properties props) {
		this.props = props;
	}

	// 폴더조회
	@Override
	public Folder getFolder() {
//		Session session = Session.getDefaultInstance(props);
//		
//		try {
//			// 2) 프로토콜에 해당하는 Store 객체 생성 및 연결
//			Store store = session.getStore("imaps");
//			store.connect(host, username, password);
//			// 3) 메시지 폴더 객체 생성
//			Folder folder = store.getFolder("INBOX");
//			// 읽기 전용으로 폴더 개방
//			folder.open(Folder.READ_ONLY);
//			// 4) 메시지 접근, 최근 메시지 순으로 확인하기 위해 전체 메시지 건수 조회
//			int totalCount = folder.getMessageCount();
//			// 전체 메시지 건수를 기준으로 페이징
//			Message[] messages = folder.getMessages(totalCount-9, totalCount);
//			String format = "%s\t%s\t%s\t%s\n";
//			System.out.printf(format, "메일번호", "날짜", "제목", "발신자");
//			for(Message msg : messages){
//			System.out.println("============================================");
//			int num = msg.getMessageNumber();
//			Date sentDate = msg.getSentDate();
//			String subject = msg.getSubject();
//			// RFC822 규약에 따른 발신자 정보 파싱
//			String from =
//			((InternetAddress)msg.getFrom()[0]).toUnicodeString();
//			System.out.printf(format, num+"", sentDate, subject, from);
//			}
//			// 5) folder 폐쇄전 수정가능 모드에서 삭제된 메시지가 있다면 삭제
//			반영여부를 결정
//			folder.close(false);
//			store.close();
//			} catch (Exception e) {
//			e.printStackTrace();
//			}

		return null;
	}

}
