package kr.or.ddit.prod.model;

import java.util.Date;

public class ProdVo {
	private String prod_id;			//제품아이디
	private String prod_name;		//제품명
	private String lprod_nm;		//제품그룹명
	private Date prod_insdate;		//제품입력일
	private String buyer_name;		//바이어 이름
	private String buyer_mail;		//바이어 메일
	
	private int rnum;				//인덱스
	
	
	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	public Date getProd_insdate() {
		return prod_insdate;
	}
	public void setProd_insdate(Date prod_insdate) {
		this.prod_insdate = prod_insdate;
	}
	
	public String getBuyer_name() {
		return buyer_name;
	}
	public void setBuyer_name(String buyer_name) {
		this.buyer_name = buyer_name;
	}
	public String getBuyer_mail() {
		return buyer_mail;
	}
	public void setBuyer_mail(String buyer_mail) {
		this.buyer_mail = buyer_mail;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	@Override
	public String toString() {
		return "ProdVo [prod_id=" + prod_id + ", prod_name=" + prod_name
				+ ", lprod_nm=" + lprod_nm + ", prod_insdate=" + prod_insdate
				+ ", buyer_name=" + buyer_name + ", buyer_mail=" + buyer_mail
				+ ", rnum=" + rnum + "]";
	}
	
	
}
