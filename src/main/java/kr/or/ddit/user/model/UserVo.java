package kr.or.ddit.user.model;

public class UserVo {
	private String userId;			//사용자 아이디
	private String pass;			//사용자 비밀번호
	private String userNm;		//사용자 이름

	public UserVo() {
	
	}
	
	public UserVo(String userName) {
		this.userNm = userName;
	}

	public String getUserNm() {
		return userNm;
	}

	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	@Override
	public String toString() {
		return "UserVo [userId=" + userId + ", pass=" + pass + ", userName=" + userNm + "]";
	}

	
}
