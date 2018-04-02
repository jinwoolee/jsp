package student.model;

public class StudentVo {
	private	String	stud_no; 
	private	String	stud_name; 
	private	String	stud_dep;
	
	public String getStud_no() {
		return stud_no;
	}
	public void setStud_no(String stud_no) {
		this.stud_no = stud_no;
	}
	public String getStud_name() {
		return stud_name;
	}
	public void setStud_name(String stud_name) {
		this.stud_name = stud_name;
	}
	public String getStud_dep() {
		return stud_dep;
	}
	public void setStud_dep(String stud_dep) {
		this.stud_dep = stud_dep;
	}
	@Override
	public String toString() {
		return "StudentVo [stud_no=" + stud_no + ", stud_name=" + stud_name
				+ ", stud_dep=" + stud_dep + "]";
	}
	
}
