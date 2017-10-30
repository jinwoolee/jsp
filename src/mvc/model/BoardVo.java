package mvc.model;

public class BoardVo {
	int		seq;
	String	title;
	String	content;
	String	reg_id;
	String	reg_dt;
	
	public BoardVo(int seq, String title, String content, String reg_id, String reg_dt) {
		this.seq		=	seq;
		this.title	=	title;
		this.content	=	content;
		this.reg_id	=	reg_id;
		this.reg_dt	=	reg_dt;
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getReg_id() {
		return reg_id;
	}
	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}
	public String getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(String reg_dt) {
		this.reg_dt = reg_dt;
	}
	@Override
	public String toString() {
		return "BoardVo [seq=" + seq + ", title=" + title + ", content=" + content + ", reg_id=" + reg_id + ", reg_dt="
				+ reg_dt + "]";
	}
}