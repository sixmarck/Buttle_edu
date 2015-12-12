class Test2{
	String score ( int kor, int math) {
		return kor + " " + math;
	}

	double avg ( int kor, int math ) {
		return (kor+math)/2;
	}

	public static void main(String[] args) {
		Test2 t = new Test2();

		String score = t.score(70, 80);
		System.out.println(score);

		double avg = t.avg(70, 80);
		System.out.println(avg);


	}

}