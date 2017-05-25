package jdbcdemos;

public class Student {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + ((marks == null) ? 0 : marks.hashCode());
		result = prime * result + ((sid == null) ? 0 : sid.hashCode());
		result = prime * result + ((sname == null) ? 0 : sname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
//		if (marks == null) {
//			if (other.marks != null)
//				return false;
//		} else if (!marks.equals(other.marks))
//			return false;
		if (sid == null) {
			if (other.sid != null)
				return false;
		} else if (!sid.equals(other.sid))
			return false;
		if (sname == null) {
			if (other.sname != null)
				return false;
		} else if (!sname.equals(other.sname))
			return false;
		return true;
	}

	private Integer sid;
	private String sname;
	//private Double marks;

	public Student(Integer sid, String sname ) {
		super();
		this.sid = sid;
		this.sname = sname;
		//this.marks = marks;
	}

	public Student() {
		super();

	}

	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}/*
	public Double getMarks() {
		return marks;
	}
	public void setMarks(Double marks) {
		this.marks = marks;
	}
*/
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + " ]";
	}

}
