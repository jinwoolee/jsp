package jdbc.login;

public class UserVo {
	private	String	usereId;
	private	String	userNm;
	private	String	pass;
	private	String	reg_dt;
	
	
	public UserVo(String usereId, String userNm, String pass, String reg_dt) {
		this.usereId = usereId;
		this.userNm = userNm;
		this.pass = pass;
		this.reg_dt = reg_dt;
	}
	public String getUsereId() {
		return usereId;
	}
	public void setUsereId(String usereId) {
		this.usereId = usereId;
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
		return "UserVo [usereId=" + usereId + ", userNm=" + userNm + ", pass=" + pass + ", reg_dt=" + reg_dt + "]";
	}
}