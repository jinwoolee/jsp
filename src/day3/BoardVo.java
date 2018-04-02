package day3;

public class BoardVo {
	private int		seq;
	private String	title;
	private	String	cont;
	private	String	reg_id;
	private	String	name;
	private	String	reg_dt;
	
	public BoardVo(int seq, String title, String cont, String reg_id, String name, String reg_dt) {
		super();
		this.seq = seq;
		this.title = title;
		this.cont = cont;
		this.reg_id = reg_id;
		this.name = name;
		this.reg_dt = reg_dt;
	}
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCont() {
		return cont;
	}
	public void setCont(String cont) {
		this.cont = cont;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", cont=" + cont
				+ ", reg_id=" + reg_id + ", name=" + name + ", reg_dt="
				+ reg_dt + "]";
	}	
}