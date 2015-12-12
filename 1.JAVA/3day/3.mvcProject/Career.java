public class Career {
	private String name;
	private String grade;
	private String phone;

	public Career() {}	//�����ε�

	public Career(String name, String grade) {	//�����ε�
		this.name = name;
		this.grade = grade;
	}

	public Career(String name, String grade, String phone) {	//�����ε�
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
		return "�̸� : " + name + ", �з� : " + grade + ", ��ȭ��ȣ : " + phone;
	}
}