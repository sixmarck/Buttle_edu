public class EndView {
	public static String[]  memt = {"�����", "����", "CEO", "��ü"};

	public static void comment(int index) {
		System.out.println("======================");
		System.out.println(memt[index-1] + "���� ���");
		System.out.println("======================");
	}

	public static void print(Object[] o) {			// �����ε�
		for(Object i : o){							// for each ��
			System.out.println(i.toString());
		}
		/* for ��
		for (int i=0;i<o.length; i++ ) {
			System.out.println(o[i].toString());
		}*/
	}

	public static void print(Object[][] o) {		// �����ε�
		for (int i=0; i<o.length; i++) {
			for (int j=0; j<o[j].length; j++) {
				System.out.println(o[i][j].toString());
			}
		}
	}

	/* ���� ���
	public static void careerPrint(Career[] c) {
		for (int i=0;i<c.length ; i++ ) {
			System.out.println(c[i].toString());
		}
	}

	public static void newcomerPrint(Newcomer[] n) {
		for (int i=0;i<n.length ; i++ ) {
			System.out.println(n[i].toString());
		}
	}

	public static void ceoPrint(CEO[] ceo) {
		for (int i=0;i<ceo.length ; i++ ) {
			System.out.println(ceo[i].toString());
		}
	}*/
}