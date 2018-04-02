package day4;

/*
 * userId
 * userNm
 * pass
 * reg_id
 */
public class UserVo {
	
	private String	userId;			//사용자 아이디
	private	String	userNm;			//사용자 명
	private	String	pass;			//비밀번호
	private	String	reg_id;			//등록자 아이디
	
	public UserVo(String userId, String userNm, String pass, String reg_id) {
		super();
		this.userId = userId;
		this.userNm = userNm;
		this.pass = pass;
		this.reg_id = reg_id;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userNm=" + userNm + ", pass="
				+ pass + ", reg_id=" + reg_id + "]";
	}
}
