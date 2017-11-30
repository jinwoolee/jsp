package user.model;

import java.util.Date;

public class UserVo {
	private String	userId;
	private	String	userNm;
	private	String	userAlias;
	private	String	pass;
	private	String	reg_id;
	private	Date	reg_dt;
	
	public UserVo(String userId, String userNm, String userAlias, String pass) {
		this.userId		=	userId;
		this.userNm		=	userNm;
		this.userAlias	=	userAlias;
		this.pass		=	pass;
	}
	public UserVo() {
		
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
	public String getUserAlias() {
		return userAlias;
	}
	public void setUserAlias(String userAlias) {
		this.userAlias = userAlias;
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
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", userNm=" + userNm + ", userAlias=" + userAlias + ", pass=" + pass
				+ ", reg_id=" + reg_id + "]";
	}
	
}
