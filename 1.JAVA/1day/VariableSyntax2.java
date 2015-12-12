/*
	1. basic/VariableSyntax2.java
	학습내용
	1. 변수의 review
	2. 변수 종류
	 1) 멤버 면수 : 객체 생성시 heap 메모리에 객체의 구성 요소
	 2) 참조 변수 : reference variable
			    heap 메모리에 생성된 객체를 참조 및 관리
	3. 자바의 데이터 타입 종류
	 1) oracle에서 제공한 타입 : String, int
	 2) 사용자 정의 타입 : VariableSyntax
	  * 자바의 데이터 타입 개수는 제한이 없음
	4. 로직
	 - 데이터 회사명, 직원수, CEO 성함을 저장 및 출력
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
		vs.setCompanyName("부뜰정보시스템");
		vs.setCompanyValue(260);
		vs.setCompanyCEO("이화용 대표님");

		System.out.println(vs.getCompanyName() + ", " + vs.getCompanyValue() + ", " + vs.getCompanyCEO());
	}
}