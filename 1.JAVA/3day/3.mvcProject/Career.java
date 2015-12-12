public class Career {
	private String name;
	private String grade;
	private String phone;

	public Career() {}	//오버로딩

	public Career(String name, String grade) {	//오버로딩
		this.name = name;
		this.grade = grade;
	}

	public Career(String name, String grade, String phone) {	//오버로딩
		this.name = name;
		this.grade = grade;
		this.phone = phone;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		return "이름 : " + name + ", 분류 : " + grade + ", 전화번호 : " + phone;
	}
}