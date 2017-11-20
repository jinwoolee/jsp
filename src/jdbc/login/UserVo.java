package jdbc.login;

public class UserVo {
	private	String	userId;
	private	String	userNm;
	private	String	pass;
	private	String	reg_dt;
	
	
	public UserVo() {
		
	}
	
	public UserVo(String userId, String userNm, String pass, String reg_dt) {
		this.userId = userId;
		this.userNm = userNm;
		this.pass = pass;
		this.reg_dt = reg_dt;
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
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userNm=" + userNm + ", pass=" + pass + ", reg_dt=" + reg_dt + "]";
	}
}