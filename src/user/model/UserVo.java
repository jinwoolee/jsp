package user.model;

import java.util.Date;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class UserVo implements HttpSessionBindingListener{
	private	String	userId;			//사용자ID
	private	String	userNm;         //사용자이름
	private	String	userAlias;      //사용자별칭
	private	String	pass;           //비밀번호
	private	String	picturePath;    //프로필 사진
	private	String	reg_id;         //등록자 아이디
	private	Date	reg_dt;         //등록일시
	
	public UserVo(String userId, String userNm, String userAlias, String pass, String reg_id){
		this.userId 	=	userId;
		this.userNm		=	userNm;
		this.userAlias	=	userAlias;
		this.pass		=	pass;
		this.reg_id		=	reg_id;
	}
	
	public UserVo(){
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
	public String getUserNmDeco() {
		return "****" + userNm + "****";
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
	public String getPicturePath() {
		return picturePath;
	}
	public void setPicturePath(String picturePath) {
		this.picturePath = picturePath;
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
		return "UserVo [userId=" + userId + ", userNm=" + userNm
				+ ", userAlias=" + userAlias + ", pass=" + pass
				+ ", picturePath=" + picturePath + ", reg_id=" + reg_id
				+ ", reg_dt=" + reg_dt + "]";
	}

	@Override
	public void valueBound(HttpSessionBindingEvent event) {
		System.out.println("usreVo valueBound ");		
	}

	@Override
	public void valueUnbound(HttpSessionBindingEvent event) {
		System.out.println("usreVo valueUnBound ");
	}
}
