/*
	1.basic/FinalTest1.java
	�н�����
	1. final Ű���� �н�
	  1. ��Ÿ������
	2. ���� ����
	  1. ���� - �� ���� �Ұ��� ���ȭ �Ǵ� ����
	  2. �޼ҵ� - ��� ����󿡼� ��ӵǴ� �޼ҵ�{} ����(������) �Ұ�
	  3. Ŭ���� - ��Ӱ��迡�� �ڽ��� ���� ������ ���� �� ��� �Ұ��� Ŭ����
*/
public class FinalTest1{
	static int no1 = 3;
	public static final int no2 = 10;

	public static void main(String[] args) {
		FinalTest1 ft = new FinalTest1();
		ft.no1 = 10;
		//ft.no2 = 20;

		FinalTest1.no1 = 100;
		System.out.println(FinalTest1.no2);
	}
		
}