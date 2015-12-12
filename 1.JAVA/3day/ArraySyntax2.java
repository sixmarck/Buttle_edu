/*
	1.basic/ArraySyntax2.java
*/

class ArraySyntax2 {
	static int[] m(){
		int[] i = {1, 2, 3, 4, 5, 6};
		return i;
	}

	static void m2(int[] v) {
		for (int i = 0; i<v.length ; i++ ) {
			System.out.print(v[i] + "\t");
		}
	}

	//?
	static String [] m3() {
		String [] v = {"노시영", "최성식", "밥이 맛나다"};
		return v;
	}

	static void m4(String[] v) {
		for (int i=0; i<v.length ; i++) {
			System.out.print(v[i] + "\t");
		}
	}

	public static void main(String[] args) {
		m2(m());
		System.out.print("\n");
		m4(m3());
	}
}