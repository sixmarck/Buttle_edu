/*
	1. basic/VariableSyntax2.java
	�н�����
	1. ������ review
	2. ���� ����
	 1) ��� ��� : ��ü ������ heap �޸𸮿� ��ü�� ���� ���
	 2) ���� ���� : reference variable
			    heap �޸𸮿� ������ ��ü�� ���� �� ����
	3. �ڹ��� ������ Ÿ�� ����
	 1) oracle���� ������ Ÿ�� : String, int
	 2) ����� ���� Ÿ�� : VariableSyntax
	  * �ڹ��� ������ Ÿ�� ������ ������ ����
	4. ����
	 - ������ ȸ���, ������, CEO ������ ���� �� ���
*/

class VariableSyntax2{
	private String companyName;
	private int companyValue;
	private String companyCEO;

	public VariableSyntax2(){}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyName(){
		return this.companyName;
	}

	public void setCompanyValue(int companyValue) {
		this.companyValue = companyValue;
	}

	public int getCompanyValue(){
		return this.companyValue;
	}

	public void setCompanyCEO(String companyCEO) {
		this.companyCEO = companyCEO;
	}

	public String getCompanyCEO(){
		return this.companyCEO;
	}

	public static void main(String[] args) {
		VariableSyntax2 vs = new VariableSyntax2();
		vs.setCompanyName("�ζ������ý���");
		vs.setCompanyValue(260);
		vs.setCompanyCEO("��ȭ�� ��ǥ��");

		System.out.println(vs.getCompanyName() + ", " + vs.getCompanyValue() + ", " + vs.getCompanyCEO());
	}
}