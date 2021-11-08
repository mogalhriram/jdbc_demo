package JavaJDBC.JDBC.manage;

public class Student {
	private int sid;
	private String sName;
	private String sPhone;
	private String sCity;

	public Student(String sName, String sPhone, String sCity) {
		super();
		this.sName = sName;
		this.sPhone = sPhone;
		this.sCity = sCity;
	}

	public Student(int sid, String sName, String sPhone) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sPhone = sPhone;
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(int sid, String sName, String sPhone, String sCity) {
		super();
		this.sid = sid;
		this.sName = sName;
		this.sPhone = sPhone;
		this.sCity = sCity;
	}

	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sName=" + sName + ", sPhone=" + sPhone + ", sCity=" + sCity + "]";
	}

	public int getSid() {
		return sid;
	}

	public void setSid(int sid) {
		this.sid = sid;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsPhone() {
		return sPhone;
	}

	public void setsPhone(String sPhone) {
		this.sPhone = sPhone;
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
}
