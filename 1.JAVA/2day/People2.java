class People2 {
	String name;
	int kor;
	int eng;

	int total() {
		return 80 + 90; // 수학점수, 영어점수
	}

	public static void main(String[] args) {
		People2 p = new People2();
		System.out.println(p.total());
	}
}

/*
문제 3. total() 메서드의 매개변수를 이용하여 변경하시오. (손코딩)

문제 4. Line12의 p.total()을 변수를 이용 하여 출력하시오. (손코딩)


*/